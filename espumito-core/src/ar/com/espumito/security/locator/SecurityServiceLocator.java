package ar.com.espumito.security.locator;

import ar.com.espumito.security.services.RegistrationService;
import ar.com.espumito.security.services.SecurityObjectsService;
import ar.com.espumito.security.services.SecuritySvc;


public interface SecurityServiceLocator
{
    
    public SecuritySvc getSecurityService();
    public SecurityObjectsService getSecurityObjectsService();
    public RegistrationService getRegistrationService();
}
