/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.log;

/**
 * @author tango
 * 
 */
public final class Logger {

	/** デリゲート */
	private static volatile LoggerDelegate delegate = new NullLoggerDelegate();

	private Logger() {
	}

	/**
	 * デリゲートを設定します。
	 * 
	 * @param delegate
	 *            デリゲート
	 */
	public static void setDelegate(LoggerDelegate delegate) {
		Logger.delegate = delegate;
	}

	/**
	 * DEBUGレベルの情報を記録します。
	 * 
	 * @param message
	 * 
	 */
	public static void debug(String message) {
		delegate.debug(message);
	}

	/**
	 * DEBUGレベルの情報を記録します。
	 * 
	 * @param throwable
	 */
	public static void debug(Throwable throwable) {
		delegate.debug(throwable);
	}

	/**
	 * DEBUGレベルの情報を記録します。
	 * 
	 * @param message
	 * @param throwable
	 */
	public static void debug(String message, Throwable throwable) {
		delegate.debug(message, throwable);
	}

	/**
	 * INFOレベルの情報を記録します。
	 * 
	 * @param message
	 */
	public static void info(String message) {
		delegate.info(message);
	}

	/**
	 * INFOレベルの情報を記録します。
	 * 
	 * @param throwable
	 */
	public static void info(Throwable throwable) {
		delegate.info(throwable);
	}

	/**
	 * INFOレベルの情報を記録します。
	 * 
	 * @param message
	 * @param throwable
	 */
	public static void info(String message, Throwable throwable) {
		delegate.info(message, throwable);
	}

	/**
	 * ERRORレベルの情報を記録します。
	 * 
	 * @param message
	 */
	public static void error(String message) {
		delegate.error(message);
	}

	/**
	 * ERRORレベルの情報を記録します。
	 * 
	 * @param throwable
	 */
	public static void error(Throwable throwable) {
		delegate.error(throwable);
	}

	/**
	 * ERRORレベルの情報を記録します。
	 * 
	 * @param message
	 * @param throwable
	 */
	public static void error(String message, Throwable throwable) {
		delegate.error(message, throwable);
	}
}
