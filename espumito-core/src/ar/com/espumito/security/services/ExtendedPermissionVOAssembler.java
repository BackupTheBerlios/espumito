package ar.com.espumito.security.services;

import ar.com.espumito.security.domain.ExtendedPermissionBean;
import ar.com.espumito.services.VOAssembler;


public class ExtendedPermissionVOAssembler
    extends VOAssembler<ExtendedPermissionVO, ExtendedPermissionBean>
{

    @Override
    public ExtendedPermissionVO assemble(ExtendedPermissionBean bean)
    {
        ExtendedPermissionVO vo = new ExtendedPermissionVO();
        vo.setDescription(bean.getDescription());
        vo.setId(bean.getId());
        vo.setName(bean.getName());
        return vo;
    }

}
