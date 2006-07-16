package ar.com.espumito.core.menu.services;

import ar.com.espumito.core.menu.domain.MenuBean;
import ar.com.espumito.core.menu.vo.MenuVO;
import ar.com.espumito.security.domain.PermissionBean;
import ar.com.espumito.security.services.PermissionVO;

public class UserMenuVOAssembler
{

    public UserMenuVOAssembler()
    {
        super();
    }

    /**
     * @see ar.com.espumito.services.ValueObjectAssemblerImpl#createValueObject(java.lang.Object)
     */
    public MenuVO createValueObject(MenuBean menu, PermissionBean permission)
    {
        MenuVO menuVO = new MenuVO();
        menuVO.setId(menu.getId());
        menuVO.setName(menu.getName());
        menuVO.setTitleKey(menu.getTitleKey());
        menuVO.setPermissions(new PermissionVO(permission.isDelete(), permission.isExecute(), permission.isRead(),
                permission.isWrite()));
        return menuVO;
    }
}
