package ar.com.espumito.core.menu.services;

import ar.com.espumito.core.menu.domain.MenuItemBean;
import ar.com.espumito.core.menu.vo.MenuItemVO;
import ar.com.espumito.security.domain.PermissionBean;
import ar.com.espumito.security.services.PermissionVO;

public class UserMenuItemVOAssembler
{

    public UserMenuItemVOAssembler()
    {
        super();
    }

    public MenuItemVO createValueObject(MenuItemBean item, PermissionBean permission)
    {
        MenuItemVO itemVO = new MenuItemVO();
        itemVO.setId(item.getId());
        itemVO.setModule(item.getModuleId());
        itemVO.setTitle(item.getTitleKey());
        itemVO.setUrl(item.getUrl());
        itemVO.setPermissions(new PermissionVO(permission.isDelete(), permission.isExecute(), permission
                .isRead(), permission.isWrite()));
        return itemVO;
    }
}
