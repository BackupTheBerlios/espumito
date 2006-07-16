package ar.com.espumito.core.render;

import java.io.Writer;

public interface Renderer {

	/**
	 * @param model
	 * @param writer
	 * @param config
	 * @throws RenderException
	 */
	public void render(Object model, Writer writer, RendererConfiguration config)
			throws RenderException;

}