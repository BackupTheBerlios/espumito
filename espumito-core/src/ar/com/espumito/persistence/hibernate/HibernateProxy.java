package ar.com.espumito.persistence.hibernate;

import java.lang.reflect.Method;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import ar.com.espumito.support.spring.InvocationHandler;

public class HibernateProxy
    implements InvocationHandler
{

    private Object         realObject;
    private SessionFactory sessionFactory;

    public HibernateProxy()
    {
        super();
    }

    public Object invoke(Object proxy, Method method, Object[] args)
        throws Throwable
    {
        Session session = null;
        Transaction tx = null;
        session = this.sessionFactory.openSession();
        try
        {
            if (!session.isConnected())
                session.reconnect();
            tx = session.beginTransaction();
        } catch (HibernateException e)
        {
            session.disconnect();
            throw e;
        }
        SessionImpl sessionImpl = null; 
        if (session instanceof SessionImpl)
            sessionImpl = (SessionImpl) session;
        try
        {
            Object ret = method.invoke(this.realObject, args);
            if (sessionImpl != null)
            {
                sessionImpl.forceFlush();
                tx.commit();
            }
            else
            {
                session.flush();
                tx.commit();
            }
            return ret;
        } catch (Throwable e)
        {
            tx.rollback();
            if (sessionImpl != null)
                sessionImpl.forceClose();
            else
                session.close();
            throw e;
        } finally
        {
            //session.disconnect();
            if (sessionImpl != null)
                sessionImpl.forceClose();
            else
                session.close();
            
        }
    }

    /**
     * @param realObject
     *            The realObject to set.
     */
    public void setRealObject(Object realObject)
    {
        this.realObject = realObject;
    }

    /**
     * @param sessionFactory
     *            The sessionFactory to set.
     */
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        this.sessionFactory = sessionFactory;
    }
}
