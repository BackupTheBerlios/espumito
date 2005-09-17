/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.locator;

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.persistence.DataAccessObjectFactory;

/**
 * @author guybrush
 */
public interface ServiceLocator extends DataAccessObjectFactory {

    public DataAccessObject getDataAccessObject(Class aClass);

    public Object getEJBSession(String jndiName, Object[] params)
            throws ServiceLocatorException;

    public Session getHibernateSession() throws ServiceLocatorException;

    public Object getJNDIObject(String name) throws ServiceLocatorException;

    public Object getJNDIObject(String name, Class clazz)
            throws ServiceLocatorException;

    public SessionFactory getHibernateSessionFactory()
            throws ServiceLocatorException;
}
