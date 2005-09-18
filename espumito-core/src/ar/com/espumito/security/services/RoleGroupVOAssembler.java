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
import ar.org.blah.j2ee.vo.ValueObject;
import ar.org.blah.j2ee.vo.ValueObjectAssembler;
import ar.org.blah.j2ee.vo.ValueObjectAssemblerImpl;
import ar.org.blah.j2ee.vo.ValueObjectMappingException;

public class RoleGroupVOAssembler extends ValueObjectAssemblerImpl {
    private ValueObjectAssembler roleVOAssembler;

    public RoleGroupVOAssembler() {
        super();
    }

    public ValueObjectAssembler getRoleVOAssembler() {
        if (roleVOAssembler == null)
            roleVOAssembler = new RoleVOAssembler();
        return roleVOAssembler;
    }

    public void setRoleVOAssembler(ValueObjectAssembler roleVOAssembler) {
        this.roleVOAssembler = roleVOAssembler;
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#createInstance(java.io.Serializable, ar.org.blah.j2ee.vo.ValueObject)
     */
    public Object createInstance(Serializable id, ValueObject valueObject)
            throws ValueObjectMappingException {
        RoleGroupVO vo = (RoleGroupVO) valueObject;
        RoleGroupBean roleGroup = new RoleGroupBean(vo.getName());
        return roleGroup;
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#createValueObject(java.lang.Object)
     */
    public ValueObject createValueObject(Object bean)
            throws ValueObjectMappingException {
        RoleGroupBean roleGroup = (RoleGroupBean) bean;
        RoleGroupVO vo = new RoleGroupVO(roleGroup.getId(), roleGroup.getName());
        for (Iterator i = roleGroup.getRoles().iterator(); i.hasNext();) {
            RoleBean role = (RoleBean) i.next();
            vo.addRole((RoleVO) roleVOAssembler.createValueObject(role));
        }
        return vo;
    }

}
