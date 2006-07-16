package ar.com.espumito.security.persistence;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.persistence.hibernate.HibernateDAOImpl;
import ar.com.espumito.security.domain.SecurityObjectBean;


public class SecurityObjectHibernateDAOImpl
    extends HibernateDAOImpl
    implements SecurityObjectDAO
{

    public SecurityObjectHibernateDAOImpl(SessionFactory sessionFactory)
    {
        super(SecurityObjectBean.class, sessionFactory);
    }

    public SecurityObjectBean findByName(String name)
        throws PersistenceException
    {
        Session session = null;
        Transaction tx = null;
        try
        {
            session = getSessionFactory().openSession();
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(getManagedClass()).add(Expression.eq("name", name));
            SecurityObjectBean securityObject = (SecurityObjectBean) criteria.uniqueResult();
            tx.commit();
            return securityObject;
        } catch (HibernateException e)
        {
            if (tx != null)
                try
                {
                    tx.rollback();
                } catch (HibernateException e1)
                {
                    throw new PersistenceException(e1);
                }
            throw new PersistenceException(e);
        } finally
        {
            if (session != null)
                try
                {
                    session.flush();
                    session.close();
                } catch (HibernateException e)
                {
                    throw new PersistenceException(e);
                }
        }
    }
}
