/*
 * Created on 29-ene-2005
 */
package ar.com.espumito.security.web;

import javax.ejb.CreateException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ar.com.espumito.client.SecurityModel;
import ar.com.espumito.security.vo.UserVO;
import ar.com.espumito.web.CommonSymbols;
import ar.com.espumito.web.GenericAction;


/**
 * TODO Falta descripcion de 
 * @author guybrush
 */
public class RegisterUserAction
    extends GenericAction
{

    /**
     * Constructor
     */
    public RegisterUserAction()
    {
        super();
    }

    
    public ActionForward execute(ActionMapping pMapping,
        ActionForm pForm,
        HttpServletRequest pRequest,
        HttpServletResponse pResponse)
        throws Exception
    {
        RegisterUserForm form = (RegisterUserForm) pForm;
        UserVO vo = new UserVO();
        vo.setUsername(form.getUsername());
        vo.setPassword(form.getPassword());
        vo.setPasswordCheck(form.getPasswordCheck());
        vo.setDisplayName(form.getDisplayName());
        vo.setEmail(form.getEmail());
        vo.setEmailCheck(form.getEmailCheck());
        vo.setFirstName(form.getFirstName());
        vo.setLastName(form.getLastName());
        try
        {
            SecurityModel.getInstance().registerUser(vo);
            return pMapping.findForward(CommonSymbols.SUCCESS);
        }
        catch (CreateException e)
        {
            return getBasicError("No se pudo registrar el usuario", e.getMessage(), pMapping, pRequest);
        }
    }
}
