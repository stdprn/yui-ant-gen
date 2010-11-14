/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.log;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.Task;

/**
 * @author tango
 * 
 */
public class TaskLoggerDelegate implements LoggerDelegate {

	protected final Task task;

	/**
	 * インスタンスを生成します。
	 * 
	 * @param task
	 *            Antタスク
	 */
	public TaskLoggerDelegate(Task task) {
		if (task == null) {
			throw new NullPointerException("task");
		}
		this.task = task;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.log.LoggerDelegate#debug(java.lang.String)
	 */
	@Override
	public void debug(String message) {
		this.task.log(message, Project.MSG_DEBUG);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.log.LoggerDelegate#debug(java.lang.Throwable)
	 */
	@Override
	public void debug(Throwable throwable) {
		this.task.log(throwable, Project.MSG_DEBUG);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.log.LoggerDelegate#debug(java.lang.String,
	 *      java.lang.Throwable)
	 */
	@Override
	public void debug(String message, Throwable throwable) {
		this.task.log(message, throwable, Project.MSG_DEBUG);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.log.LoggerDelegate#info(java.lang.String)
	 */
	@Override
	public void info(String message) {
		this.task.log(message, Project.MSG_INFO);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.log.LoggerDelegate#info(java.lang.Throwable)
	 */
	@Override
	public void info(Throwable throwable) {
		this.task.log(throwable, Project.MSG_INFO);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.log.LoggerDelegate#info(java.lang.String,
	 *      java.lang.Throwable)
	 */
	@Override
	public void info(String message, Throwable throwable) {
		this.task.log(message, throwable, Project.MSG_INFO);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.log.LoggerDelegate#error(java.lang.String)
	 */
	@Override
	public void error(String message) {
		this.task.log(message, Project.MSG_ERR);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.log.LoggerDelegate#error(java.lang.Throwable)
	 */
	@Override
	public void error(Throwable throwable) {
		this.task.log(throwable, Project.MSG_ERR);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.seasar.akabana.yui.framework.gen.log.LoggerDelegate#error(java.lang.String,
	 *      java.lang.Throwable)
	 */
	@Override
	public void error(String message, Throwable throwable) {
		this.task.log(message, throwable, Project.MSG_ERR);
	}

}
