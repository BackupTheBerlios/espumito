/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.persistence;

import java.io.Serializable;
import java.util.Collection;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;

import org.apache.log4j.Logger;

import ar.org.blah.j2ee.locator.ServiceLocator;
import ar.org.blah.j2ee.locator.ServiceLocatorException;
import ar.org.blah.j2ee.locator.ServiceLocatorFactory;

/**
 * DAO que utiliza Hibernate para persistir los objetos.
 * 
 * @author guybrush
 */
public class HibernateDAOImpl implements HibernateDAO {
    /**
     * Logger a utilizar en esta clase.
     */
    private static Logger logger = Logger.getLogger(HibernateDAOImpl.class);

    /**
     * Clase persistida por este DAO.
     */
    private Class managedClass;

    /**
     * Nombre de la clase persistida por este DAO, sin el nombre del paquete.
     */
    private String managedClassName;

    /**
     * Fabrica de sessiones para Hibernate.
     */
    private SessionFactory sessionFactory;

    public HibernateDAOImpl() {
        super();
    }

    public SessionFactory getSessionFactory() {
        try {
            return (sessionFactory != null) ? sessionFactory
                    : getServiceLocator().getHibernateSessionFactory();
        } catch (ServiceLocatorException e) {
            e.printStackTrace();
            // FIXME: horrible!
            return null;
        }
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * @see ar.org.blah.j2ee.persistence.DataAccessObject#delete(java.lang.Object)
     */
    public void delete(Object object) throws PersistenceException {
        Session session = null;
        Transaction tx = null;
        if (object == null)
            throw new IllegalArgumentException();
        logger.debug("Deleting object of type " + getManagedClass().getName());
        try {
            session = getSessionFactory().openSession();
            session.delete(object);
            session.flush();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (HibernateException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @see ar.org.blah.j2ee.persistence.DataAccessObject#find(java.io.Serializable)
     */
    public Object find(Serializable id) throws PersistenceException {
        Session session = null;
        logger.debug("Finding object of type " + getManagedClass().getName());
        try {
            session = getSessionFactory().openSession();
            Object object = session.load(getManagedClass(), id);
            return object;
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (HibernateException e) {
                throw new PersistenceException(e);
            }
        }
    }

    /**
     * @see ar.org.blah.j2ee.persistence.DataAccessObject#findAll()
     */
    public Collection findAll() throws PersistenceException {
        logger.debug("Finding all objects of type "
                + getManagedClass().getName());
        return findCollection("from " + getManagedClassName() + " "
                + getDefaultOrder());
    }

    /**
     * @see ar.org.blah.j2ee.persistence.HibernateDAO#getManagedClass()
     */
    public Class getManagedClass() {
        return managedClass;
    }

    protected ServiceLocator getServiceLocator() throws ServiceLocatorException {
        return ServiceLocatorFactory.getInstance().createServiceLocator();
    }

    /**
     * @see ar.org.blah.j2ee.persistence.DataAccessObject#save(java.lang.Object)
     */
    public Object save(Object object) throws PersistenceException {
        Session session = null;
        Transaction tx = null;
        logger.debug("Saving object of type " + getManagedClass().getName());
        try {
            session = getSessionFactory().openSession();
            session.saveOrUpdate(object);
            session.flush();
            return object;
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                session.close();
            } catch (HibernateException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * @see ar.org.blah.j2ee.persistence.HibernateDAO#setManagedClass(java.lang.Class)
     */
    public void setManagedClass(Class clazz) {
        if (clazz == null)
            throw new IllegalArgumentException();
        managedClass = clazz;
    }

    public void setManagedClassName(String className) {
        if (className == null || className.trim().equals(""))
            throw new IllegalArgumentException();
        try {
            managedClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /**
     * @see ar.org.blah.j2ee.persistence.DataAccessObject#update(java.lang.Object)
     */
    public Object update(Object object) throws PersistenceException {
        return save(object);
    }

    /**
     * Elimina el paquete del nombre de una clase, para poder utilizar el valor
     * resultante en las consultas de Hibernate.
     * 
     * @return
     */
    protected String getManagedClassName() {
        if (managedClassName == null) {
            Class clazz = getManagedClass();
            String[] parts = clazz.getName().split("\\.");
            if (parts.length > 0)
                managedClassName = parts[parts.length - 1];
            else
                managedClassName = clazz.getName();
        }
        return managedClassName;
    }

    /**
     * @see ar.org.blah.j2ee.persistence.DataAccessObject#findAll()
     */
    public Collection findCollection(String query) throws PersistenceException {
        Session session = null;
        Transaction tx = null;
        logger.debug("Finding object collection of type "
                + getManagedClass().getName() + " (query: " + query);
        try {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            Collection collection = session.find(query);
            tx.commit();
            session.flush();
            return collection;
        } catch (HibernateException e) {
            try {
                if (tx != null)
                    tx.rollback();
                throw new PersistenceException(e);
            } catch (HibernateException e1) {
                throw new PersistenceException(e1);
            }
        } finally {

            try {
                if (session != null)
                    session.close();
            } catch (HibernateException e) {
                throw new PersistenceException(e);
            }
        }

    }

    protected String getDefaultOrder() {
        return "order by id desc";
    }
}
