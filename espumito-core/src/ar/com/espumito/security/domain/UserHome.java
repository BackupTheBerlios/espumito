/*
 * Created on 13-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Set;

import javax.ejb.FinderException;

public interface UserHome {
    /**
     * Finds a user by its username.
     * @param username
     * @return
     * @throws FinderException
     */
    public UserBean findUserByUsername(String username) throws FinderException;
    
    /**
     * Encuentra todos los usuarios.
     * @return
     * @throws ar.org.blah.j2ee.FinderException
     */
    public Set findAll() throws ar.org.blah.j2ee.FinderException;
}
