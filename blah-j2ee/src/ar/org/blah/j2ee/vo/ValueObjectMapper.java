/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.vo;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author guybrush
 * @deprecated
 */
public interface ValueObjectMapper extends ValueObjectAssembler {
    public Object createInstance(Serializable id, ValueObject valueObject)
            throws ValueObjectMappingException;

    public ValueObject createValueObject(Object bean)
            throws ValueObjectMappingException;

    public Object updateBean(ValueObject valueObject, Object bean)
            throws ValueObjectMappingException;

    public Collection createValueObjectCollection(Collection beans)
            throws ValueObjectMappingException;

}
