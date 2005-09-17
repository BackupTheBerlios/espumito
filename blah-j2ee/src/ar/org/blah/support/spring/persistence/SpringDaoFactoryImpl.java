/*
 * Created on 14-ago-2005
 */
package ar.org.blah.support.spring.persistence;

import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.persistence.DataAccessObjectFactory;

/**
 * Crea DAOs utilizando Spring.
 * 
 * @author guybrush
 */
public class SpringDaoFactoryImpl implements DataAccessObjectFactory {

    public SpringDaoFactoryImpl() {
        super();

    }

    /**
     * @see ar.org.blah.j2ee.persistence.DataAccessObjectFactory#getDataAccessObject(java.lang.Class)
     */
    public DataAccessObject getDataAccessObject(Class aClass) {
        return null;
    }

}
