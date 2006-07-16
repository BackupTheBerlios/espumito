package ar.com.espumito.security.plugins;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import ar.com.espumito.security.domain.UserBean;
import ar.com.espumito.security.services.AccountActivationException;
import ar.com.espumito.security.services.RegistrationException;

public interface RegistrationPlugin {
    public static final String SOCKET_NAME = "user_registration";
    
    public void userActivated(UserBean user, Properties parameters)
	    throws AccountActivationException;

    public void userRegistered(UserBean user)
	    throws RegistrationException;
    
    public Properties getRegistrationProperties(HttpServletRequest request);
}
