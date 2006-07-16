/*
 * Created on 27-mar-2005
 */
package ar.com.espumito.text;

public class WebTextConversor extends RegexpConversor {
    public static final String[][] convertions = new String[][] {
            { "<br/>", "\n" }, { "<", "&lt;" }, { ">", "&gt;" },
            { "\n", "</p>\n<p>" }, { "$", "</p>" }, { "^", "<p>" },
            { "<p></p>", "<p>&nbsp;</p>" }};

    public static final TextConversor CONVERSOR = new WebTextConversor();

    public String convert(String pString) {
        return super.convert(pString);
    }

    protected String[][] getConvertions() {
        return convertions;
    }
}
