/*
 * Created on 05-mar-2005
 */
package ar.com.espumito.persistence.hibernate;

import ar.com.espumito.persistence.DataAccessObject;
import net.sf.hibernate.SessionFactory;

/**
 * @author guybrush
 */
public interface HibernateDAO extends DataAccessObject {
    public void setManagedClass(Class clazz);

    public Class getManagedClass();

    public void setSessionFactory(SessionFactory sessionFactory);
}
