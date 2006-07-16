package ar.com.espumito.security.services;

import java.util.Properties;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface RegistrationService {
    public void registerUser(String username, String password, String name,
	    String lastName, String email, String displayName)
	    throws CreateException, RegistrationException;
    
    public void activateUser(String username, Properties properties) throws FinderException, AccountActivationException;
}
