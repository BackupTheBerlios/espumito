/*
 * Created on 27-mar-2005
 */
package ar.com.espumito.text;

/**
 * <p>
 * Converts an arbitrary String to the normalized text storoge format.
 * </p>
 * 
 * @author guybrush
 */
public class StandardTextConversor extends RegexpConversor {
    public static final String[][] convertions = new String[][] {
        { "\n\r", "\n" },
        { "\r\n", "\n" },
        { "\r", "\n" },
        { "\n", "<br/>" }};
//    public static final String[][] convertions = new String[][] {
//        { "\n", "<br/>" }, { "\r", "<br/>" } };

    protected String[][] getConvertions() {
        return convertions;
    }

}
