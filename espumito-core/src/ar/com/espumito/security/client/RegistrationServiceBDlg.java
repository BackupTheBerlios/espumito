package ar.com.espumito.security.client;

import java.util.Properties;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import ar.com.espumito.security.locator.SecurityServiceLocatorFactory;
import ar.com.espumito.security.services.AccountActivationException;
import ar.com.espumito.security.services.RegistrationException;
import ar.com.espumito.security.services.RegistrationService;

public class RegistrationServiceBDlg implements RegistrationService {
    private static RegistrationService service;

    private static RegistrationService getService() {
	if (service == null)
	    service = SecurityServiceLocatorFactory.getInstance()
		    .getSecurityServiceLocator().getRegistrationService();
	return service;
    }

    public void activateUser(String username, Properties properties)
	    throws FinderException, AccountActivationException {
	getService().activateUser(username, properties);
    }

    public void registerUser(String username, String password, String name,
	    String lastName, String email, String displayName)
	    throws CreateException, RegistrationException {
	getService().registerUser(username, password, name, lastName, email,
		displayName);
    }
}
