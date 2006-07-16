package ar.com.espumito.services;

import java.util.Collection;
import java.util.List;
import java.util.Vector;


public abstract class VOAssembler<V extends ValueObject, B extends Object>
{
    public abstract V assemble(B bean);
    
    public List<V> assemble(Collection<B> beans)
    {
        return assemble(new Vector<V>(), beans);
    }
    
    public List<V> assemble(List<V> valueObjects, Collection<B> beans)
    {
        if (valueObjects == null)
            valueObjects = new Vector<V>();
        for (B bean : beans)
            if (bean != null)
                valueObjects.add(assemble(bean));
        return valueObjects;
    }
}
