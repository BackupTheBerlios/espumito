/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.persistence;

import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.security.domain.RoleBean;

public interface RoleDAO extends DataAccessObject {
    public RoleBean findByName(String name) throws PersistenceException;
}
