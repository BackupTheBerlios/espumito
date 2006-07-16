package ar.com.espumito.security.services;

import ar.com.espumito.security.domain.SecurityObjectBean;
import ar.com.espumito.services.VOAssembler;

public class SecurityObjectVOAssembler
    extends VOAssembler<SecurityObjectVO, SecurityObjectBean>
{

    private PermissionPolicyVOAssembler permissionPolicyVOAssembler = new PermissionPolicyVOAssembler();

    @Override
    public SecurityObjectVO assemble(SecurityObjectBean bean)
    {
        SecurityObjectVO vo = new SecurityObjectVO();
        vo.setDescription(bean.getDescription());
        vo.setId(bean.getId());
        vo.setName(bean.getName());
        if (bean.getFather() != null)
        {
            vo.setFather(assemble(bean.getFather()));
        }
        if (bean.getPermissionPolicy() != null)
        {
            vo.setPermissionPolicy(this.permissionPolicyVOAssembler.assemble(bean.getPermissionPolicy()));
        }
        // TODO: falta version
        return vo;
    }
}
