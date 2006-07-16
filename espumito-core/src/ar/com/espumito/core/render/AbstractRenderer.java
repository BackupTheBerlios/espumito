package ar.com.espumito.core.render;

import java.io.Writer;

import javax.servlet.jsp.PageContext;


/**
 * @author guybrush
 */
public abstract class AbstractRenderer implements Cloneable, Renderer {
	public static final String CTX_HTML_ATTRIBUTES = "html";

	public static final String CTX_MODEL = "model";
	
	public static final String CTX_RENDERER_CONFIGURATION = "configuration";

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	/**
	 * @see ar.com.espumito.core.render.Renderer#render(java.lang.Object, java.io.Writer, ar.com.espumito.core.render.DefaultRendererConfiguration)
	 */
	public void render(Object model, Writer writer, RendererConfiguration config)
			throws RenderException {
		throw new RenderException("Rendering not implemented");
	}

}
