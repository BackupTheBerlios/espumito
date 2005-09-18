/*
 * Created on 05-jun-2005
 */
package ar.com.espumito.text;

public class StandardInverseTextConversor extends RegexpConversor {
    public static final StandardInverseTextConversor CONVERSOR = new StandardInverseTextConversor();

    public static final String[][] convertions = new String[][] { { "<br/>",
            "\n" } };

    protected String[][] getConvertions() {
        return convertions;
    }

}
