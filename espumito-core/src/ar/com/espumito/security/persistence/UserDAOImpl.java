/*
 * Created on 13-may-2005
 */
package ar.com.espumito.security.persistence;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.persistence.hibernate.HibernateDAOImpl;
import ar.com.espumito.security.domain.UserBean;
import ar.com.espumito.util.StringUtil;

public class UserDAOImpl extends HibernateDAOImpl implements UserDAO {

    private static final String USERNAME_PARAM = "username";

    public UserDAOImpl() {
        super();
        setManagedClass(UserBean.class);
    }

    /**
     * @see ar.com.espumito.persistence.UserDAO#findByUsername(java.lang.String)
     */
    public UserBean findByUsername(String username) throws PersistenceException {
        if (StringUtil.isBlank(username))
            return null;

        Session session = null;
        try {
        	session = getSessionFactory().openSession();
            Query findByUsernameQuery = session.createQuery("from "
                    + getManagedClass().getName() + " user where user.username = :"
                    + USERNAME_PARAM);
            findByUsernameQuery.setString(USERNAME_PARAM, username);
            return (UserBean) findByUsernameQuery.uniqueResult();
        } catch (HibernateException e) {
            throw new PersistenceException(e);
        }
    }

}
