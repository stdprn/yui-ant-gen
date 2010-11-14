/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.task;

import java.io.File;

import org.seasar.akabana.yui.framework.gen.context.ActionDesc;
import org.seasar.akabana.yui.framework.gen.context.GenerationContext;
import org.seasar.akabana.yui.framework.gen.log.Logger;
import org.seasar.akabana.yui.framework.gen.util.FileUtil;

/**
 * @author tango
 * 
 */
public class GenActionTask extends AbstractGenActionScriptFileTask {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.task.AbstractGenActionScriptFileTask#doExecute()
	 */
	@Override
	protected void doExecute() {
		if (packageName == null) {
			throw new IllegalStateException("The *Package* parameter is null.");
		}
		if (baseName == null) {
			throw new IllegalStateException("The *Base* parameter is null.");
		}
		super.doExecute();
		ActionDesc actionDesc = createActionDesc();
		GenerationContext context = createContext(actionDesc);
		Logger.info("Actionを生成します...");
		Logger.info("ファイル名: " + actionDesc.getPackageName() + "." + actionDesc.getClassName());
		generator.generate(context);
	}

	/**
	 * ActionDescを生成します。
	 * 
	 * @return
	 */
	protected ActionDesc createActionDesc() {
		return new ActionDesc(config);
	}

	/**
	 * コンテキストを生成します。
	 * @param actionDesc
	 * @return
	 */
	protected GenerationContext createContext(ActionDesc actionDesc) {
		File file = FileUtil.createFile(config.getSourceDir(), actionDesc.getQualifiedName());
		return new GenerationContext(actionDesc, file, actionDesc.getTemplateName(),
			config.getEncoding(), overwrite);
	}

}
