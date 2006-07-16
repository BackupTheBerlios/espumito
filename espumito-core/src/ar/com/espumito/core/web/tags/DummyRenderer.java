package ar.com.espumito.core.web.tags;

import java.io.IOException;
import java.io.Writer;

import ar.com.espumito.core.render.RenderException;
import ar.com.espumito.core.render.Renderer;
import ar.com.espumito.core.render.RendererConfiguration;

/**
 * Dummy renderer thats writes {@link #MESSAGE} to the page. 
 *
 * @author guybrush
 * Date: 06-mar-2006
 *
 */
public class DummyRenderer implements Renderer {
	private static final String MESSAGE = "[no renderer configured for this tag]";
	public DummyRenderer() {
		super();
	}

	/**
	 * @see ar.com.espumito.core.render.Renderer#render(java.lang.Object, java.io.Writer, ar.com.espumito.core.render.RendererConfiguration)
	 */
	public void render(Object model, Writer writer, RendererConfiguration config)
			throws RenderException {
		try {
			writer.write(MESSAGE);
		} catch (IOException e) {
			throw new RenderException(e);
		}
	}

}
