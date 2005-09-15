/*
 * Created on 17-jul-2005
 */
package ar.org.blah.j2ee.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public abstract class ValueObjectAssemblerImpl implements ValueObjectAssembler {

    public ValueObjectAssemblerImpl() {
        super();

    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#createValueObjectCollection(java.util.Collection)
     */
    public Collection createValueObjectCollection(Collection beans)
            throws ValueObjectMappingException {
        return createValueObjectCollection(beans, null);
    }

    public Collection createValueObjectCollection(Collection beans,
            Collection valueObjects) throws ValueObjectMappingException {
        int size = 0;
        if (beans != null)
            size = beans.size();
        if (valueObjects == null)
            valueObjects = new Vector(size);
        if (beans != null) {
            for (Iterator i = beans.iterator(); i.hasNext();)
                valueObjects.add(createValueObject(i.next()));
        }
        return valueObjects;
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#createInstance(java.io.Serializable, ar.org.blah.j2ee.vo.ValueObject)
     */
    public Object createInstance(Serializable id, ValueObject valueObject)
            throws ValueObjectMappingException {
        throw new ValueObjectMappingException("Operation not supported");
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#createValueObject(java.lang.Object)
     */
    public ValueObject createValueObject(Object bean)
            throws ValueObjectMappingException {
        throw new ValueObjectMappingException("Operation not supported");
    }

    /**
     * @see ar.org.blah.j2ee.vo.ValueObjectAssembler#updateBean(ar.org.blah.j2ee.vo.ValueObject, java.lang.Object)
     */
    public Object updateBean(ValueObject valueObject, Object bean)
            throws ValueObjectMappingException {
        throw new ValueObjectMappingException("Operation not supported");
    }

}
