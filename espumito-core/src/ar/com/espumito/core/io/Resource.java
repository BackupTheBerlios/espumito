package ar.com.espumito.core.io;

/**
 * An interface to a resource. (Thanks to Spring). 
 *
 * @author guybrush
 * Date: 01-mar-2006
 *
 */
public interface Resource extends InputStreamProvider, OutputStreamProvider {
	
	public String getName();
	
}
