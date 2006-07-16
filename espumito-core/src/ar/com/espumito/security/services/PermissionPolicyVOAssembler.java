package ar.com.espumito.security.services;

import ar.com.espumito.security.domain.PermissionPolicyBean;
import ar.com.espumito.services.VOAssembler;


public class PermissionPolicyVOAssembler
    extends VOAssembler<PermissionPolicyVO, PermissionPolicyBean>
{

    @Override
    public PermissionPolicyVO assemble(PermissionPolicyBean bean)
    {
        PermissionPolicyVO vo = new PermissionPolicyVO();
        vo.setDescription(bean.getDescription());
        vo.setId(bean.getId());
        vo.setName(bean.getName());
        return vo;
    }

}
