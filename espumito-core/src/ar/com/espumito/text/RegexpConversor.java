/*
 * Created on 27-mar-2005
 */
package ar.com.espumito.text;

public abstract class RegexpConversor implements TextConversor {

    public RegexpConversor() {
        super();

    }

    public String convert(String pString)
    {
        String str = (pString != null) ? pString : "";
        String[][] convertions = getConvertions();
        if (pString != null && convertions != null && convertions.length > 0)
            for (int i = 0; i < convertions.length; i++)
                str = str.replaceAll(convertions[i][0], convertions[i][1]);
        return str;
    }
    
    protected abstract String[][] getConvertions();
    
    
    

}
