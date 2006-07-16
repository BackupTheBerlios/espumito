package ar.com.espumito.plaf.persistence;

import ar.com.espumito.core.common.ObjectTransformationStrategy;
import ar.com.espumito.core.common.Property;
import ar.com.espumito.core.io.ClasspathResource;


public class LookAndFeelResourceTransformationStrategy
    implements ObjectTransformationStrategy
{

    public Object transfromObject(Object object)
    {
        Property property = (Property) object;
        return new LookAndFeelResource(property.getKey(), new ClasspathResource(property.getValue()));
    }
}
