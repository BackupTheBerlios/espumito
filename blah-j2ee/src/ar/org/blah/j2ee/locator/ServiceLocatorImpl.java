/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.locator;

import java.util.HashMap;
import java.util.Map;

import net.sf.hibernate.SessionFactory;

import org.apache.log4j.Logger;

public class ServiceLocatorImpl extends GenericServiceLocatorImpl {

    protected static String HIBERNATE_SESSION_FACTORY_PROPERTY = "session_factory.jndi_name";

    protected static ServiceLocatorImpl instance = null;

    private static Logger logger = Logger.getLogger(ServiceLocatorImpl.class);

    protected Map daoMappings = new HashMap();

    protected Map voMappings = new HashMap();

    protected Class defaultDaoClass;

    protected String hibernateConfig;

    protected SessionFactory hibernateSessionFactory;

    protected String hibernateSessionFactoryJNDIName;

    public ServiceLocatorImpl() throws ServiceLocatorException {
        super();
    }


    /**
     * @see ar.org.blah.j2ee.locator.GenericServiceLocatorImpl#loadDaoConfig()
     */
    protected void loadDaoConfig() throws ServiceLocatorException {
        super.loadDaoConfig();
        hibernateSessionFactoryJNDIName = daoProperties
                .getProperty(HIBERNATE_SESSION_FACTORY_PROPERTY);
    }

    /**
     * @see ar.org.blah.j2ee.locator.GenericServiceLocatorImpl#createHiberanteSessionFactory()
     */
    protected SessionFactory createHiberanteSessionFactory()
            throws ServiceLocatorException {
        return (SessionFactory) getJNDIObject(hibernateSessionFactoryJNDIName,
                null);
    }

}
