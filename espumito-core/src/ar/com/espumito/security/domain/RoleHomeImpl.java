/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import ar.com.espumito.security.persistence.RoleDAO;
import ar.org.blah.j2ee.persistence.PersistenceException;

/**
 * @author guybrush
 */
public class RoleHomeImpl implements RoleHome {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(RoleHomeImpl.class);

    private RoleDAO dao;

    public RoleHomeImpl() {
        super();
    }

    public void setDao(RoleDAO roleDao) {
        this.dao = roleDao;
    }

    /**
     * @see ar.com.espumito.security.RoleHome#findByName(java.lang.String)
     */
    public RoleBean findByName(String name) throws FinderException {
        RoleBean role = null;
        try {
            role = (RoleBean) dao.findByName(name);
        } catch (PersistenceException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
        if (role == null)
            throw new ObjectNotFoundException();
        return role;
    }

    /**
     * @see ar.com.espumito.security.RoleHome#findByPrimaryKey(java.lang.Long)
     */
    public RoleBean findByPrimaryKey(Long id) throws FinderException {
        try {
            return (RoleBean) dao.find(id);
        } catch (PersistenceException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
    }

    /**
     * @see ar.com.espumito.security.domain.RoleHome#findAll()
     */
    public Set findAll() throws ar.org.blah.j2ee.FinderException {
        try {
            return new HashSet(dao.findAll());
        } catch (PersistenceException e) {
            throw new ar.org.blah.j2ee.FinderException(e);
        }
    }

}
