package ar.com.espumito.core.common;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import ar.com.espumito.core.io.Resource;

public abstract class PropertiesObjectLoader {

	public Object loadObjectFromResource(Resource resource) throws IOException {
		Properties properties = new Properties();
		properties.load(resource.getInputStream());
		for (Iterator i = properties.keySet().iterator(); i.hasNext();)
		{
			String key = (String) i.next();
			String value = properties.getProperty(key);
			Property property = new Property(key, value);
			setProperty(property);
		}
		return getObject();
	}

	protected abstract Object getObject();

	protected abstract void setProperty(Property property);	

}
