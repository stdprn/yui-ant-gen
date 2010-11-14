/**
 * 
 */
package org.seasar.akabana.yui.framework.gen.util;


/**
 * @author tango
 *
 */
public final class StringUtil {

	/**
     * Determines if the text is empty.
     * 
     * @param text
     *            the text
     * @return whether text is empty
     */
    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    /**
     * Capitalizes the text according to JavaBeans specification.
     * 
     * @param text
     *            the text
     * 
     * @return the capitalized text
     */
    public static String capitalize(String text) {
        if (isEmpty(text)) {
            return text;
        }
        char chars[] = text.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);
        return new String(chars);
    }

    /**
     * Decapitalizes the text according to JavaBeans specification.
     * 
     * @param text
     *            the text
     * 
     * @return the decapitalized text
     */
    public static String decapitalize(String text) {
        if (isEmpty(text)) {
            return text;
        }
        char chars[] = text.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
    }
}
