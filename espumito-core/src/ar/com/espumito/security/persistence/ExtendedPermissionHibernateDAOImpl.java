package ar.com.espumito.security.persistence;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.expression.Expression;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.persistence.hibernate.HibernateDAOImpl;
import ar.com.espumito.security.domain.ExtendedPermissionBean;

public class ExtendedPermissionHibernateDAOImpl
    extends HibernateDAOImpl
    implements ExtendedPermissionDAO
{

    public ExtendedPermissionHibernateDAOImpl(SessionFactory sessionFactory)
    {
        super(ExtendedPermissionBean.class, sessionFactory);
    }
    
    public ExtendedPermissionBean findByName(String name)
        throws PersistenceException
    {
        try
        {
            Session session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(getManagedClass());
            criteria.add(Expression.eq("name", name));
            return (ExtendedPermissionBean) criteria.uniqueResult();
        } catch (HibernateException e)
        {
            throw new PersistenceException(e);
        }
    }

}
