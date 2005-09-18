/*
 * Created on 29-ene-2005
 */
package ar.com.espumito.security.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import ar.com.espumito.web.GenericForm;

/**
 * @author guybrush
 */
public class RegisterUserForm
    extends GenericForm
{
    private String displayName;
    private String email;
    private String emailCheck;
    private String firstName;
    private String lastName;
    private String password;
    private String passwordCheck;
    private String username;

    /**
     * Constructor
     */
    public RegisterUserForm()
    {
        super();

    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getEmail()
    {
        return email;
    }

    public String getEmailCheck()
    {
        return emailCheck;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPassword()
    {
        return password;
    }

    public String getPasswordCheck()
    {
        return passwordCheck;
    }

    public String getUsername()
    {
        return username;
    }

    public void setDisplayName(String pDisplayName)
    {
        displayName = pDisplayName;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    public void setEmailCheck(String pEmailConfirmation)
    {
        emailCheck = pEmailConfirmation;
    }

    public void setFirstName(String pFirstName)
    {
        firstName = pFirstName;
    }

    public void setLastName(String pLastName)
    {
        lastName = pLastName;
    }

    public void setPassword(String pPassword)
    {
        password = pPassword;
    }

    public void setPasswordCheck(String pPasswordConfirmation)
    {
        passwordCheck = pPasswordConfirmation;
    }

    public void setUsername(String pUsername)
    {
        username = pUsername;
    }

    public void reset(ActionMapping pMapping, HttpServletRequest pRequest)
    {
        super.reset(pMapping, pRequest);
        setDisplayName("");
        setEmail("");
        setEmailCheck("");
        setFirstName("");
        setLastName("");
        setPassword("");
        setPasswordCheck("");
        setUsername("");
    }

    public ActionErrors validate(ActionMapping pMapping,
        HttpServletRequest pRequest)
    {
        ActionErrors errors = super.validate(pMapping, pRequest);
        if (isBlank(username))
            errors.add("username", new ActionMessage("register.username.blank"));
        errors.add(PasswordValidationUtil.validate(password, passwordCheck));
        errors.add(EmailValidationUtil.validate(email, emailCheck));
        return errors;
    }
}
