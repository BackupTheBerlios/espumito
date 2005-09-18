/*
 * Created on 19-jun-2005
 */
package ar.com.espumito.locator;

import ar.com.espumito.security.services.SecuritySvc;
import ar.com.espumito.security.services.SecuritySvcSessionHome;
import ar.org.blah.j2ee.locator.ServiceLocatorException;

public class ServiceLocator extends GenericServiceLocator {
    private static final String SECURITY_FACADE_KEY = SecuritySvcSessionHome.JNDI_NAME;

    private static ServiceLocator instance = null;

    public static ServiceLocator getInstance() throws ServiceLocatorException {
        if (instance == null)
            instance = new ServiceLocator();
        return instance;
    }

    protected ServiceLocator() throws ServiceLocatorException {
        super();
    }

    public SecuritySvc getSecurityFacade() throws ServiceLocatorException {
        return (SecuritySvc) getSession(SECURITY_FACADE_KEY,
                SecuritySvcSessionHome.class);
    }

}
