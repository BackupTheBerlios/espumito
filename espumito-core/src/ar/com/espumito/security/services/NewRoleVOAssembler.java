package ar.com.espumito.security.services;

import ar.com.espumito.security.domain.RoleBean;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.services.VOAssembler;


public class NewRoleVOAssembler
    extends VOAssembler<RoleVO, RoleBean>
{

    @Override
    public RoleVO assemble(RoleBean bean)
    {
        RoleVO vo = new RoleVO();
        vo.setDescription(bean.getDescription());
        vo.setId(bean.getId());
        vo.setName(bean.getName());
        return vo;
    }
}
