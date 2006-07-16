package ar.com.espumito.security.persistence;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.expression.Expression;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.persistence.hibernate.HibernateDAOImpl;
import ar.com.espumito.security.domain.OperationBean;

public class OperationHibernateDAOImpl
    extends HibernateDAOImpl
    implements OperationDAO
{

    public OperationBean findByName(String name)
        throws PersistenceException
    {
        try
        {
            Session session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(getManagedClass());
            criteria.add(Expression.eq("name", name));
            return (OperationBean) criteria.uniqueResult();
        } catch (HibernateException e)
        {
            throw new PersistenceException(e);
        }
    }
}
