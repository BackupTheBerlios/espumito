package ar.com.espumito.support.hibernate;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Map;
import javax.naming.NamingException;
import javax.naming.Reference;
import net.sf.hibernate.Databinder;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Interceptor;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.exception.SQLExceptionConverter;
import net.sf.hibernate.metadata.ClassMetadata;
import net.sf.hibernate.metadata.CollectionMetadata;

public class ThreadLocalSessionFactory
    implements SessionFactory
{

    private ThreadLocal sessionFactoryThreadLocal = new ThreadLocal();
    private SessionFactory sessionFactory;

    public ThreadLocalSessionFactory(SessionFactory sessionFactory)
    {
        super();
        this.sessionFactory = sessionFactory;
    }

    public ThreadLocalSessionFactory()
    {
        super();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#close()
     */
    public void close()
        throws HibernateException
    {
        getSessionFactory().close();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evict(java.lang.Class, java.io.Serializable)
     */
    public void evict(Class persistentClass, Serializable id)
        throws HibernateException
    {
        getSessionFactory().evict(persistentClass, id);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evict(java.lang.Class)
     */
    public void evict(Class persistentClass)
        throws HibernateException
    {
        getSessionFactory().evict(persistentClass);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evictCollection(java.lang.String, java.io.Serializable)
     */
    public void evictCollection(String roleName, Serializable id)
        throws HibernateException
    {
        getSessionFactory().evictCollection(roleName, id);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evictCollection(java.lang.String)
     */
    public void evictCollection(String roleName)
        throws HibernateException
    {
        getSessionFactory().evictCollection(roleName);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evictQueries()
     */
    public void evictQueries()
        throws HibernateException
    {
        getSessionFactory().evictQueries();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evictQueries(java.lang.String)
     */
    public void evictQueries(String cacheRegion)
        throws HibernateException
    {
        getSessionFactory().evictQueries(cacheRegion);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#getAllClassMetadata()
     */
    public Map getAllClassMetadata()
        throws HibernateException
    {
        return getSessionFactory().getAllClassMetadata();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#getAllCollectionMetadata()
     */
    public Map getAllCollectionMetadata()
        throws HibernateException
    {
        return getSessionFactory().getAllCollectionMetadata();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#getClassMetadata(java.lang.Class)
     */
    public ClassMetadata getClassMetadata(Class persistentClass)
        throws HibernateException
    {
        return getSessionFactory().getClassMetadata(persistentClass);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#getCollectionMetadata(java.lang.String)
     */
    public CollectionMetadata getCollectionMetadata(String roleName)
        throws HibernateException
    {
        return getSessionFactory().getCollectionMetadata(roleName);
    }

    /**
     * @see javax.naming.Referenceable#getReference()
     */
    public Reference getReference()
        throws NamingException
    {
        return getSessionFactory().getReference();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openDatabinder()
     */
    public Databinder openDatabinder()
        throws HibernateException
    {
        return getSessionFactory().openDatabinder();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openSession()
     */
    public Session openSession()
        throws HibernateException
    {
        return getSessionFactory().openSession();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openSession(java.sql.Connection, net.sf.hibernate.Interceptor)
     */
    public Session openSession(Connection connection, Interceptor interceptor)
    {
        return getSessionFactory().openSession(connection, interceptor);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openSession(java.sql.Connection)
     */
    public Session openSession(Connection connection)
    {
        return getSessionFactory().openSession(connection);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openSession(net.sf.hibernate.Interceptor)
     */
    public Session openSession(Interceptor interceptor)
        throws HibernateException
    {
        return getSessionFactory().openSession(interceptor);
    }

    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory()
    {
        return this.sessionFactory;
    }

	public SQLExceptionConverter getSQLExceptionConverter() {
		return this.sessionFactory.getSQLExceptionConverter();
	}
}
