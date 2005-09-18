/*
 * Created on 24-feb-2005
 */
package ar.com.espumito.security.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

import ar.com.espumito.util.StringUtil;
import ar.com.espumito.web.GenericForm;

/**
 * @author guybrush
 */
public class EditUserForm
    extends GenericForm
{
    private String displayName;
    private String email;
    private boolean enabled;
    private String firstName;
    private String lastName;
    private String password;
    private String passwordCheck;
    private String username;
    private String version;

    /**
     * Constructor
     */
    public EditUserForm()
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

    public String getVersion()
    {
        return version;
    }

    public boolean isEnabled()
    {
        return enabled;
    }

    public void setDisplayName(String pDisplayName)
    {
        displayName = pDisplayName;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    public void setEnabled(boolean pEnabled)
    {
        enabled = pEnabled;
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

    public void setPasswordCheck(String pPasswordCheck)
    {
        passwordCheck = pPasswordCheck;
    }

    public void setUsername(String pUsername)
    {
        username = pUsername;
    }

    public void setVersion(String pVersion)
    {
        version = pVersion;
    }

    public ActionErrors validate(ActionMapping pMapping,
        HttpServletRequest pRequest)
    {
        ActionErrors errors = super.validate(pMapping, pRequest);
        if (StringUtil.isNotBlank(password))
            errors.add(PasswordValidationUtil.validate(password, passwordCheck));
        return errors;
    }
}
