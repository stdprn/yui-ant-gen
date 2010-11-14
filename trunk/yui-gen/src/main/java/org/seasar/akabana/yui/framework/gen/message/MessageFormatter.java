/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.message;

import java.text.MessageFormat;
import java.util.ResourceBundle;


/**
 * @author tango
 *
 */
public final class MessageFormatter {

	public static String getMessage(MessageResource messageResource, Object... args) {
        ResourceBundle bundle = ResourceBundle
                .getBundle(GenMessageResourceBundle.class.getName());
        String pattern = bundle.getString(messageResource.getCode());
        return MessageFormat.format("[" + messageResource.getCode() + "] "
                + pattern, args);
    }
	
}
