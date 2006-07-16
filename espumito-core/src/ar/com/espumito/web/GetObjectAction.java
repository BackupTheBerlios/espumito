/*
 * Created on 09-feb-2005
 */
package ar.com.espumito.web;

import javax.ejb.FinderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * Acción genérica para mostrar un conjunto de noticias.
 * @author guybrush
 */
public abstract class GetObjectAction
    extends GenericAction
{

    /**
     * Constructor
     */
    public GetObjectAction()
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
            Object result = getObject(pMapping, pForm, pRequest);
            pRequest.setAttribute(getResultSymbol(), result);
            return pMapping.findForward(WebSymbols.SUCCESS);
        } catch (Exception e)
        {
            e.printStackTrace();
            return getBasicError(
                getErrorMessage(),
                    e.getMessage(),
                    pMapping,
                    pRequest);
        }
    }

    protected abstract Object getObject(ActionMapping pMapping, ActionForm pForm, HttpServletRequest pRequest)
        throws FinderException;

    protected abstract String getResultSymbol();

    protected abstract String getErrorMessage();
}
