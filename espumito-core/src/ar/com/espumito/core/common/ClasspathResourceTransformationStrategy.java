package ar.com.espumito.core.common;

import ar.com.espumito.core.io.ClasspathResource;


public class ClasspathResourceTransformationStrategy
    implements ObjectTransformationStrategy
{

    public Object transfromObject(Object object)
    {
        Property property = (Property) object;
        return new ClasspathResource(property.getValue());
    }
}
