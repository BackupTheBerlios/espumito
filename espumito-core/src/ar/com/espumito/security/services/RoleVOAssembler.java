/*
 * Created on 07-mar-2005
 */
package ar.com.espumito.security.services;

import java.io.Serializable;

import ar.com.espumito.security.domain.RoleBean;
import ar.com.espumito.security.vo.RoleVO;
import ar.org.blah.j2ee.vo.ValueObject;
import ar.org.blah.j2ee.vo.ValueObjectAssemblerImpl;
import ar.org.blah.j2ee.vo.ValueObjectMappingException;

public class RoleVOAssembler extends ValueObjectAssemblerImpl {

    public RoleVOAssembler() {
        super();

    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#createInstance(java.io.Serializable,
     *      ar.org.blah.j2ee.vo.ValueObject)
     */
    public Object createInstance(Serializable id, ValueObject valueObject)
            throws ValueObjectMappingException {
        RoleVO vo = (RoleVO) valueObject;
        return new RoleBean(vo.getName(), vo.getDescription());
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#createValueObject(java.lang.Object)
     */
    public ValueObject createValueObject(Object bean)
            throws ValueObjectMappingException {
        RoleBean role = (RoleBean) bean;
        RoleVO vo = new RoleVO();
        vo.setId(role.getId());
        vo.setName(role.getName());
        vo.setDescription(role.getDescription());
        return vo;
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#updateBean(ar.org.blah.j2ee.vo.ValueObject,
     *      java.lang.Object)
     */
    public Object updateBean(ValueObject valueObject, Object bean)
            throws ValueObjectMappingException {
        RoleVO vo = (RoleVO) valueObject;
        RoleBean role = (RoleBean) bean;
        role.setName(vo.getName());
        role.setDescription(vo.getDescription());
        role.setVersion(vo.getVersion());
        return bean;
    }

}
