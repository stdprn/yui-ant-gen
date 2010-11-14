/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.task;

import org.seasar.akabana.yui.framework.gen.ProjectConfig;

/**
 * @author tango
 * 
 */
public abstract class AbstractGenActionScriptFileTask extends AbstractGenFileTask {

	/**
	 * プロジェクト設定
	 */
	protected ProjectConfig config;
	
	/**
	 * パッケージ名
	 */
	protected String packageName;

	/**
	 * 基本となるファイル名
	 */
	protected String baseName;
	
	/**
	 * 上書きフラグ
	 */
	protected boolean overwrite;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.task.AbstractGenFileTask#doExecute()
	 */
	@Override
	protected void doExecute() {
		super.doExecute();
		this.config = new ProjectConfig(sourceDir, packageName, baseName);
	}

	/**
	 * Sets the packageName
	 * 
	 * @param packageName
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * Sets the baseName
	 * 
	 * @param baseName
	 */
	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	/**
	 * Sets the overwrite
	 *
	 * @param overwrite
	 */
	public void setOverwrite(boolean overwrite) {
		this.overwrite = overwrite;
	}

}
