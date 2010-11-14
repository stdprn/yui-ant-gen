/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.log;

/**
 * @author tango
 * 
 */
public interface LoggerDelegate {

	/**
	 * DEBUGレベルの情報を記録します。
	 * 
	 * @param message
	 */
	void debug(String message);

	/**
	 * DEBUGレベルの情報を記録します。
	 * 
	 * @param throwable
	 */
	void debug(Throwable throwable);

	/**
	 * DEBUGレベルの情報を記録します。
	 * 
	 * @param message
	 * @param throwable
	 */
	void debug(String message, Throwable throwable);

	/**
	 * INFOレベルの情報を記録します。
	 * 
	 * @param message
	 */
	void info(String message);

	/**
	 * INFOレベルの情報を記録します。
	 * 
	 * @param throwable
	 */
	void info(Throwable throwable);

	/**
	 * INFOレベルの情報を記録します。
	 * 
	 * @param message
	 * @param throwable
	 */
	void info(String message, Throwable throwable);

	/**
	 * ERRORレベルの情報を記録します。
	 * 
	 * @param message
	 */
	void error(String message);

	/**
	 * ERRORレベルの情報を記録します。
	 * 
	 * @param throwable
	 */
	void error(Throwable throwable);

	/**
	 * ERRORレベルの情報を記録します。
	 * 
	 * @param message
	 * @param throwable
	 */
	void error(String message, Throwable throwable);

}
