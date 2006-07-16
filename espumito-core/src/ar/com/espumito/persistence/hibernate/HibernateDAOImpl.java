package ar.com.espumito.persistence.hibernate;

import java.io.Serializable;
import java.util.Collection;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.expression.Order;
import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.persistence.PersistenceException;

public class HibernateDAOImpl
    implements DataAccessObject
{

    /**
     * Clase persistida por este DAO.
     */
    private Class          managedClass;
    private SessionFactory sessionFactory;

    public HibernateDAOImpl()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public HibernateDAOImpl(Class managedClass, SessionFactory sessionFactory)
    {
        super();
        this.managedClass = managedClass;
        this.sessionFactory = sessionFactory;
    }

    public void delete(Object object)
        throws PersistenceException
    {
        try
        {
            Session session = this.sessionFactory.openSession();
            session.delete(object);
        } catch (HibernateException e)
        {
            throw new PersistenceException(e);
        }
    }

    public Object find(Serializable id)
        throws PersistenceException
    {
        try
        {
            Session session = this.sessionFactory.openSession();
            return session.load(this.managedClass, id);
        } catch (HibernateException e)
        {
            throw new PersistenceException(e);
        }
    }

    public Collection findAll()
        throws PersistenceException
    {
        try
        {
            Session session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(getManagedClass());
            Order defaultOrder = getDefaultOrder();
            if (defaultOrder != null)
        	criteria = criteria.addOrder(defaultOrder);
            return criteria.list();
        } catch (HibernateException e)
        {
            throw new PersistenceException("Could not load objects.", e);
        }
    }

    /**
     * Elimina el paquete del nombre de una clase, para poder utilizar el valor resultante en las consultas de
     * Hibernate.
     * 
     * @return
     */
    protected String getManagedClassName()
    {
        // TODO: could improve
        String managedClassName = null;
        Class clazz = getManagedClass();
        String[] parts = clazz.getName().split("\\.");
        if (parts.length > 0)
            managedClassName = parts[parts.length - 1];
        else
            managedClassName = clazz.getName();
        return managedClassName;
    }

    public Collection findCollection(String query)
        throws PersistenceException
    {
        try
        {
            Session session = this.sessionFactory.openSession();
            return (Collection) session.find(query);
        } catch (HibernateException e)
        {
            throw new PersistenceException(e);
        }
    }
    
    protected Order getDefaultOrder()
    {
	return null;
    }

    /**
     * @return Returns the managedClass.
     */
    public Class getManagedClass()
    {
        return this.managedClass;
    }

    /**
     * @return Returns the sessionFactory.
     */
    public SessionFactory getSessionFactory()
    {
        return this.sessionFactory;
    }

    public Object save(Object object)
        throws PersistenceException
    {
        try
        {
            Session session = this.sessionFactory.openSession();
            session.saveOrUpdate(object);
            return object;
        } catch (HibernateException e)
        {
            throw new PersistenceException(e);
        }
    }

    /**
     * @param managedClass
     *            The managedClass to set.
     */
    public void setManagedClass(Class managedClass)
    {
        this.managedClass = managedClass;
    }

    /**
     * @param sessionFactory
     *            The sessionFactory to set.
     */
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public Object update(Object object)
        throws PersistenceException
    {
        return save(object);
    }
}
