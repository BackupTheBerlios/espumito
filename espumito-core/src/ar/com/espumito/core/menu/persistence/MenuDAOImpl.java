package ar.com.espumito.core.menu.persistence;

import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.expression.Expression;
import ar.com.espumito.core.menu.domain.MenuBean;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.persistence.hibernate.HibernateDAOImpl;


/**
 * <p>TODO: add description for MenuDAOImpl</p>
 * <p>Date: 21-mar-2006</p>
 *
 * @author guybrush
 *
 */
public class MenuDAOImpl
    extends HibernateDAOImpl
    implements MenuDAO
{

    public MenuDAOImpl()
    {
        super();
        this.setManagedClass(MenuBean.class);
    }

    /**
     * @see ar.com.espumito.core.menu.persistence.MenuDAO#findByName(java.lang.String)
     */
    public MenuBean findByName(String name) throws PersistenceException
    {
        try {
            Session session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(MenuBean.class);
            criteria.add(Expression.eq("name", name));
            MenuBean menu = (MenuBean) criteria.uniqueResult();
            if (menu != null)
                return menu;
            throw new PersistenceException("not found");
        }
        catch (HibernateException e) {
            throw new PersistenceException(e);
        }
    }
}
