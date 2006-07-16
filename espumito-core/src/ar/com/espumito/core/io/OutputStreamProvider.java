package ar.com.espumito.core.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Interface implemented by any output stream provider. (Thanks to Spring). 
 *
 * @author guybrush
 * Date: 01-mar-2006
 *
 */
public interface OutputStreamProvider {
	public OutputStream getOutputStream() throws IOException;
}
