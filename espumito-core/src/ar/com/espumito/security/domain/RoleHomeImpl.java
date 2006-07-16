/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.security.persistence.RoleDAO;

/**
 * @author guybrush
 */
public class RoleHomeImpl implements RoleHome {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(RoleHomeImpl.class);

    private RoleDAO roleDao;

    public RoleHomeImpl() {
        super();
    }

    public void setRoleDao(RoleDAO roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * @see ar.com.espumito.security.RoleHome#findByName(java.lang.String)
     */
    public RoleBean findByName(String name) throws FinderException {
        RoleBean role = null;
        try {
            role = (RoleBean) this.roleDao.findByName(name);
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
            return (RoleBean) this.roleDao.find(id);
        } catch (PersistenceException e) {
            throw new ObjectNotFoundException(e.getMessage());
        }
    }

    /**
     * @see ar.com.espumito.security.domain.RoleHome#findAll()
     */
    public Set findAll() throws ar.com.espumito.core.ejb.FinderException {
        try {
            return new HashSet(this.roleDao.findAll());
        } catch (PersistenceException e) {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

	/* (non-Javadoc)
	 * @see ar.com.espumito.security.domain.RoleHome#create(java.lang.String)
	 */
	public RoleBean create(String name) throws CreateException {
		RoleBean role = new RoleBean();
		role.setName(name);
		try {
			return (RoleBean) this.roleDao.save(role);
		} catch (PersistenceException e) {
			throw new ar.com.espumito.core.ejb.CreateException(e);
		}
	}

}
