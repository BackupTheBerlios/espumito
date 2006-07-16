/*
 * Created on 24-feb-2005
 */
package ar.com.espumito.util;

import ar.com.espumito.text.StandardTextConversor;

/**
 * @author guybrush
 */
public class StringUtil {

    public static boolean isBlank(String pString) {
        return pString == null || pString.trim().equals("");
    }

    public static boolean isNotBlank(String pString) {
        return pString != null && !pString.trim().equals("");
    }

    public static String convertToNormalFormat(String string) {
        return new StandardTextConversor().convert(string);
    }

}
