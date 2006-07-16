/*
 * Created on 29-ago-2005
 */
package ar.com.espumito.security.services;

import java.io.Serializable;
import java.util.Iterator;

import ar.com.espumito.security.domain.RoleBean;
import ar.com.espumito.security.domain.RoleGroupBean;
import ar.com.espumito.security.domain.RoleGroupBean;
import ar.com.espumito.security.vo.RoleGroupVO;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.services.ValueObject;
import ar.com.espumito.services.ValueObjectAssembler;
import ar.com.espumito.services.ValueObjectAssemblerImpl;
import ar.com.espumito.services.ValueObjectMappingException;

public class RoleGroupVOAssembler extends ValueObjectAssemblerImpl {
    private ValueObjectAssembler roleVOAssembler;

    public RoleGroupVOAssembler() {
        super();
    }

    public ValueObjectAssembler getRoleVOAssembler() {
        if (this.roleVOAssembler == null)
            this.roleVOAssembler = new RoleVOAssembler();
        return this.roleVOAssembler;
    }

    public void setRoleVOAssembler(ValueObjectAssembler roleVOAssembler) {
        this.roleVOAssembler = roleVOAssembler;
    }

    /**
     * @see ar.com.espumito.services.ValueObjectAssembler#createInstance(java.io.Serializable, ar.com.espumito.services.ValueObject)
     */
    public Object createInstance(Serializable id, ValueObject valueObject)
            throws ValueObjectMappingException {
        RoleGroupVO vo = (RoleGroupVO) valueObject;
        RoleGroupBean roleGroup = new RoleGroupBean(vo.getName());
        return roleGroup;
    }

    /**
     * @see ar.com.espumito.services.ValueObjectAssembler#createValueObject(java.lang.Object)
     */
    public ValueObject createValueObject(Object bean)
            throws ValueObjectMappingException {
        RoleGroupBean roleGroup = (RoleGroupBean) bean;
        RoleGroupVO vo = new RoleGroupVO(roleGroup.getId(), roleGroup.getName());
        for (Iterator i = roleGroup.getRoles().iterator(); i.hasNext();) {
            RoleBean role = (RoleBean) i.next();
            vo.addRole((RoleVO) this.roleVOAssembler.createValueObject(role));
        }
        return vo;
    }

}
