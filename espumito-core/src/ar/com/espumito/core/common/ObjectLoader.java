package ar.com.espumito.core.common;

import java.io.IOException;
import java.util.List;

import ar.com.espumito.core.io.Resource;

/**
 * Interface of classes that load objects from resources. 
 *
 * @author guybrush
 * Date: 02-mar-2006
 *
 */
public interface ObjectLoader {

	/**
	 * Uses strategy to transform the content of resource into objects.
	 * 
	 * @param resource
	 * @param strategy
	 * @return
	 */
	public List loadObjectsFromResource(Resource resource,
			ObjectTransformationStrategy strategy) throws IOException;

}