package ar.com.espumito.core.menu.services;

import ar.com.espumito.core.menu.domain.MenuItemBean;
import ar.com.espumito.core.menu.vo.MenuItemVO;
import ar.com.espumito.services.ValueObject;
import ar.com.espumito.services.ValueObjectAssemblerImpl;
import ar.com.espumito.services.ValueObjectMappingException;


public class MenuItemVOAssembler
    extends ValueObjectAssemblerImpl
{

    public MenuItemVOAssembler()
    {
        super();
    }

    /**
     * @see ar.com.espumito.services.ValueObjectAssemblerImpl#createValueObject(java.lang.Object)
     */
    public ValueObject createValueObject(Object bean)
        throws ValueObjectMappingException
    {
        MenuItemBean item = (MenuItemBean) bean;
        MenuItemVO vo = new MenuItemVO();
        vo.setId(item.getId());
        vo.setModule(item.getModuleId());
        vo.setTitle(item.getTitleKey());
        vo.setUrl(item.getUrl());
        return vo;
    }
}
