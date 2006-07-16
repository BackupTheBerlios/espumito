package ar.com.espumito.core.menu.services;

import java.security.Principal;
import java.util.Collection;
import javax.ejb.FinderException;
import ar.com.espumito.core.menu.vo.MenuVO;

public interface MenuService
{

    /**
     * @return
     * @throws FinderException
     */
    public Collection getAllMenues()
        throws FinderException;

    /**
     * @param menuId
     * @return
     * @throws FinderException
     */
    public MenuVO getMenu(Long menuId)
        throws FinderException;

    /**
     * @param p
     * @param menuId
     * @return
     * @throws FinderException
     *             TODO
     */
    public MenuVO getMenuForUser(Principal user, String menuName)
        throws FinderException;

    /**
     * @param menuVO
     * @return
     * @throws FinderException
     */
    public MenuVO updateMenu(MenuVO menuVO)
        throws FinderException;
}
