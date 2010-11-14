/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.util;

import java.io.File;


/**
 * @author tango
 *
 */
public final class FileUtil {

	public static File createFile(File baseDir, String className) {
        AssertionUtil.assertNotNull(baseDir, className);
        String filePath = className.replace('.', File.separatorChar) + ".as";
        return new File(baseDir, filePath);
    }
}
