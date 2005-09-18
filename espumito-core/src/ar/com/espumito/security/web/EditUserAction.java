/*
 * Created on 24-feb-2005
 */
package ar.com.espumito.security.web;

import javax.ejb.FinderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import ar.com.espumito.client.SecurityModel;
import ar.com.espumito.security.vo.UserVO;
import ar.com.espumito.web.CommonSymbols;
import ar.com.espumito.web.GenericAction;

/**
 * @author guybrush
 */
public class EditUserAction
    extends GenericAction
{
    private static Logger logger = Logger.getLogger(EditUserAction.class);
    /**
     * Constructor
     */
    public EditUserAction()
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
        UserVO vo = new UserVO();
        vo.setDisplayName(form.getDisplayName());
        vo.setEmail(form.getEmail());
        vo.setEnabled(form.isEnabled());
        vo.setFirstName(form.getFirstName());
        vo.setLastName(form.getLastName());
        vo.setPassword(form.getPassword());
        vo.setPasswordCheck(form.getPasswordCheck());
        vo.setVersion(Long.parseLong(form.getVersion()));
        logger.info("Username in action: " + form.getUsername());
        logger.info("Passowrd in action: " + form.getPassword());
        logger.info("Passoword check in action: " + form.getPasswordCheck());
        vo.setUsername(form.getUsername());
        try
        {
            SecurityModel.getInstance().editUser(vo);
            return pMapping.findForward(CommonSymbols.SUCCESS);
        }
        catch (FinderException e)
        {
            return getBasicError("Could not edit user.", e.getMessage(), pMapping, pRequest);
        }
    }
}
