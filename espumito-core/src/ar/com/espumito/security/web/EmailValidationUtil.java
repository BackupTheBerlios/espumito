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
public class EmailValidationUtil
{

    /**
     * Constructor
     */
    public EmailValidationUtil()
    {
        super();
    }

    public static ActionErrors validate(String email, String emailCheck)
    {
        ActionErrors errors = new ActionErrors();
        if (StringUtil.isBlank(email) || StringUtil.isBlank(emailCheck))
            errors.add("email", new ActionMessage("register.email.blank"));
        if (!email.equals(emailCheck))
            errors.add("email", new ActionMessage("register.email.noMatch"));
        return errors;
    }

}
