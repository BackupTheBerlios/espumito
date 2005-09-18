/*
 * Created on 13-may-2005
 */
package ar.com.espumito.security.persistence;

import ar.com.espumito.security.domain.UserBean;
import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.persistence.PersistenceException;

public interface UserDAO extends DataAccessObject {
    /**
     * Busca un usuario por su nombre de usuario.
     * @param username
     * @return
     * @throws PersistenceException
     */
    public UserBean findByUsername(String username) throws PersistenceException;
}
