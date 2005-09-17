package ar.org.blah.j2ee.locator;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.ejb.EJBHome;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;

import org.apache.log4j.Logger;

import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.persistence.HibernateDAO;
import ar.org.blah.j2ee.util.Utils;
import ar.org.blah.j2ee.vo.ValueObjectMapper;

public abstract class GenericServiceLocatorImpl implements ServiceLocator {

    private static Logger logger = Logger
            .getLogger(GenericServiceLocatorImpl.class);

    protected static String CRUD_MAPPING_CONFIG_FILENAME = "ar/org/blah/j2ee/locator/crud-mapping.properties";

    protected static String DAO_CONFIG_FILENAME = "ar/org/blah/j2ee/locator/dao-config.properties";

    protected static String DEFAULT_DAO_CLASS_PROPERTY = "default.class";

    protected static String VO_MAPPING_CONFIG_FILENAME = "ar/org/blah/j2ee/locator/vo-mapping.properties";

    // private DataAccessObject defaultDao;

    protected Properties crudProperties;

    protected Map daoMappings = new HashMap();

    protected Properties daoProperties;

    protected Class defaultDaoClass;

    protected SessionFactory hibernateSessionFactory;

    protected Properties serviceLocatorProperties;

    protected Properties voMappersProperties;

    protected Map voMappings = new HashMap();

    protected InitialContext initialContext;

    /**
     * @throws ServiceLocatorException
     */
    public GenericServiceLocatorImpl() throws ServiceLocatorException {
        super();
        logger.debug("Initializing service locator.");
        init();
    }

    /**
     * @see ar.org.blah.j2ee.locator.ServiceLocator#getDataAccessObject(java.lang.Class)
     */
    public DataAccessObject getDataAccessObject(Class aClass) {
        try {
            if (aClass == null) {
                logger.debug("No class received");
                return createDefaultDataAccessObject(aClass);
            }
            DataAccessObject dao = null;
            synchronized (daoMappings) {
                Object obj = daoMappings.get(aClass);
                if (obj != null) {
                    dao = (DataAccessObject) obj;
                } else {
                    String className = daoProperties.getProperty(aClass
                            .getName());
                    logger
                            .debug("DAO implementation class for persistent class "
                                    + aClass.getName() + ": " + className);
                    if (className != null && !className.trim().equals("")) {
                        try {
                            dao = createDataAccessObject(Class
                                    .forName(className), aClass);
                        } catch (ClassNotFoundException e) {
                            logger.error("Error instantiating class "
                                    + className, e);
                            throw new ServiceLocatorException(e);
                        }
                    } else {
                        logger
                                .error("No data access object class specified for class "
                                        + aClass.getName()
                                        + "; using default DAO.");
                        return createDefaultDataAccessObject(aClass);
                    }
                    daoMappings.put(aClass, dao);
                }
            }
            return dao;
        } catch (NoClassDefFoundError e) {
            logger.error(">>> Error apestoso!!!", e);
            return null;
            //throw new ServiceLocatorException(e);
        } catch (ServiceLocatorException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @see ar.org.blah.j2ee.locator.ServiceLocator#getEJBSession(String,
     *      Object[])
     */
    public Object getEJBSession(String jndiName, Object[] params)
            throws ServiceLocatorException {
        EJBHome home = (EJBHome) getJNDIObject(jndiName);
        Class[] paramTypes = null;
        if (params != null && params.length > 0) {
            paramTypes = new Class[params.length];
            for (int i = 0; i < params.length; i++)
                paramTypes[i] = params[i].getClass();
        }
        try {
            Method createMethod = home.getClass().getMethod("create",
                    paramTypes);
            return createMethod.invoke(home, params);
        } catch (Exception e) {
            throw new ServiceLocatorException(e);
        }
    }

    /**
     * @see ar.org.blah.j2ee.locator.ServiceLocator#getHibernateSession()
     */
    public Session getHibernateSession() throws ServiceLocatorException {
        try {
            logger.debug("Opening Hibernate session.");
            return getHibernateSessionFactory().openSession();
        } catch (HibernateException e) {
            logger.error("Error opening Hibernate session.");
            throw new ServiceLocatorException(e);
        }
    }

    /**
     * @see ar.org.blah.j2ee.locator.ServiceLocator#getHibernateSessionFactory()
     */
    public synchronized final SessionFactory getHibernateSessionFactory()
            throws ServiceLocatorException {
        if (hibernateSessionFactory == null)
            hibernateSessionFactory = createHiberanteSessionFactory();
        return hibernateSessionFactory;
    }

    /**
     * @see #getJNDIObject(java.lang.String, java.lang.Class)
     */
    public Object getJNDIObject(String name) throws ServiceLocatorException {
        return getJNDIObject(name, null);
    }

    /**
     * @see ar.org.blah.j2ee.locator.ServiceLocator#getJNDIObject(java.lang.String,
     *      Class)
     */
    public Object getJNDIObject(String name, Class clazz)
            throws ServiceLocatorException {
        try {
            InitialContext ic = getInitialContext();
            logger.debug("Looking up \""
                    + name
                    + "\""
                    + ((clazz != null) ? " of type " + clazz.getName()
                            : ". No type specified"));
            Object obj = ic.lookup(name);
            Object ret = obj;
            if (obj instanceof EJBHome)
                ret = PortableRemoteObject.narrow(obj, (clazz != null) ? clazz
                        : EJBHome.class);
            return ret;
        } catch (NamingException e) {
            throw new ServiceLocatorException(e);
        }
    }

    /**
     * @see ar.org.blah.j2ee.locator.ServiceLocator#getValueObjectMapper(java.lang.Class)
     * @deprecated
     */
    public synchronized ValueObjectMapper getValueObjectMapper(Class clazz)
            throws ServiceLocatorException {
        if (clazz == null)
            throw new ServiceLocatorException();
        ValueObjectMapper mapper = (ValueObjectMapper) voMappings.get(clazz);
        if (mapper == null) {
            mapper = createValueObjectMapper(clazz);
            voMappings.put(clazz, mapper);
        }
        return mapper;
    }

    private void init() throws ServiceLocatorException {
        try {
            logger.debug("Reading service locator configuration from "
                    + ServiceLocatorFactory.CONFIG_FILE);
            serviceLocatorProperties = Utils
                    .readProperties(ServiceLocatorFactory.CONFIG_FILE);
        } catch (IOException e) {
            throw new ServiceLocatorException(e);
        }
        loadDaoConfig();
        loadVOMappersConfig();
        loadCRUDFacadeConfig();
        configure();
    }

    /**
     * Las subclases deben sobrecargar este metodo para configurarse
     * inicialmente.
     * 
     * @throws ServiceLocatorException
     */
    protected void configure() throws ServiceLocatorException {

    }

    protected abstract SessionFactory createHiberanteSessionFactory()
            throws ServiceLocatorException;

    /**
     * Crea el value object mapper para una clase.
     * 
     * @param clazz
     * @return
     * @throws ServiceLocatorException
     */
    protected ValueObjectMapper createValueObjectMapper(Class clazz)
            throws ServiceLocatorException {
        try {
            String className = voMappersProperties.getProperty(clazz.getName());
            if (className == null)
                throw new ServiceNotProvidedException();
            Class voMapperClass = Class.forName(className);
            if (ValueObjectMapper.class.isAssignableFrom(voMapperClass))
                return (ValueObjectMapper) voMapperClass.newInstance();
            else
                throw new ServiceNotProvidedException();
        } catch (ClassNotFoundException e) {
            throw new ServiceLocatorException(e);
        } catch (InstantiationException e) {
            throw new ServiceLocatorException(e);
        } catch (IllegalAccessException e) {
            throw new ServiceLocatorException(e);
        }
    }

    /**
     * Lee la configuracion de las fachadas CRUD.
     * 
     * @throws ServiceLocatorException
     */
    protected void loadCRUDFacadeConfig() throws ServiceLocatorException {
        try {
            logger.debug("Reading CRUD interfaces configuration from file "
                    + CRUD_MAPPING_CONFIG_FILENAME);
            crudProperties = Utils.readProperties(CRUD_MAPPING_CONFIG_FILENAME);
            Utils.listProperties(crudProperties);
        } catch (IOException e) {
            throw new ServiceLocatorException(e);
        }
    }

    /**
     * Lee la configuracion de los DAO.
     * 
     * @throws ServiceLocatorException
     */
    protected void loadDaoConfig() throws ServiceLocatorException {
        try {
            logger.debug("Reading data access object configuration from "
                    + DAO_CONFIG_FILENAME);
            daoProperties = Utils.readProperties(DAO_CONFIG_FILENAME);
            logger.debug("Data access object mappings:");
            Utils.listProperties(daoProperties);
            String defaultDaoClassName = daoProperties
                    .getProperty(DEFAULT_DAO_CLASS_PROPERTY);
            if (defaultDaoClassName != null) {
                defaultDaoClass = Class.forName(defaultDaoClassName);
                if (!DataAccessObject.class.isAssignableFrom(defaultDaoClass))
                    throw new IllegalArgumentException(defaultDaoClass
                            .getName()
                            + " does not implement "
                            + DataAccessObject.class.getName());
            }
        } catch (IOException e) {
            throw new ServiceLocatorException(e);
        } catch (ClassNotFoundException e) {
            throw new ServiceLocatorException(e);
        }
    }

    /**
     * Lee la configuracion de los mappers de value objects.
     * 
     * @throws ServiceLocatorException
     */
    protected void loadVOMappersConfig() throws ServiceLocatorException {
        try {
            logger.debug("Reading value object mappers configuration from "
                    + VO_MAPPING_CONFIG_FILENAME);
            voMappersProperties = Utils
                    .readProperties(VO_MAPPING_CONFIG_FILENAME);
            logger.debug("Value object mappers mappings:");
            Utils.listProperties(voMappersProperties);
        } catch (IOException e) {
            throw new ServiceLocatorException(e);
        }
    }

    /**
     * @param pClass
     * @param pPersistentClass
     * @return
     * @throws ServiceLocatorException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private DataAccessObject createDataAccessObject(Class pClass,
            Class pPersistentClass) throws ServiceLocatorException {
        try {
            DataAccessObject dao = (DataAccessObject) pClass.newInstance();
            if (dao instanceof HibernateDAO)
                ((HibernateDAO) dao).setManagedClass(pPersistentClass);
            return dao;
        } catch (InstantiationException e) {
            throw new ServiceLocatorException(e);
        } catch (IllegalAccessException e) {
            throw new ServiceLocatorException(e);
        }
    }

    /**
     * @param pPersistentClass
     * @return
     * @throws ServiceLocatorException
     */
    private DataAccessObject createDefaultDataAccessObject(
            Class pPersistentClass) throws ServiceLocatorException {
        return createDataAccessObject(defaultDaoClass, pPersistentClass);
    }

    /**
     * @return
     * @throws NamingException
     */
    protected synchronized InitialContext getInitialContext()
            throws NamingException {
        if (initialContext == null) {
            Properties p = new Properties();
            p.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY,
                    serviceLocatorProperties
                            .getProperty(InitialContext.INITIAL_CONTEXT_FACTORY));
            p.setProperty(InitialContext.PROVIDER_URL, serviceLocatorProperties
                    .getProperty(InitialContext.PROVIDER_URL));
            p.setProperty(InitialContext.URL_PKG_PREFIXES,
                    serviceLocatorProperties
                            .getProperty(InitialContext.URL_PKG_PREFIXES));
            initialContext = new InitialContext(p);
        }
        return initialContext;
    }

}
