/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.locator;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import ar.org.blah.j2ee.util.Utils;

public class ServiceLocatorFactory {
    private static Logger logger = Logger
            .getLogger(ServiceLocatorFactory.class);

    public static final String CONFIG_FILE = "ar/org/blah/j2ee/locator/service-locator-config.properties";

    public static final String IMPL_CLASS_NAME_PROPERTY = "service_locator.class";

    private static ServiceLocatorFactory instance;

    private static boolean initializing = false;

    public static ServiceLocatorFactory getInstance() {
        if (instance == null)
            instance = new ServiceLocatorFactory();
        return instance;
    }

    private ServiceLocator serviceLocator;

    protected ServiceLocatorFactory() {

    }

    public synchronized ServiceLocator createServiceLocator()
            throws ServiceLocatorException {
        if (serviceLocator == null) {

            Properties properties;
            try {
                properties = Utils.readProperties(CONFIG_FILE);
                logger.debug("Reading service locator factory configuration from "
                                + CONFIG_FILE);
                Utils.listProperties(properties);
            } catch (IOException e) {
                throw new ServiceLocatorException(e);
            }
            String implClassName = properties
                    .getProperty(IMPL_CLASS_NAME_PROPERTY);
            if (implClassName != null)
                implClassName = implClassName.trim();
            if (implClassName == null || implClassName.equals(""))
                throw new ServiceLocatorException("Could not find property "
                        + IMPL_CLASS_NAME_PROPERTY);
            try {
                Class implClass = Class.forName(implClassName);
                if (!ServiceLocator.class.isAssignableFrom(implClass))
                    throw new ServiceLocatorException(implClass.getName()
                            + " does not implements "
                            + ServiceLocator.class.getName());
                serviceLocator = (ServiceLocator) implClass.newInstance();
            } catch (Exception e) {
                throw new ServiceLocatorException(e);
            }
        }
        return serviceLocator;
    }
}
