/*
 * Created on 19-jun-2005
 */
package ar.com.espumito.locator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.ejb.EJBHome;

import ar.org.blah.j2ee.locator.ServiceLocatorException;
import ar.org.blah.j2ee.locator.ServiceLocatorFactory;

public abstract class GenericServiceLocator {
    private ar.org.blah.j2ee.locator.ServiceLocator serviceLocator;

    protected GenericServiceLocator() throws ServiceLocatorException {
        serviceLocator = ServiceLocatorFactory.getInstance()
                .createServiceLocator();
    }

    /**
     * @param serviceLocator
     * @param pJNDIName
     * @param pClass
     * @return
     * @throws ServiceLocatorException
     */
    protected Object getSession(String pJNDIName, Class pClass)
            throws ServiceLocatorException {
        try {
            EJBHome home = (EJBHome) serviceLocator.getJNDIObject(pJNDIName,
                    pClass);
            Method createMethod = home.getClass().getMethod("create", null);
            return createMethod.invoke(home, null);
        } catch (SecurityException e) {
            throw new ServiceLocatorException(e);
        } catch (NoSuchMethodException e) {
            throw new ServiceLocatorException(e);
        } catch (IllegalArgumentException e) {
            throw new ServiceLocatorException(e);
        } catch (IllegalAccessException e) {
            throw new ServiceLocatorException(e);
        } catch (InvocationTargetException e) {
            throw new ServiceLocatorException(e);
        }
    }
    
}
