/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.context;

import org.seasar.akabana.yui.framework.gen.ProjectConfig;


/**
 * @author tango
 *
 */
public abstract class AsClassDesc {

	protected ProjectConfig config;
	
	protected String baseName;
	
	/**
	 * インスタンスを生成します。
	 * @param packageName
	 * 			パッケージ名
	 * @param baseName
	 * 			元になるファイル名
	 */
	public AsClassDesc(ProjectConfig config){
		this.config = config;
		this.baseName = config.getBaseName();
	}

	
	/**
	 * Returns the packageName.
	 * 
	 * @return the packageName
	 */
	public String getPackageName() {
		return config.getPackageName();
	}

	
	/**
	 * Returns the fileName.
	 * 
	 * @return the fileName
	 * 			それぞれのクラス用にファイル名を生成して返します
	 */
	abstract public String getClassName();
	
	/**
     * 完全修飾名を返します。
     */
    public String getQualifiedName() {
        if (this.config.getPackageName() == null || this.config.getPackageName().isEmpty()) {
            return getClassName();
        }
        return this.getPackageName() + "." + getClassName();
    }
	
}
