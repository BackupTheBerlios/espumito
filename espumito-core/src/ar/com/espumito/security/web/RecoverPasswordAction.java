/*
 * Created on 29-ene-2005
 */
package ar.com.espumito.security.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ar.com.espumito.web.CommonSymbols;
import ar.com.espumito.web.EspumitoSymbols;
import ar.com.espumito.web.GenericAction;

/**
 * Accion para enviar la contraseña a un usuario por email.
 * @author guybrush
 */
public class RecoverPasswordAction
    extends GenericAction
{


    /**
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ActionForward execute(ActionMapping pMapping,
        ActionForm pForm,
        HttpServletRequest pRequest,
        HttpServletResponse pResponse)
        throws Exception
    {
        RecoverPasswordForm form = (RecoverPasswordForm) pForm;
        pRequest.setAttribute(EspumitoSymbols.RECOVER_PASSWORD_EMAIL, form.getEmail());
        return pMapping.findForward(CommonSymbols.SUCCESS);
    }
}
