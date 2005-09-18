/*
 * Created on 13-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import ar.com.espumito.security.persistence.UserDAO;
import ar.org.blah.j2ee.persistence.PersistenceException;

public class UserHomeImpl implements UserHome {

    private UserDAO dao;

    public void setDao(UserDAO dao) {
        this.dao = dao;
    }

    public UserHomeImpl() {
        super();
    }

    /**
     * @see ar.com.espumito.security.UserHome#findUserByUsername(java.lang.String)
     */
    public UserBean findUserByUsername(String username) throws FinderException {
        if (username == null)
            throw new ObjectNotFoundException();
        try {
            return dao.findByUsername(username);
        } catch (PersistenceException e) {
            throw new FinderException(e.getMessage());
        }
    }

    /**
     * @return
     * @throws ar.org.blah.j2ee.FinderException
     */
    public Set findAll() throws ar.org.blah.j2ee.FinderException {
        try {
            return new HashSet(dao.findAll());
        } catch (PersistenceException e) {
            throw new ar.org.blah.j2ee.FinderException(e);
        }
    }

}
