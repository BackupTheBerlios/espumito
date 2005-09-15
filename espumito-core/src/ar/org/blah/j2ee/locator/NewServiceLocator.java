/*
 * Created on 12-jun-2005
 */
package ar.org.blah.j2ee.locator;

import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.vo.ValueObjectMapper;

public class NewServiceLocator implements ServiceLocator {

    public NewServiceLocator() {
        super();
    }

    public DataAccessObject getDataAccessObject(Class aClass) {
        return null;
    }

    public Object getEJBSession(String jndiName, Object[] params)
            throws ServiceLocatorException {
        return null;
    }

    public Session getHibernateSession() throws ServiceLocatorException {
        return null;
    }

    public Object getJNDIObject(String name) throws ServiceLocatorException {
        return null;
    }

    public Object getJNDIObject(String name, Class clazz)
            throws ServiceLocatorException {
        return null;
    }

    public ValueObjectMapper getValueObjectMapper(Class pClass)
            throws ServiceLocatorException {
        return null;
    }

    public SessionFactory getHibernateSessionFactory()
            throws ServiceLocatorException {
        return null;
    }

}
