/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.task;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.seasar.akabana.yui.framework.gen.generator.Generator;
import org.seasar.akabana.yui.framework.gen.generator.GeneratorFactory;
import org.seasar.akabana.yui.framework.gen.log.Logger;
import org.seasar.akabana.yui.framework.gen.log.TaskLoggerDelegate;

/**
 * @author tango
 * 
 */
public abstract class AbstractGenFileTask extends Task {
	
	/** ソースファイルのディレクトリ */
	protected String sourceDir;
	
	protected Generator generator;
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.apache.tools.ant.Task#execute()
	 */
	@Override
	public void execute() throws BuildException {
		Logger.setDelegate(new TaskLoggerDelegate(this));
		try{
			prepare();
			doExecute();
			
		} catch (Throwable t) {
            StringWriter writer = new StringWriter();
            t.printStackTrace(new PrintWriter(writer));
            throw new BuildException(t.getMessage() + writer);
		}
	}
	
	private void prepare(){
		generator = GeneratorFactory.createGenerator();
		doPrepare();
	}
	
	protected void doPrepare(){
		
	}

	/**
	 * Executes the task.
	 */
	protected void doExecute() {

	}

	
	/**
	 * Sets the sourceDir
	 *
	 * @param sourceDir
	 */
	public void setSourceDir(String sourceDir) {
		this.sourceDir = sourceDir;
	}	

}
