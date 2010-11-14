/**
 * 
 */
package org.seasar.akabana.yui.framework.gen;

import java.io.File;

import org.apache.tools.ant.types.DataType;

/**
 * @author tango
 * 
 */
public class ProjectConfig extends DataType {

	/** ソースディレクトリ名 */
	protected String sourceDir;

	/** パッケージ名 */
	protected String packageName;

	/** ベース名 */
	protected String baseName;

	/** ASファイルのエンコーディング */
	protected String encoding;

	public ProjectConfig(String sourceDir, String packageName, String baseName) {
		this(sourceDir, packageName, baseName, "UTF-8");
	}

	public ProjectConfig(String sourceDir, String packageName, String baseName, String encoding) {
		super();
		this.sourceDir = sourceDir;
		this.packageName = packageName;
		this.baseName = baseName;
		this.encoding = encoding;
	}

	/**
	 * Returns the packageName.
	 * 
	 * @return the packageName
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * Returns the baseName.
	 * 
	 * @return the baseName
	 */
	public String getBaseName() {
		return this.baseName;
	}

	/**
	 * Returns the encoding.
	 * 
	 * @return the encoding
	 */
	public String getEncoding() {
		return this.encoding;
	}

	/**
	 * Returns the sourceDir.
	 * 
	 * @return the sourceDir
	 */
	public File getSourceDir() {
		if (sourceDir == null) {
			sourceDir = "src";
		}
		return new File(sourceDir);
	}

}
