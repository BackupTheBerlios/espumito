/*
 * Created on 24-feb-2005
 */
package ar.com.espumito.security.web;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import ar.com.espumito.util.StringUtil;

/**
 * @author guybrush
 */
public class PasswordValidationUtil
{
    
    public static ActionErrors validate(String password, String passwordCheck)
    {
        ActionErrors errors = new ActionErrors();
        if (StringUtil.isBlank(password) || StringUtil.isBlank(passwordCheck))
            errors.add("password", new ActionMessage("register.password.blank"));
        else if (!password.equals(passwordCheck))
            errors.add("password", new ActionMessage("register.password.noMatch"));
        return errors;
    }

}
