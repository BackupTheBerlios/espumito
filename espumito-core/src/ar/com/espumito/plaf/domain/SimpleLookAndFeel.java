package ar.com.espumito.plaf.domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ar.com.espumito.core.render.Renderer;
import ar.com.espumito.plaf.services.LookAndFeelPluginProvider;

/**
 * Abstract L&F. Concrete L&Fs should extend this class for easy implementation.
 * 
 * @author guybrush
 * Date: 27-feb-2006
 *
 */
public class SimpleLookAndFeel implements LookAndFeel {
	/**
	 * Description
	 */
	private String description;
	/**
	 * ID
	 */
	private String id;
	/**
	 * Name
	 */
	private String name;
	/**
	 * Renderers. The key is a String representing the renderer ID.
	 */
	protected Map renderers = new HashMap();
	
	/**
	 * 
	 */
	public SimpleLookAndFeel() {
		super();
	}

	/**
	 * 
	 */
	public void addRenderer(String id, Renderer renderer) {
		this.renderers.put(id, renderer);
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return Returns the id.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @see ar.com.espumito.core.render.RendererFactory#getRenderer(java.lang.String)
	 */
	public Renderer getRenderer(String id) {
		Renderer renderer = (Renderer) this.renderers.get(id);
		return renderer;
	}

	public void init() {
	
	}

	/**
	 * @param plugin
	 */
	protected void loadPlugin(LookAndFeelPlugin plugin) {
		Map renderers = plugin.getRenderers();
		loadRenderers(renderers);
	}

	/**
	 * Loads LAF plugins provided by pluginProvider.
	 * @param pluginProvider The plugin provider to use.
	 */
	protected void loadPlugins(LookAndFeelPluginProvider pluginProvider)
	{
		LookAndFeelPlugin[] plugins = pluginProvider.getLookAndFeelPlugins(getId());
		for (int i = 0; i < plugins.length; i++)
			loadPlugin(plugins[i]);
	}
	
	/**
	 * Loads renderers.
	 * @param renderers The renderers to load.
	 */
	protected void loadRenderers(Map renderers)
	{
		for (Iterator i = renderers.keySet().iterator(); i.hasNext();)
		{
			String key = (String) i.next();
			Renderer renderer = (Renderer) renderers.get(key);
			this.renderers.put(key, renderer);
		}
	}

	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * @param id The id to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

}
