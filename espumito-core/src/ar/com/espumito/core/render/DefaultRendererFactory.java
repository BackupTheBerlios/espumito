package ar.com.espumito.core.render;

import java.util.HashMap;
import java.util.Map;

import ar.com.espumito.core.web.tags.menu.DefaultMenuRenderer;
import ar.com.espumito.core.web.tags.menu.PageTopMenuRenderer;

/**
 * TODO: add description for DefaultRendererFactory 
 *
 * @author guybrush
 * Date: 06-mar-2006
 * @deprecated
 */
public class DefaultRendererFactory implements RendererFactory {
	private static RendererFactory instance;
	public static final String DEFAULT_MENU_RENDERER = "renderer.menu.default";
	public static final String PAGE_TOP_MENU_RENDERER = "renderer.menu.pageTop";
	
	public static synchronized RendererFactory getInstance()
	{
		if (instance == null)
			instance = new DefaultRendererFactory();
		return instance;
	}
	
	private Map renderers;
	
	protected DefaultRendererFactory()
	{
		this.renderers = new HashMap();
		addRenderer(DEFAULT_MENU_RENDERER, new DefaultMenuRenderer());
		addRenderer(PAGE_TOP_MENU_RENDERER, new PageTopMenuRenderer());
	}
	
	/**
	 * @see ar.com.espumito.core.render.RendererFactory#getRenderer(java.lang.String)
	 */
	public Renderer getRenderer(String id)
	{
		Renderer ret = (Renderer) this.renderers.get(id);
		return ret;
	}
	
	/**
	 * @see ar.com.espumito.core.render.RendererFactory#addRenderer(java.lang.String, ar.com.espumito.core.render.Renderer)
	 */
	public void addRenderer(String id, Renderer renderer)
	{
		this.renderers.put(id, renderer);
	}
}
