/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Collection;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.persistence.PersistenceException;

public class RoleGroupHomeImpl implements RoleGroupHome {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(RoleGroupHomeImpl.class);

	private DataAccessObject roleGroupDao;

	public RoleGroupHomeImpl() {
		super();
	}

	public Collection findAll() throws ar.com.espumito.core.ejb.FinderException {
		try {
			return this.roleGroupDao.findAll();
		} catch (PersistenceException e) {
			throw new ar.com.espumito.core.ejb.FinderException(e);
		}
	}

	/**
	 * @see ar.com.espumito.security.RoleGroupHome#findByPrimaryKey(java.lang.Long)
	 */
	public RoleGroupBean findByPrimaryKey(Long id) throws FinderException {
		if (id == null)
			throw new ObjectNotFoundException();
		try {
			return (RoleGroupBean) this.roleGroupDao.find(id);
		} catch (PersistenceException e) {
			logger.error("Error loading role group " + id, e);
			throw new ObjectNotFoundException(e.getMessage());
		}
	}

	/**
	 * @see ar.com.espumito.security.RoleGroupHome#findDefaultRoleGroup()
	 */
	public RoleGroupBean findDefaultRoleGroup() throws FinderException {
		/*
		 * TODO: Estamos hardoceando el id del grupo un poquito, �no? Habria que
		 * cambiar esto y ponerlo como configuracion.
		 */
		return findByPrimaryKey(new Long(1));
	}

	public void setRoleGroupDao(DataAccessObject roleGroupDao) {
		this.roleGroupDao = roleGroupDao;
	}
}
