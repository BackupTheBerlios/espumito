package ar.com.espumito.security.services;

import java.util.Collection;
import ar.com.espumito.security.domain.PermissionBean;
import ar.com.espumito.security.domain.SecurityObjectBean;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.services.VOAssembler;


public class SecurityObjectFullVOAssembler
    extends VOAssembler<SecurityObjectFullVO, SecurityObjectBean>
{
    private NewRoleVOAssembler roleVOAssembler = new NewRoleVOAssembler();
    private PermissionVOAssembler permissionVOAssembler = new PermissionVOAssembler();

    @Override
    public SecurityObjectFullVO assemble(SecurityObjectBean bean)
    {
        SecurityObjectFullVO vo = new SecurityObjectFullVO();
        vo.setDescription(bean.getDescription());
        vo.setId(bean.getId());
        vo.setName(bean.getName());
        vo.setPermissionPolicyId(bean.getPermissionPolicy().getId());
        for (PermissionBean permission : (Collection<PermissionBean>) bean.getPermissions())
        {
            RoleVO roleVO = this.roleVOAssembler.assemble(permission.getRole());
            PermissionVO permissionVO = this.permissionVOAssembler.assemble(permission);
            vo.addPermission(roleVO, permissionVO);
        }
        return vo;
    }
}
