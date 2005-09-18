/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.persistence;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.expression.Expression;
import ar.com.espumito.security.domain.RoleBean;
import ar.org.blah.j2ee.locator.ServiceLocatorException;
import ar.org.blah.j2ee.persistence.HibernateDAOImpl;
import ar.org.blah.j2ee.persistence.PersistenceException;

/**
 * @author guybrush
 */
public class RoleDAOImpl extends HibernateDAOImpl implements RoleDAO {

    public RoleDAOImpl() {
        super();
        setManagedClass(RoleBean.class);
    }

    /**
     * @see ar.com.espumito.persistence.RoleDAO#findByName(java.lang.String)
     */
    public RoleBean findByName(String name) throws PersistenceException {
        Session session = null;
        try {
            session = getServiceLocator().getHibernateSession();
            Criteria criteria = session.createCriteria(RoleBean.class);
            criteria.add(Expression.eq("name", name));
            return (RoleBean) criteria.uniqueResult();
        } catch (ServiceLocatorException e) {
            throw new PersistenceException(e);
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        } finally {
            try {
                if (session != null)
                    session.close();
            } catch (HibernateException e) {
                throw new PersistenceException(e);
            }
        }
    }

}
