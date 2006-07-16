package ar.com.espumito.core.menu.services;

import java.security.Principal;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.FinderException;
import ar.com.espumito.core.menu.domain.MenuBean;
import ar.com.espumito.core.menu.domain.MenuHome;
import ar.com.espumito.core.menu.domain.MenuItemBean;
import ar.com.espumito.core.menu.vo.MenuItemVO;
import ar.com.espumito.core.menu.vo.MenuVO;
import ar.com.espumito.security.domain.PermissionBean;
import ar.com.espumito.security.domain.UserBean;
import ar.com.espumito.security.domain.UserHome;
import ar.com.espumito.services.ValueObjectMappingException;

/**
 * <p>
 * Implementatin of menu services.
 * </p>
 * <p>
 * Date: 20-mar-2006
 * </p>
 * 
 * @author guybrush
 */
public class MenuServiceImpl
    implements MenuService
{

    private MenuHome                menuHome;
    private MenuItemVOAssembler     menuItemVOAssembler;
    private MenuVOAssembler         menuVOAssembler;
    private UserHome                userHome;
    private UserMenuItemVOAssembler userMenuItemVOAssembler;
    private UserMenuVOAssembler     userMenuVOAssembler;

    public MenuServiceImpl(MenuHome menuHome, UserHome userHome, UserMenuVOAssembler userMenuVOAssembler,
            UserMenuItemVOAssembler userMenuItemVOAssembler, MenuVOAssembler menuVOAssembler,
            MenuItemVOAssembler menuItemVOAssembler)
    {
        super();
        this.menuHome = menuHome;
        this.userHome = userHome;
        this.userMenuVOAssembler = userMenuVOAssembler;
        this.userMenuItemVOAssembler = userMenuItemVOAssembler;
        this.menuVOAssembler = menuVOAssembler;
        this.menuItemVOAssembler = menuItemVOAssembler;
    }

    /**
     * @see ar.com.espumito.core.menu.services.MenuService#getAllMenues()
     */
    public Collection getAllMenues()
        throws FinderException
    {
        Collection menues = this.menuHome.findAll();
        try
        {
            Collection ret = this.menuVOAssembler.createValueObjectCollection(menues);
            return ret;
        } catch (ValueObjectMappingException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    /**
     * @param menuId
     * @return
     * @throws FinderException
     */
    public MenuVO getMenu(Long menuId)
        throws FinderException
    {
        MenuBean menu = this.menuHome.findByPrimaryKey(menuId);
        try
        {
            return (MenuVO) this.menuVOAssembler.createValueObject(menu);
        } catch (ValueObjectMappingException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    /**
     * @see ar.com.espumito.core.menu.services.MenuService#getMenuForUser(java.security.Principal, java.lang.String)
     */
    public MenuVO getMenuForUser(Principal p, String menuName)
        throws FinderException
    {
        MenuBean menu = this.menuHome.findByName(menuName);
        UserBean user = null;
        if (p != null)
        {
            try
            {
                user = this.userHome.findUserByUsername(p.getName());
            } catch (FinderException e)
            {
                // TODO: agregar mensaje de consola.
            }
        }
        PermissionBean permission = menu.getPermissionForUser(user);
        MenuVO menuVO = null;
        if (permission.isRead())
        {
            menuVO = this.userMenuVOAssembler.createValueObject(menu, permission);
            for (Iterator items = menu.getItems().iterator(); items.hasNext();)
            {
                MenuItemBean item = (MenuItemBean) items.next();
                PermissionBean itemPermission = item.getPermissionForUser(user);
                if (itemPermission.isRead())
                {
                    MenuItemVO itemVO = this.userMenuItemVOAssembler.createValueObject(item, itemPermission);
                    menuVO.addItem(itemVO);
                }
            }
        }
        return menuVO;
    }

    /**
     * @see ar.com.espumito.core.menu.services.MenuService#updateMenu(ar.com.espumito.core.menu.vo.MenuVO)
     */
    public MenuVO updateMenu(MenuVO menuVO)
        throws FinderException
    {
        MenuBean menu = this.menuHome.findByPrimaryKey(menuVO.getId());
        menu.setName(menuVO.getName());
        menu.setTitleKey(menu.getTitleKey());
        try
        {
            return (MenuVO) this.menuVOAssembler.createValueObject(menu);
        } catch (ValueObjectMappingException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }
}
