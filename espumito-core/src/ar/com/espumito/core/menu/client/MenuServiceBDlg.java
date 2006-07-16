package ar.com.espumito.core.menu.client;

import java.security.Principal;
import java.util.Collection;
import javax.ejb.FinderException;
import ar.com.espumito.core.menu.locator.MenuServiceLocatorFactory;
import ar.com.espumito.core.menu.services.MenuService;
import ar.com.espumito.core.menu.vo.MenuVO;

/**
 * <p>
 * Business delegate for MenuService.
 * </p>
 * <p>
 * Date: 20-mar-2006
 * </p>
 * 
 * @author guybrush
 */
public class MenuServiceBDlg
    implements MenuService
{

    private static MenuService service;

    private static MenuService getService()
    {
        if (service == null)
            service = MenuServiceLocatorFactory.getInstance().getMenuServiceLocator().getMenuService();
        return service;
    }

    public MenuServiceBDlg()
    {
        super();
    }

    /**
     * @see ar.com.espumito.core.menu.services.MenuService#getMenuForUser(java.security.Principal, java.lang.String)
     */
    public MenuVO getMenuForUser(Principal p, String menuId) throws FinderException
    {
        return getService().getMenuForUser(p, menuId);
    }

    public Collection getAllMenues()
        throws FinderException
    {
        return getService().getAllMenues();
    }

    /**
     * @see ar.com.espumito.core.menu.services.MenuService#getMenu(java.lang.Long)
     */
    public MenuVO getMenu(Long menuId)
        throws FinderException
    {
        return getService().getMenu(menuId);
    }

    /**
     * @see ar.com.espumito.core.menu.services.MenuService#updateMenu(ar.com.espumito.core.menu.vo.MenuVO)
     */
    public MenuVO updateMenu(MenuVO menuVO)
        throws FinderException
    {
        return getService().updateMenu(menuVO);
    }
    
}
