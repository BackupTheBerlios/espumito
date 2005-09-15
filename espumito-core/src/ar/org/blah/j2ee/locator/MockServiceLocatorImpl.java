package ar.org.blah.j2ee.locator;

import java.util.HashMap;
import java.util.Map;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

import org.apache.log4j.Logger;

public class MockServiceLocatorImpl extends GenericServiceLocatorImpl {
    private static Logger logger = Logger
            .getLogger(MockServiceLocatorImpl.class);

    protected static String HIBERNATE_CONFIG_PROPERTY = "hibernate.config";

    protected Map crudFacades = new HashMap();

    private String hibernateConfig;

    public MockServiceLocatorImpl() throws ServiceLocatorException {
        super();
    }

    /**
     * @see ar.org.blah.j2ee.locator.GenericServiceLocatorImpl#createHiberanteSessionFactory()
     */
    protected SessionFactory createHiberanteSessionFactory()
            throws ServiceLocatorException {
        logger.debug("Building Hibernate session factory; using "
                + getHibernateConfig() + " for configuration.");
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ServiceLocatorException(e);
        }
    }
    /**
     * @return
     */
    private synchronized String getHibernateConfig() {
        if (hibernateConfig == null)
            hibernateConfig = serviceLocatorProperties
                    .getProperty(HIBERNATE_CONFIG_PROPERTY);
        return hibernateConfig;
    }

}
