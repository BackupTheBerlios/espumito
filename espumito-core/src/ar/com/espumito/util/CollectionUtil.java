/*
 * Created on 11-mar-2005
 */
package ar.com.espumito.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

public class CollectionUtil {
    private static Logger logger = Logger.getLogger(CollectionUtil.class);
    /**
     * @param source
     * @param size
     * @return
     */
    public static Collection restrict(Collection source, int size) {
        Collection ret = new Vector();
        int j = 0;
        for (Iterator i = source.iterator(); i.hasNext() && j < size; j++)
            ret.add(i.next());
        return ret;
    }

    public static Collection plancharColeccion(Object object, String property) {
        return plancharColeccion(object, property, null, false);
    }

    public static Collection plancharColeccion(Object object, String property,
            Collection collection, boolean includeRoot) {
        Collection col = (collection != null) ? collection : new Vector();
        try {
            if (includeRoot)
            {
                logger.debug("Agregando nodo de tipo " + object.getClass().getName());
                col.add(object);
            }
            Method method = getAccessor(object, property);
            Collection inner = (Collection) method.invoke(object, null);
            if (inner != null && inner.size() > 0)
                for (Iterator i = inner.iterator(); i.hasNext();) {
                    col = plancharColeccion(i.next(), property, col, true);
                }

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return col;
    }

    private static Method getAccessor(Object object, String property)
            throws IntrospectionException {
        if (object == null)
            return null;
        BeanInfo info = Introspector.getBeanInfo(object.getClass());
        PropertyDescriptor[] descriptors = info.getPropertyDescriptors();
        PropertyDescriptor descriptor = descriptors[0];
        int i = 1;
        while (i < descriptors.length && !descriptor.getName().equals(property))
            descriptor = descriptors[i++];
        if (i < descriptors.length)
            return (descriptor.getReadMethod());
        else
            return null;
    }
}
