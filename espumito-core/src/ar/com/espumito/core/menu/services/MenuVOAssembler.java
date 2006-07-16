package ar.com.espumito.core.menu.services;

import ar.com.espumito.core.menu.domain.MenuBean;
import ar.com.espumito.core.menu.vo.MenuVO;
import ar.com.espumito.services.ValueObject;
import ar.com.espumito.services.ValueObjectAssemblerImpl;
import ar.com.espumito.services.ValueObjectMappingException;

public class MenuVOAssembler
    extends ValueObjectAssemblerImpl
{

    private MenuItemVOAssembler menuItemVOAssembler;

    public MenuVOAssembler()
    {
        super();
        this.menuItemVOAssembler = new MenuItemVOAssembler();
    }

    public MenuVOAssembler(MenuItemVOAssembler menuItemVOAssembler)
    {
        super();
        this.menuItemVOAssembler = menuItemVOAssembler;
    }

    /**
     * @see ar.com.espumito.services.ValueObjectAssemblerImpl#createValueObject(java.lang.Object)
     */
    public ValueObject createValueObject(Object bean)
        throws ValueObjectMappingException
    {
        MenuVO vo = new MenuVO();
        MenuBean menu = (MenuBean) bean;
        vo.setId(menu.getId());
        vo.setName(menu.getName());
        vo.setTitleKey(menu.getTitleKey());
        vo.addItems(this.menuItemVOAssembler.createValueObjectCollection(menu.getItems()));
        return vo;
    }
}
