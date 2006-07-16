package ar.com.espumito.security.services;

import java.util.Collection;
import ar.com.espumito.security.domain.PermissionBean;
import ar.com.espumito.services.VOAssembler;

public class PermissionVOAssembler
    extends VOAssembler<PermissionVO, PermissionBean>
{
    private ExtendedPermissionVOAssembler extendedPermissionVOAssembler = new ExtendedPermissionVOAssembler();
    
    @Override
    public PermissionVO assemble(PermissionBean bean)
    {
        PermissionVO vo = new PermissionVO();
        vo.setDelete(bean.isDelete());
        vo.setExecute(bean.isExecute());
        vo.setRead(bean.isRead());
        vo.setWrite(bean.isWrite());
        vo.setId(bean.getId());
        Collection<ExtendedPermissionVO> extendedPermissions = this.extendedPermissionVOAssembler.assemble(bean.getExtendedPermissions());
        vo.addAllExtendedPermissions(extendedPermissions);
        return vo;
    }
}
