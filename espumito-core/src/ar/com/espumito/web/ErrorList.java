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
        globalMessage = pGlobalMessage;
    }
    
    public String getGlobalMessage()
    {
        return globalMessage;
    }
    
    public void addError(BasicError pError)
    {
        if (pError != null)
            errors.add(pError);
    }
    
    public void addLink(Link pLink)
    {
        if (pLink != null)
            links.add(pLink);
    }
    
    public Iterator getErrors()
    {
        return errors.iterator();
    }
    
    public Iterator getLinks()
    {
        return links.iterator();
    }
}
