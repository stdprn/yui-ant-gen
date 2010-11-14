/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Locale;

import org.seasar.akabana.yui.framework.gen.context.GenerationContext;
import org.seasar.akabana.yui.framework.gen.exception.GenException;
import org.seasar.akabana.yui.framework.gen.log.Logger;
import org.seasar.akabana.yui.framework.gen.message.Message;
import org.seasar.akabana.yui.framework.gen.util.IOUtil;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * @author tango
 * 
 */
public class Generator {

	/** デフォルトのテンプレートディレクトリの名前 */
	protected static final String DEFAULT_TEMPLATE_DIR_NAME = "org/seasar/akabana/yui/framework/gen/template";

	/** FreeMarkerの設定 */
	protected final Configuration configuration;

	/**
	 * インスタンスを構築します。
	 */
	protected Generator() {
		this("UTF-8");
	}

	/**
	 * インスタンスを生成します。
	 * 
	 * @param templateEncoding
	 *            テンプレートファイルのエンコーディング
	 * @param templatePrimaryDir
	 *            テンプレートファイルを格納したプライマリディレクトリ、プライマリディレクトリを使用しない場合{@code null}
	 */
	public Generator(String templateEncoding) {
		if (templateEncoding == null) {
			throw new NullPointerException("templateFileEncoding");
		}
		this.configuration = new Configuration();
		configuration.setObjectWrapper(ObjectWrapper.DEFAULT_WRAPPER);
		configuration.setEncoding(Locale.getDefault(), templateEncoding);
		configuration.setTemplateLoader(new ClassTemplateLoader(this.getClass(), "/"+DEFAULT_TEMPLATE_DIR_NAME));
	}

	/**
	 * 生成します。
	 * 
	 * @param context
	 *            コンテキスト
	 */
	public void generate(GenerationContext context) {
		boolean exists = exists(context.getFile());
		if (!context.isOverwrite() && exists) {
			Logger.info(Message.YUIGEN0004.getMessage(context.getFile().getPath()));
			return;
		}
		File dir = context.getFile().getParentFile();
		if (dir != null) {
			mkdirs(dir);
		}
		Writer writer = openWriter(context);
		try {
			Template template = getTemplate(context.getTemplateName());
			process(template, context.getModel(), writer);
		} finally {
			IOUtil.close(writer);
		}
		if (exists) {
			Logger.info(Message.YUIGEN0003.getMessage(context.getFile().getPath()));
		} else {
			Logger.info(Message.YUIGEN0002.getMessage(context.getFile().getPath()));
		}
	}

	/**
	 * {@code file}が存在する場合に{@code true}を返します。
	 * 
	 * @param file
	 *            ファイル
	 * @return {@code file}が存在する場合は{@code true}、そうでない場合は{@code false}
	 */
	protected boolean exists(File file) {
		return file.exists();
	}

	/**
	 * ディレクトリを生成します。
	 * 
	 * @param dir
	 *            ディレクトリ
	 */
	protected void mkdirs(File dir) {
		dir.mkdirs();
	}

	/**
	 * {@link Writer}を開きます。
	 * 
	 * @param context
	 *            コンテキスト
	 * @return {@link Writer}
	 */
	protected Writer openWriter(GenerationContext context) {
		Charset charset = Charset.forName(context.getEncoding());
		return new BufferedWriter(new OutputStreamWriter(createFileOutputStream(context.getFile()),
			charset));
	}

	/**
	 * ストリームを作成します。
	 * 
	 * @param file
	 *            ファイル
	 * @return ストリーム
	 */
	protected OutputStream createFileOutputStream(File file) {
		try {
			return new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			throw new GenException(Message.YUIGEN9001, e, e);
		}
	}

	/**
	 * テンプレートを取得します。
	 * 
	 * @param name
	 *            テンプレートの名前
	 * @return テンプレート
	 */
	protected Template getTemplate(String name) {
		try {
			return configuration.getTemplate(name);
		} catch (IOException e) {
			throw new GenException(Message.YUIGEN9001, e, e);
		}
	}

	/**
	 * テンプレートを処理します。
	 * 
	 * @param template
	 *            テンプレート
	 * @param dataModel
	 *            データモデル
	 * @param writer
	 *            ライタ
	 */
	protected void process(Template template, Object dataModel, Writer writer) {
		try {
			template.process(dataModel, writer);
		} catch (IOException e) {
			throw new GenException(Message.YUIGEN9001, e, e);
		} catch (TemplateException e) {
			throw new GenException(Message.YUIGEN9001, e, e);
		}
	}
}
