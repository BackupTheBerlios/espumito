/*
 * Created on 24-feb-2005
 */
package ar.com.espumito.security.web;

import java.util.Collection;

import javax.ejb.FinderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ar.com.espumito.client.SecurityModel;
import ar.com.espumito.security.vo.UserVO;
import ar.com.espumito.web.CommonSymbols;
import ar.com.espumito.web.EspumitoSymbols;
import ar.com.espumito.web.GenericAction;

/**
 * @author guybrush
 */
public class EditUserFillFormAction
    extends GenericAction
{

    /**
     * Constructor
     */
    public EditUserFillFormAction()
    {
        super();
    }

    public ActionForward execute(ActionMapping pMapping,
        ActionForm pForm,
        HttpServletRequest pRequest,
        HttpServletResponse pResponse)
        throws Exception
    {
        EditUserForm form = (EditUserForm) pForm;
        String id = pRequest.getParameter(CommonSymbols.ID);
        UserVO user = null;
        Collection roles = null;
        SecurityModel model = SecurityModel.getInstance();
        try
        {
            user = model.getUser(id);
            form.setDisplayName(user.getDisplayName());
            form.setEmail(user.getEmail());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUsername(user.getUsername());
            form.setEnabled(user.isEnabled());
            form.setVersion(String.valueOf(user.getVersion()));
        } catch (FinderException e)
        {
            return getBasicError(
                "Could not find user.",
                    e.getMessage(),
                    pMapping,
                    pRequest);
        }
        try
        {
            roles = model.getRoles();
        }
        catch (FinderException e)
        {
            return getBasicError(
                "Could not find roles.",
                    e.getMessage(),
                    pMapping,
                    pRequest);
        }
        pRequest.setAttribute(EspumitoSymbols.USER_EDIT_ROLES, roles);
        return pMapping.findForward(CommonSymbols.SUCCESS);
    }
}
