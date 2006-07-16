package ar.com.espumito.plaf.domain;

import ar.com.espumito.core.render.Renderer;

/**
 * <p>
 * Look And Feel. Stores configuration for view components, such as renderers,
 * CSS and the like.
 * </p>
 * 
 * @author guybrush Date: 01-mar-2006
 * 
 */
public interface LookAndFeel {
	/**
	 * @return The ID
	 */
	public String getId();

	/**
	 * @return Short name for display.
	 */
	public String getName();

	/**
	 * @return Detailed description.
	 */
	public String getDescription();

	/**
	 * Initialices the LAF.
	 */
	public void init();
	/**
	 * @param id
	 * @return
	 */
	public Renderer getRenderer(String id);
}
