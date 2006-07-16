package ar.com.espumito.plugins.persistence;

import java.util.Collection;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.expression.Expression;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.persistence.hibernate.HibernateDAOImpl;
import ar.com.espumito.plugins.domain.MultiSocketBean;
import ar.com.espumito.plugins.domain.SimpleSocketBean;
import ar.com.espumito.plugins.domain.SocketBean;

public class SocketsHibernateDAOImpl extends HibernateDAOImpl implements
	SocketDAO {

    public SocketsHibernateDAOImpl(SessionFactory sessionFactory) {
	super(SocketBean.class, sessionFactory);
    }

    public Collection<MultiSocketBean> findAllMultiSockets()
	    throws PersistenceException {
	return null;
    }

    public Collection<SimpleSocketBean> findAllSimpleSockets()
	    throws PersistenceException {
	return null;
    }

    public SocketBean findByName(String name) throws PersistenceException {
	try {
	    Session session = getSessionFactory().openSession();
	    Criteria criteria = session.createCriteria(getManagedClass());
	    criteria.add(Expression.eq("name", name));
	    return (SocketBean) criteria.uniqueResult();
	} catch (HibernateException e) {
	    throw new PersistenceException(e);
	}
    }

}
