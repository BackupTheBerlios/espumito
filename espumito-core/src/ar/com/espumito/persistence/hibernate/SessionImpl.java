package ar.com.espumito.persistence.hibernate;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.FlushMode;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.LockMode;
import net.sf.hibernate.Query;
import net.sf.hibernate.ReplicationMode;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.type.Type;

public class SessionImpl
    implements Session
{

    private Session session;

    public SessionImpl(Session session)
    {
        super();
        // TODO Auto-generated constructor stub
        this.session = session;
    }

    /**
     * @see net.sf.hibernate.Session#beginTransaction()
     */
    public Transaction beginTransaction()
        throws HibernateException
    {
        return this.session.beginTransaction();
    }

    /**
     * @see net.sf.hibernate.Session#cancelQuery()
     */
    public void cancelQuery()
        throws HibernateException
    {
        this.session.cancelQuery();
    }

    /**
     * @see net.sf.hibernate.Session#clear()
     */
    public void clear()
    {
        this.session.clear();
    }

    /**
     * @see net.sf.hibernate.Session#close()
     */
    public Connection close()
        throws HibernateException
    {
        return this.session.connection();
    }

    /**
     * @see net.sf.hibernate.Session#connection()
     */
    public Connection connection()
        throws HibernateException
    {
        return this.session.connection();
    }

    /**
     * @see net.sf.hibernate.Session#contains(java.lang.Object)
     */
    public boolean contains(Object object)
    {
        return this.session.contains(object);
    }

    /**
     * @see net.sf.hibernate.Session#createCriteria(java.lang.Class)
     */
    public Criteria createCriteria(Class persistentClass)
    {
        return this.session.createCriteria(persistentClass);
    }

    /**
     * @see net.sf.hibernate.Session#createFilter(java.lang.Object, java.lang.String)
     */
    public Query createFilter(Object collection, String queryString)
        throws HibernateException
    {
        return this.session.createFilter(collection, queryString);
    }

    /**
     * @see net.sf.hibernate.Session#createQuery(java.lang.String)
     */
    public Query createQuery(String queryString)
        throws HibernateException
    {
        return this.session.createQuery(queryString);
    }

    /**
     * @see net.sf.hibernate.Session#createSQLQuery(java.lang.String, java.lang.String, java.lang.Class)
     */
    public Query createSQLQuery(String sql, String returnAlias, Class returnClass)
    {
        return this.session.createSQLQuery(sql, returnAlias, returnClass);
    }

    /**
     * @see net.sf.hibernate.Session#createSQLQuery(java.lang.String, java.lang.String[], java.lang.Class[])
     */
    public Query createSQLQuery(String sql, String[] returnAliases, Class[] returnClasses)
    {
        return this.session.createSQLQuery(sql, returnAliases, returnClasses);
    }

    /**
     * @see net.sf.hibernate.Session#delete(java.lang.Object)
     */
    public void delete(Object object)
        throws HibernateException
    {
        this.session.delete(object);
    }

    /**
     * @see net.sf.hibernate.Session#delete(java.lang.String)
     */
    public int delete(String query)
        throws HibernateException
    {
        return this.session.delete(query);
    }

    /**
     * @see net.sf.hibernate.Session#delete(java.lang.String, java.lang.Object, net.sf.hibernate.type.Type)
     */
    public int delete(String query, Object value, Type type)
        throws HibernateException
    {
        return this.session.delete(query, value, type);
    }

    /**
     * @see net.sf.hibernate.Session#delete(java.lang.String, java.lang.Object[], net.sf.hibernate.type.Type[])
     */
    public int delete(String query, Object[] values, Type[] types)
        throws HibernateException
    {
        return this.session.delete(query, values, types);
    }

    /**
     * @see net.sf.hibernate.Session#disconnect()
     */
    public Connection disconnect()
        throws HibernateException
    {
        return this.session.disconnect();
    }

    /**
     * @see net.sf.hibernate.Session#evict(java.lang.Object)
     */
    public void evict(Object object)
        throws HibernateException
    {
        this.session.evict(object);
    }

    /**
     * @see net.sf.hibernate.Session#filter(java.lang.Object, java.lang.String)
     */
    public Collection filter(Object collection, String filter)
        throws HibernateException
    {
        return this.session.filter(collection, filter);
    }

    /**
     * @see net.sf.hibernate.Session#filter(java.lang.Object, java.lang.String, java.lang.Object,
     *      net.sf.hibernate.type.Type)
     */
    public Collection filter(Object collection, String filter, Object value, Type type)
        throws HibernateException
    {
        return this.session.filter(collection, filter, value, type);
    }

    /**
     * @see net.sf.hibernate.Session#filter(java.lang.Object, java.lang.String, java.lang.Object[],
     *      net.sf.hibernate.type.Type[])
     */
    public Collection filter(Object collection, String filter, Object[] values, Type[] types)
        throws HibernateException
    {
        return this.session.filter(collection, filter, values, types);
    }

    /**
     * @see net.sf.hibernate.Session#find(java.lang.String)
     */
    public List find(String query)
        throws HibernateException
    {
        return this.session.find(query);
    }

    /**
     * @see net.sf.hibernate.Session#find(java.lang.String, java.lang.Object, net.sf.hibernate.type.Type)
     */
    public List find(String query, Object value, Type type)
        throws HibernateException
    {
        return this.session.find(query, value, type);
    }

    /**
     * @see net.sf.hibernate.Session#find(java.lang.String, java.lang.Object[], net.sf.hibernate.type.Type[])
     */
    public List find(String query, Object[] values, Type[] types)
        throws HibernateException
    {
        return this.session.find(query, values, types);
    }

    /**
     * @see net.sf.hibernate.Session#flush()
     */
    public void flush()
        throws HibernateException
    {
        //session.flush();
    }

    /**
     * @see net.sf.hibernate.Session#get(java.lang.Class, java.io.Serializable)
     */
    public Object get(Class clazz, Serializable id)
        throws HibernateException
    {
        return this.session.get(clazz, id);
    }

    /**
     * @see net.sf.hibernate.Session#get(java.lang.Class, java.io.Serializable, net.sf.hibernate.LockMode)
     */
    public Object get(Class clazz, Serializable id, LockMode lockMode)
        throws HibernateException
    {
        return this.session.get(clazz, id, lockMode);
    }

    /**
     * @see net.sf.hibernate.Session#getCurrentLockMode(java.lang.Object)
     */
    public LockMode getCurrentLockMode(Object object)
        throws HibernateException
    {
        return this.session.getCurrentLockMode(object);
    }

    /**
     * @see net.sf.hibernate.Session#getFlushMode()
     */
    public FlushMode getFlushMode()
    {
        return this.session.getFlushMode();
    }

    /**
     * @see net.sf.hibernate.Session#getIdentifier(java.lang.Object)
     */
    public Serializable getIdentifier(Object object)
        throws HibernateException
    {
        return this.session.getIdentifier(object);
    }

    /**
     * @see net.sf.hibernate.Session#getNamedQuery(java.lang.String)
     */
    public Query getNamedQuery(String queryName)
        throws HibernateException
    {
        return this.session.getNamedQuery(queryName);
    }

    /**
     * @see net.sf.hibernate.Session#getSessionFactory()
     */
    public SessionFactory getSessionFactory()
    {
        return this.session.getSessionFactory();
    }

    /**
     * @see net.sf.hibernate.Session#isConnected()
     */
    public boolean isConnected()
    {
        return this.session.isConnected();
    }

    /**
     * @see net.sf.hibernate.Session#isDirty()
     */
    public boolean isDirty()
        throws HibernateException
    {
        return this.session.isDirty();
    }

    /**
     * @see net.sf.hibernate.Session#isOpen()
     */
    public boolean isOpen()
    {
        return this.session.isOpen();
    }

    /**
     * @see net.sf.hibernate.Session#iterate(java.lang.String)
     */
    public Iterator iterate(String query)
        throws HibernateException
    {
        return this.session.iterate(query);
    }

    /**
     * @see net.sf.hibernate.Session#iterate(java.lang.String, java.lang.Object, net.sf.hibernate.type.Type)
     */
    public Iterator iterate(String query, Object value, Type type)
        throws HibernateException
    {
        return this.session.iterate(query, value, type);
    }

    /**
     * @see net.sf.hibernate.Session#iterate(java.lang.String, java.lang.Object[], net.sf.hibernate.type.Type[])
     */
    public Iterator iterate(String query, Object[] values, Type[] types)
        throws HibernateException
    {
        return this.session.iterate(query, values, types);
    }

    /**
     * @see net.sf.hibernate.Session#load(java.lang.Class, java.io.Serializable)
     */
    public Object load(Class theClass, Serializable id)
        throws HibernateException
    {
        return this.session.load(theClass, id);
    }

    /**
     * @see net.sf.hibernate.Session#load(java.lang.Class, java.io.Serializable, net.sf.hibernate.LockMode)
     */
    public Object load(Class theClass, Serializable id, LockMode lockMode)
        throws HibernateException
    {
        return this.session.load(theClass, id, lockMode);
    }

    /**
     * @see net.sf.hibernate.Session#load(java.lang.Object, java.io.Serializable)
     */
    public void load(Object object, Serializable id)
        throws HibernateException
    {
        this.session.load(object, id);
    }

    /**
     * @see net.sf.hibernate.Session#lock(java.lang.Object, net.sf.hibernate.LockMode)
     */
    public void lock(Object object, LockMode lockMode)
        throws HibernateException
    {
        this.session.lock(object, lockMode);
    }

    /**
     * @see net.sf.hibernate.Session#reconnect()
     */
    public void reconnect()
        throws HibernateException
    {
        this.session.reconnect();
    }

    /**
     * @see net.sf.hibernate.Session#reconnect(java.sql.Connection)
     */
    public void reconnect(Connection connection)
        throws HibernateException
    {
        this.session.reconnect(connection);
    }

    /**
     * @see net.sf.hibernate.Session#refresh(java.lang.Object)
     */
    public void refresh(Object object)
        throws HibernateException
    {
        this.session.refresh(object);
    }

    /**
     * @see net.sf.hibernate.Session#refresh(java.lang.Object, net.sf.hibernate.LockMode)
     */
    public void refresh(Object object, LockMode lockMode)
        throws HibernateException
    {
        this.session.refresh(object, lockMode);
    }

    /**
     * @see net.sf.hibernate.Session#replicate(java.lang.Object, net.sf.hibernate.ReplicationMode)
     */
    public void replicate(Object object, ReplicationMode replicationMode)
        throws HibernateException
    {
        this.session.replicate(object, replicationMode);
    }

    /**
     * @see net.sf.hibernate.Session#save(java.lang.Object)
     */
    public Serializable save(Object object)
        throws HibernateException
    {
        return this.session.save(object);
    }

    /**
     * @see net.sf.hibernate.Session#save(java.lang.Object, java.io.Serializable)
     */
    public void save(Object object, Serializable id)
        throws HibernateException
    {
        this.session.save(object, id);
    }

    /**
     * @see net.sf.hibernate.Session#saveOrUpdate(java.lang.Object)
     */
    public void saveOrUpdate(Object object)
        throws HibernateException
    {
        this.session.saveOrUpdate(object);
    }

    /**
     * @see net.sf.hibernate.Session#saveOrUpdateCopy(java.lang.Object)
     */
    public Object saveOrUpdateCopy(Object object)
        throws HibernateException
    {
        return this.session.saveOrUpdateCopy(object);
    }

    /**
     * @see net.sf.hibernate.Session#saveOrUpdateCopy(java.lang.Object, java.io.Serializable)
     */
    public Object saveOrUpdateCopy(Object object, Serializable id)
        throws HibernateException
    {
        return this.session.saveOrUpdateCopy(object, id);
    }

    /**
     * @see net.sf.hibernate.Session#setFlushMode(net.sf.hibernate.FlushMode)
     */
    public void setFlushMode(FlushMode flushMode)
    {
        this.session.setFlushMode(flushMode);
    }

    /**
     * @see net.sf.hibernate.Session#update(java.lang.Object)
     */
    public void update(Object object)
        throws HibernateException
    {
        this.session.update(object);
    }

    /**
     * @see net.sf.hibernate.Session#update(java.lang.Object, java.io.Serializable)
     */
    public void update(Object object, Serializable id)
        throws HibernateException
    {
        this.session.update(object, id);
    }
    
    public void forceClose() throws HibernateException
    {
        this.session.close();
    }
    
    public void forceFlush() throws HibernateException 
    {
        this.session.flush();
    }
}
