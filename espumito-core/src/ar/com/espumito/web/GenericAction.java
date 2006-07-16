/*
 * Created on 16-ene-2005
 */
package ar.com.espumito.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Superclase de todas las Actions de Struts.
 * 
 * @author guybrush
 */
public abstract class GenericAction extends Action {

    public GenericAction() {
    }

    /**
     * TODO: Falta descripcion del metodo getBasicError
     * 
     * @param pMessage
     * @param pMapping
     * @return
     */
    protected ActionForward getBasicError(String pMessage, String pDescription,
            ActionMapping pMapping, HttpServletRequest pRequest) {
        // ErrorList errorList = new ErrorList(pMessage);
        // errorList.addError(new BasicError(pDescription));
        // pRequest.setAttribute(CommonSymbols.STANDARD_ERROR, errorList);
        return pMapping.findForward(WebSymbols.FAILURE);
    }

    /**
     * Parsea un parametro numerico.
     * 
     * @param pRequest
     * @param pParameterName
     * @return
     */
    protected Long getLongId(HttpServletRequest pRequest, String pParameterName) {
        String value = pRequest.getParameter(pParameterName);
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            // TODO: mensaje hardcodeado.
            throw new IllegalArgumentException(value
                    + " is not a valid numeric id.");
        }
    }

    /**
     * Parsea un parametro numerico con nombre <code>id</code>.
     * 
     * @param pRequest
     * @return
     */
    protected Long getLongId(HttpServletRequest pRequest) {
        return getLongId(pRequest, WebSymbols.ID);
    }
}
