package ar.com.espumito.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Interface implemented by any input stream provider. (Thanks to Spring). 
 *
 * @author guybrush
 * Date: 01-mar-2006
 *
 */
public interface InputStreamProvider {
	public InputStream getInputStream() throws IOException;
}
