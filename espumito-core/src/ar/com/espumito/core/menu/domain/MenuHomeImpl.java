package ar.com.espumito.core.menu.domain;

import java.util.Collection;
import javax.ejb.FinderException;
import ar.com.espumito.core.menu.persistence.MenuDAO;
import ar.com.espumito.persistence.PersistenceException;

/**
 * <p>
 * Implementation of menu home interface.
 * </p>
 * <p>
 * Date: 20-mar-2006
 * </p>
 * 
 * @author guybrush
 */
public class MenuHomeImpl
    implements MenuHome
{

    public MenuDAO menuDao;

    public MenuHomeImpl(MenuDAO menuDao)
    {
        super();
        this.menuDao = menuDao;
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuHome#findByPrimaryKey(java.lang.Long)
     */
    public MenuBean findByPrimaryKey(Long id)
        throws FinderException
    {
        try
        {
            return (MenuBean) this.menuDao.find(id);
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuHome#findByName(java.lang.String)
     */
    public MenuBean findByName(String name)
        throws FinderException
    {
        try
        {
            return this.menuDao.findByName(name);
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuHome#findAll()
     */
    public Collection findAll()
        throws FinderException
    {
        try
        {
            return this.menuDao.findAll();
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }
}
