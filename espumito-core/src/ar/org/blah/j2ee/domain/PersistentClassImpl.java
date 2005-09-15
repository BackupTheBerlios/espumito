/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.domain;

import ar.org.blah.j2ee.locator.ServiceLocatorException;
import ar.org.blah.j2ee.locator.ServiceLocatorFactory;
import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.persistence.DataAccessObjectFactory;
import ar.org.blah.j2ee.persistence.PersistenceException;

public abstract class PersistentClassImpl extends BasicBean implements
        PersistentClass {
    private DataAccessObject dao;

    private DataAccessObjectFactory daoFactory;

    public PersistentClassImpl() {

    }

    public final synchronized DataAccessObject getDataAccessObject()
            throws ServiceLocatorException {
        if (dao == null)
            dao = createDataAccessObject();
        return dao;
    }

    public void setDaoFactory(DataAccessObjectFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    protected DataAccessObject createDataAccessObject()
            throws ServiceLocatorException {
        // Lo hacemos asi para conservar la compatibilidad con versiones anteriores.
        if (daoFactory != null)
            return daoFactory.getDataAccessObject(getClass());
        else
            return ServiceLocatorFactory.getInstance().createServiceLocator()
                    .getDataAccessObject(this.getClass());
    }

    /**
     * @see ar.org.blah.j2ee.domain.PersistentClass#save()
     */
    public Object save() throws PersistenceException {
        try {
            return getDataAccessObject().save(this);
        } catch (ServiceLocatorException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * @see ar.org.blah.j2ee.domain.PersistentClass#update()
     */
    public void update() throws PersistenceException {
        try {
            getDataAccessObject().update(this);
        } catch (ServiceLocatorException e) {
            throw new PersistenceException(e);
        }

    }

    /**
     * @see ar.org.blah.j2ee.domain.PersistentClass#delete()
     */
    public void delete() throws PersistenceException {
        try {
            DataAccessObject myDao = getDataAccessObject();
            myDao.delete(this);
        } catch (ServiceLocatorException e) {
            throw new PersistenceException(e);
        }
    }

}
