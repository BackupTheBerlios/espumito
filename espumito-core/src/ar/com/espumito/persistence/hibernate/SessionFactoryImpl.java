package ar.com.espumito.persistence.hibernate;

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

public class SessionFactoryImpl
    implements SessionFactory
{

    private SessionFactory sessionFactory;
    private ThreadLocal    localSession = new ThreadLocal();

    public SessionFactoryImpl(SessionFactory sessionFactory)
    {
        super();
        this.sessionFactory = sessionFactory;
    }

    /**
     * @see net.sf.hibernate.SessionFactory#close()
     */
    public void close()
        throws HibernateException
    {
        this.sessionFactory.close();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evict(java.lang.Class, java.io.Serializable)
     */
    public void evict(Class persistentClass, Serializable id)
        throws HibernateException
    {
        this.sessionFactory.evict(persistentClass, id);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evict(java.lang.Class)
     */
    public void evict(Class persistentClass)
        throws HibernateException
    {
        this.sessionFactory.evict(persistentClass);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evictCollection(java.lang.String, java.io.Serializable)
     */
    public void evictCollection(String roleName, Serializable id)
        throws HibernateException
    {
        this.sessionFactory.evictCollection(roleName, id);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evictCollection(java.lang.String)
     */
    public void evictCollection(String roleName)
        throws HibernateException
    {
        this.sessionFactory.evictCollection(roleName);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evictQueries()
     */
    public void evictQueries()
        throws HibernateException
    {
        this.sessionFactory.evictQueries();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#evictQueries(java.lang.String)
     */
    public void evictQueries(String cacheRegion)
        throws HibernateException
    {
        this.sessionFactory.evictQueries(cacheRegion);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#getAllClassMetadata()
     */
    public Map getAllClassMetadata()
        throws HibernateException
    {
        return this.sessionFactory.getAllClassMetadata();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#getAllCollectionMetadata()
     */
    public Map getAllCollectionMetadata()
        throws HibernateException
    {
        return this.sessionFactory.getAllCollectionMetadata();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#getClassMetadata(java.lang.Class)
     */
    public ClassMetadata getClassMetadata(Class persistentClass)
        throws HibernateException
    {
        return this.sessionFactory.getClassMetadata(persistentClass);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#getCollectionMetadata(java.lang.String)
     */
    public CollectionMetadata getCollectionMetadata(String roleName)
        throws HibernateException
    {
        return this.sessionFactory.getCollectionMetadata(roleName);
    }

    /**
     * @see javax.naming.Referenceable#getReference()
     */
    public Reference getReference()
        throws NamingException
    {
        return this.sessionFactory.getReference();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openDatabinder()
     */
    public Databinder openDatabinder()
        throws HibernateException
    {
        return this.sessionFactory.openDatabinder();
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openSession()
     */
    public Session openSession()
        throws HibernateException
    {
        SessionImpl session = (SessionImpl) this.localSession.get();
        if (session == null || !session.isOpen())
        {
            session = new SessionImpl(this.sessionFactory.openSession());
            this.localSession.set(session);
        }
        return session;
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openSession(java.sql.Connection, net.sf.hibernate.Interceptor)
     */
    public Session openSession(Connection connection, Interceptor interceptor)
    {
        return this.sessionFactory.openSession(connection, interceptor);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openSession(java.sql.Connection)
     */
    public Session openSession(Connection connection)
    {
        return this.sessionFactory.openSession(connection);
    }

    /**
     * @see net.sf.hibernate.SessionFactory#openSession(net.sf.hibernate.Interceptor)
     */
    public Session openSession(Interceptor interceptor)
        throws HibernateException
    {
        return this.sessionFactory.openSession(interceptor);
    }

	public SQLExceptionConverter getSQLExceptionConverter() {
		return this.sessionFactory.getSQLExceptionConverter();
	}

   
}
