package ar.com.espumito.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A resource loaded from the Classpath; 
 *
 * @author guybrush
 * Date: 01-mar-2006
 *
 */
public class ClasspathResource implements Resource {
	/**
	 * The name of the resource.
	 */
	private String name;
	/**
	 * ClassLoader to use.
	 */
	private ClassLoader classLoader;
	
	/**
	 * Initializes the resource using Thread.currentThread().getContextClassLoader().
	 * @param name
	 */
	public ClasspathResource(String name) {
		this(name, Thread.currentThread().getContextClassLoader());
	}
	
	/**
	 * Initializes the resource with the given name and ClassLoader.
	 * @param name
	 * @param classLoader
	 */
	public ClasspathResource(String name, ClassLoader classLoader)
	{
		this.name = name;
		this.classLoader = classLoader;
	}

	/**
	 * @see ar.com.espumito.core.io.Resource#getName()
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Obtains the input stream using classLoader.
	 * @see ar.com.espumito.core.io.InputStreamProvider#getInputStream()
	 */
	public InputStream getInputStream() throws IOException {
		return this.classLoader.getResourceAsStream(this.name);
	}

	/**
	 * Not supported. Throws java.lang.UnsupportedOperationException
	 * @see ar.com.espumito.core.io.OutputStreamProvider#getOutputStream()
	 */
	public OutputStream getOutputStream() throws IOException {
		throw new UnsupportedOperationException();
	}

}
