/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.exception;

import org.seasar.akabana.yui.framework.gen.message.Message;

/**
 * @author tango
 * 
 */
public class GenNullPointerException extends GenException {

	private static final long serialVersionUID = 1L;

	/** {@code null} であるパラメータの名前 */
	protected final String parameterName;

	/**
	 * インスタンスを構築します。
	 * 
	 * @param parameterName
	 *            {@code null} であるパラメータの名前
	 */
	public GenNullPointerException(String parameterName) {
		super(Message.YUIGEN0001, parameterName);
		this.parameterName = parameterName;
	}

	/**
	 * {@code null} であるパラメータの名前を返します。
	 * 
	 * @return {@code null} であるパラメータの名前
	 */
	public String getParameterName() {
		return parameterName;
	}
}
