package ar.com.espumito.security.services;

import ar.com.espumito.core.menu.services.MenuItemVOAssembler;
import ar.com.espumito.core.menu.vo.MenuItemVO;
import ar.com.espumito.security.domain.OperationBean;
import ar.com.espumito.services.ValueObject;
import ar.com.espumito.services.ValueObjectAssemblerImpl;
import ar.com.espumito.services.ValueObjectMappingException;


public class OperationVOAssembler
    extends ValueObjectAssemblerImpl
{
    private MenuItemVOAssembler menuItemVOAssemler = new MenuItemVOAssembler();
    
    public OperationVOAssembler(MenuItemVOAssembler menuItemVOAssemler)
    {
        super();
        this.menuItemVOAssemler = menuItemVOAssemler;
    }

    /**
     * @see ar.com.espumito.services.ValueObjectAssemblerImpl#createValueObject(java.lang.Object)
     */
    public ValueObject createValueObject(Object bean)
        throws ValueObjectMappingException
    {
        OperationBean operation = (OperationBean) bean;
        OperationVO vo = new OperationVO();
        vo.setId(operation.getId());
        vo.setName(operation.getName());
        vo.setDescription(operation.getDescription());
        if (operation.getMenuItem() != null)
            vo.setMenuItem((MenuItemVO) this.menuItemVOAssemler.createValueObject(operation.getMenuItem()));
        return vo;
    }
}
