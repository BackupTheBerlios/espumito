/*
 * Created on 16-ene-2005
 */
package ar.com.espumito.web;


/**
 * TODO Falta descripcion de 
 * @author guybrush
 */
public class Link
{
    private String path;
    private String label;

    /**
     * Constructor
     * @param pUrl
     * @param pLabel
     */
    public Link(String pPath, String pLabel)
    {
        super();
        this.path = pPath;
        this.label = pLabel;
    }

    /**
     * @return Returns the label.
     */
    public String getLabel()
    {
        return this.label;
    }

    /**
     * @return Returns the url.
     */
    public String getPath()
    {
        return this.path;
    }
}
