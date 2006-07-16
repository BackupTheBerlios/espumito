/*
 * Created on 12-jul-2005
 */
package ar.com.espumito.services;

import java.io.Serializable;
import java.util.Collection;

public interface ValueObjectAssembler {
    public Object createInstance(Serializable id, ValueObject valueObject)
            throws ValueObjectMappingException;

    public ValueObject createValueObject(Object bean)
            throws ValueObjectMappingException;

    public Object updateBean(ValueObject valueObject, Object bean)
            throws ValueObjectMappingException;

    public Collection createValueObjectCollection(Collection beans)
            throws ValueObjectMappingException;

    public Collection createValueObjectCollection(Collection beans,
            Collection valueObjects) throws ValueObjectMappingException;
}
