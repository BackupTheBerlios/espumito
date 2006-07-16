/*
 * Created on 16-ene-2005
 */
package ar.com.espumito.web;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * Conjunto de errores producidos al ejecutar una operacion, junto con los links ofrecidos
 * al usuario.
 *  
 * @author guybrush
 */
public class ErrorList
{
    private String globalMessage;
    private Collection errors = new Vector();
    private Collection links = new Vector();
    
    public ErrorList(String pGlobalMessage)
    {
        this.globalMessage = pGlobalMessage;
    }
    
    public String getGlobalMessage()
    {
        return this.globalMessage;
    }
    
    public void addError(BasicError pError)
    {
        if (pError != null)
            this.errors.add(pError);
    }
    
    public void addLink(Link pLink)
    {
        if (pLink != null)
            this.links.add(pLink);
    }
    
    public Iterator getErrors()
    {
        return this.errors.iterator();
    }
    
    public Iterator getLinks()
    {
        return this.links.iterator();
    }
}
