/*
 * Created on 27-ene-2005
 */
package ar.com.espumito.security.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ar.com.espumito.web.CommonSymbols;
import ar.com.espumito.web.GenericAction;

/**
 * TODO Falta descripcion de 
 * @author guybrush
 */
public class LogoutAction
    extends GenericAction
{

    /**
     * Constructor
     */
    public LogoutAction()
    {
        super();
    }

    /**
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ActionForward execute(ActionMapping pMapping,
        ActionForm pForm,
        HttpServletRequest pRequest,
        HttpServletResponse pResponse)
        throws Exception
    {
        try
        {
            pRequest.getSession().invalidate();
            return pMapping.findForward(CommonSymbols.SUCCESS);
        }
        catch (Exception e)
        {
            return getBasicError("Could not perform logout.", e.getMessage(), pMapping, pRequest);
        }
    }
}
