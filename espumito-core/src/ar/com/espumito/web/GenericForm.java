/*
 * Created on 15-ene-2005
 */
package ar.com.espumito.web;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * Extension of <code>org.apache.struts.action.ActionForm</code> to provide helper methods
 * to forms.
 * @author guybrush
 */
public abstract class GenericForm
    extends ActionForm
{
    public static final String MANDATORY_FIELD_MESSAGE_KEY = "error.mandatoryField";
    
    /**
     * Verifies if a String is null or empty.
     * @param pString
     * @return <code>true</code> if <code>pString == null</code> or if <code>pString.equals("")</code> 
     */
    protected boolean isBlank(String pString)
    {
        return pString == null || pString.equals("");
    }

    /**
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    public ActionErrors validate(ActionMapping pMapping,
        HttpServletRequest pRequest)
    {
        return new ActionErrors();
//        ActionErrors errors = super.validate(pMapping, pRequest);
//        return (errors != null) ? errors : new ActionErrors(); 
    }

    /**
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.ServletRequest)
     */
    public ActionErrors validate(ActionMapping pMapping, ServletRequest pRequest)
    {
        return new ActionErrors();
//        ActionErrors errors = super.validate(pMapping, pRequest);
//        return (errors != null) ? errors : new ActionErrors(); 
    }
}
