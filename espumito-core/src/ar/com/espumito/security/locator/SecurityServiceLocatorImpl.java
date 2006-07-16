package ar.com.espumito.security.locator;

import ar.com.espumito.core.locator.ServiceLocatorFactory;
import ar.com.espumito.security.services.RegistrationService;
import ar.com.espumito.security.services.SecurityObjectsService;
import ar.com.espumito.security.services.SecuritySvc;

public class SecurityServiceLocatorImpl implements SecurityServiceLocator {
    public SecurityServiceLocatorImpl() {
	super();
    }

    public RegistrationService getRegistrationService() {
	return (RegistrationService) ServiceLocatorFactory.getInstance()
		.getServiceLocator().getBean("registrationService");
    }

    public SecurityObjectsService getSecurityObjectsService() {
	return (SecurityObjectsService) ServiceLocatorFactory.getInstance()
		.getServiceLocator().getBean("securityObjectsService");
    }

    public SecuritySvc getSecurityService() {
	return (SecuritySvc) ServiceLocatorFactory.getInstance()
		.getServiceLocator().getBean("securityService");
    }
}
