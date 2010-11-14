/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.util;

import java.net.URL;

/**
 * @author tango
 * 
 */
public final class ResourceUtil {

	public static URL getResource(String path) {
		AssertionUtil.assertNotNull(path);
		URL result = ResourceUtil.getResource("/" + path);
		if (result != null) {
			return result;
		}
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		if (loader == null) {
			return null;
		}
		return loader.getResource(path);
	}

}
