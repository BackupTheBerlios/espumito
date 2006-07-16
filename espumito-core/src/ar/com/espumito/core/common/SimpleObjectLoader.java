package ar.com.espumito.core.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import ar.com.espumito.core.io.Resource;

/**
 * <p>
 * Loads a list of objects from a resource, using a transformation strategy to
 * create the objects from the contents of the resource.
 * </p>
 * <p>
 * TODO: add properties description
 * </p>
 * 
 * 
 * @author guybrush Date: 02-mar-2006
 * 
 */
public class SimpleObjectLoader implements ObjectLoader {
	public static final String COMMENT_PREFIX = "#";

	/**
	 * @see ar.com.espumito.core.common.ObjectLoader#loadObjectsFromResource(ar.com.espumito.core.io.Resource,
	 *      ar.com.espumito.core.common.ObjectTransformationStrategy)
	 */
	public List loadObjectsFromResource(Resource resource,
			ObjectTransformationStrategy strategy) throws IOException {
		List objects = new Vector();
		Properties properties = new Properties();
		properties.load(resource.getInputStream());
		for (Iterator i = properties.keySet().iterator(); i.hasNext();) {
			String key = (String) i.next();
			String value = properties.getProperty(key);
			Property property = new Property(key, value);
			Object obj = strategy.transfromObject(property);
			objects.add(obj);
		}
		return objects;
	}

}
