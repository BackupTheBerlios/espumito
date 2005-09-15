/*
 * Created on 03-mar-2005
 */
package ar.org.blah.j2ee.test;

import java.io.Serializable;
import java.util.Collection;

import ar.org.blah.j2ee.vo.ValueObject;
import ar.org.blah.j2ee.vo.ValueObjectMapperImpl;
import ar.org.blah.j2ee.vo.ValueObjectMappingException;

public class VOMapper extends ValueObjectMapperImpl {

    public VOMapper() {
        super();
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectMapper#createInstance(java.io.Serializable, ar.org.blah.j2ee.vo.ValueObject)
     */
    public Object createInstance(Serializable id, ValueObject valueObject)
            throws ValueObjectMappingException {
        if (valueObject == null)
            throw new ValueObjectMappingException();
        DomainVO vo = (DomainVO) valueObject;
        DomainClass bean = new DomainClass();
        bean.setName(vo.getName());
        return bean;
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectMapper#createValueObject(java.lang.Object)
     */
    public ValueObject createValueObject(Object bean)
            throws ValueObjectMappingException {
        if (bean == null)
            throw new ValueObjectMappingException();
        DomainVO vo = new DomainVO();
        DomainClass theBean = (DomainClass) bean;
        vo.setId(theBean.getId());
        vo.setName(theBean.getName());
        vo.setVersion(theBean.getVersion());
        return vo;
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectMapper#updateBean(ar.org.blah.j2ee.vo.ValueObject, java.lang.Object)
     */
    public Object updateBean(ValueObject valueObject, Object bean)
            throws ValueObjectMappingException {
        DomainVO vo = (DomainVO) valueObject;
        DomainClass domainBean = (DomainClass) bean;
        domainBean.setName(vo.getName());
        domainBean.setVersion(vo.getVersion());
        return domainBean;
    }
}
