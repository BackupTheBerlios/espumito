/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Collection;

import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import ar.com.espumito.ejb.AbstractHome;
import ar.org.blah.j2ee.locator.ServiceLocator;
import ar.org.blah.j2ee.locator.ServiceLocatorException;
import ar.org.blah.j2ee.locator.ServiceLocatorFactory;
import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.persistence.PersistenceException;

public class RoleGroupHomeImpl extends AbstractHome implements RoleGroupHome {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(RoleGroupHomeImpl.class);

    private DataAccessObject roleGroupDao;

    public RoleGroupHomeImpl() {
        super();
    }

    /**
     * Lazy loading para <code>serviceLocator</code>.
     * 
     * @return
     * @throws ServiceLocatorException
     */
    protected synchronized ServiceLocator getServiceLocator()
            throws ar.org.blah.j2ee.locator.ServiceLocatorException {
        return ServiceLocatorFactory.getInstance().createServiceLocator();
    }

    /**
     * Lazy loading para {@link #roleGroupDao}.
     * 
     * @return
     * @throws ServiceLocatorException
     */
    protected synchronized DataAccessObject getRoleGroupDao()
            throws ServiceLocatorException {
        if (roleGroupDao == null)
            roleGroupDao = getServiceLocator().getDataAccessObject(
                    RoleGroupBean.class);
        return roleGroupDao;
    }

    /**
     * @see ar.com.espumito.security.RoleGroupHome#findByPrimaryKey(java.lang.Long)
     */
    public RoleGroupBean findByPrimaryKey(Long id) throws FinderException {
        if (id == null)
            throw new ObjectNotFoundException();
        try {
            return (RoleGroupBean) getRoleGroupDao().find(id);
        } catch (PersistenceException e) {
            logger.error("Error loading role group " + id, e);
            throw new ObjectNotFoundException(e.getMessage());
        } catch (ServiceLocatorException e) {
            logger.error("Error loading role group " + id, e);
            throw new FinderException(e.getMessage());
        }
    }

    /**
     * @see ar.com.espumito.security.RoleGroupHome#findDefaultRoleGroup()
     */
    public RoleGroupBean findDefaultRoleGroup() throws FinderException {
        // TODO: Estamos hardoceando el id del grupo un poquito, ¿no? Habria
        // que cambiar esto y ponerlo como configuracion.
        return findByPrimaryKey(new Long(1));
    }

    public void setRoleGroupDao(DataAccessObject roleGroupDao) {
        this.roleGroupDao = roleGroupDao;
    }

    public Collection findAll() throws ar.org.blah.j2ee.FinderException {
        try {
            return roleGroupDao.findAll();
        } catch (PersistenceException e) {
            throw new ar.org.blah.j2ee.FinderException(e);
        }
    }

}
