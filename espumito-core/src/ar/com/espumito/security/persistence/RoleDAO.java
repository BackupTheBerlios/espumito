/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.persistence;

import ar.com.espumito.security.domain.RoleBean;
import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.persistence.PersistenceException;

public interface RoleDAO extends DataAccessObject {
    public RoleBean findByName(String name) throws PersistenceException;
}
