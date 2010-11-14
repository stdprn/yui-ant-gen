/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.context;

import org.seasar.akabana.yui.framework.gen.GeneratorConstant;
import org.seasar.akabana.yui.framework.gen.ProjectConfig;

import freemarker.template.utility.StringUtil;


/**
 * @author tango
 *
 */
public class ActionDesc extends AsClassDesc {
	
	protected String templateName = GeneratorConstant.ACTION_TEMPLATE;
	
	/**
	 * @param config
	 */
	public ActionDesc(ProjectConfig config) {
		super(config);
	}

	/**
	 * Actionのクラス名を返します。
	 * @see org.seasar.akabana.yui.framework.gen.context.AsClassDesc#getClassName()
	 */
	@Override
	public String getClassName() {
		return StringUtil.capitalize(baseName) + GeneratorConstant.ACTION_SUFFIX;
	}

	/**
	 * テンプレート名を返します。
	 * @return
	 */
	public String getTemplateName() {
		return templateName;
	}
	
}
