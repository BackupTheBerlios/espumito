/*
 * Created on 07-mar-2005
 */
package ar.com.espumito.security.services;

import java.io.Serializable;

import ar.com.espumito.security.domain.RoleBean;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.services.ValueObject;
import ar.com.espumito.services.ValueObjectAssemblerImpl;
import ar.com.espumito.services.ValueObjectMappingException;

public class RoleVOAssembler extends ValueObjectAssemblerImpl {

    public RoleVOAssembler() {
        super();

    }

    /**
     * @see ar.com.espumito.services.ValueObjectAssembler#createInstance(java.io.Serializable,
     *      ar.com.espumito.services.ValueObject)
     */
    public Object createInstance(Serializable id, ValueObject valueObject)
            throws ValueObjectMappingException {
        RoleVO vo = (RoleVO) valueObject;
        return new RoleBean(vo.getName(), vo.getDescription());
    }

    /**
     * @see ar.com.espumito.services.ValueObjectAssembler#createValueObject(java.lang.Object)
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
     * @see ar.com.espumito.services.ValueObjectAssembler#updateBean(ar.com.espumito.services.ValueObject,
     *      java.lang.Object)
     */
    public Object updateBean(ValueObject valueObject, Object bean)
            throws ValueObjectMappingException {
        RoleVO vo = (RoleVO) valueObject;
        RoleBean role = (RoleBean) bean;
        role.setName(vo.getName());
        role.setDescription(vo.getDescription());
        return bean;
    }

}
