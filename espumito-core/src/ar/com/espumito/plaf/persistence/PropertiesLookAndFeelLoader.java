package ar.com.espumito.plaf.persistence;

import ar.com.espumito.core.common.PropertiesObjectLoader;
import ar.com.espumito.core.common.Property;
import ar.com.espumito.core.render.Renderer;
import ar.com.espumito.plaf.domain.SimpleLookAndFeel;
import ar.com.espumito.util.StringUtil;

public class PropertiesLookAndFeelLoader extends PropertiesObjectLoader {
	private static final String PROPERTY_ID = "id";

	private static final String PROPERTY_NAME = "name";

	private static final String PROPERTY_DESCRIPTION = "description";

	private static final String PROPERTY_RENDERER_PREFIX = "renderer.";

	private SimpleLookAndFeel laf = new SimpleLookAndFeel();

	public PropertiesLookAndFeelLoader() {
		super();
	}

	/**
	 * @see ar.com.espumito.core.common.PropertiesObjectLoader#getObject()
	 */
	protected Object getObject() {
		return this.laf;
	}

	/**
	 * @see ar.com.espumito.core.common.PropertiesObjectLoader#setProperty(ar.com.espumito.core.common.Property)
	 */
	protected void setProperty(Property property) {
		if (property.getKey().equals(PROPERTY_ID))
			this.laf.setId(property.getValue());
		else if (property.getKey().equals(PROPERTY_NAME))
			this.laf.setName(property.getValue());
		else if (property.getKey().equals(PROPERTY_DESCRIPTION))
			this.laf.setDescription(property.getValue());
		else if (property.getKey().startsWith(PROPERTY_RENDERER_PREFIX)) {
			try {
				String id = getRendererId(property.getKey());
				Renderer renderer = createRenderer(property.getValue());
				if (StringUtil.isNotBlank(id) && renderer != null)
					this.laf.addRenderer(id, renderer);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param key
	 * @return
	 */
	private String getRendererId(String key) {
		String id = key.replaceFirst(PROPERTY_RENDERER_PREFIX, "");
		return id;
	}

	/**
	 * @param value
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private Renderer createRenderer(String value)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		Class clazz = Thread.currentThread().getContextClassLoader().loadClass(
				value);
		if (Renderer.class.isAssignableFrom(clazz)) {
			Renderer renderer = (Renderer) clazz.newInstance();
			return renderer;
		} else
			return null;

	}

}
