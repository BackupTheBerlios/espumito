package ar.com.espumito.plugins.domain;

import java.util.HashMap;
import java.util.Map;

public class MultiSocketBean extends SocketBean {
    private Map<String, PluginBean> plugins = new HashMap<String, PluginBean>();

    public MultiSocketBean() {
	super();
    }

    public MultiSocketBean(String name, Class clazz) {
	super(name, clazz);
    }

    public MultiSocketBean(String name, String description, Class clazz) {
	super(name, description, clazz);
    }

    public Map<String, PluginBean> getPlugins() {
	return this.plugins;
    }

    public void setPlugins(Map<String, PluginBean> plugins) {
	this.plugins = plugins;
    }
    
    public PluginBean getPlugin(String name)
    {
	return this.plugins.get(name);
    }

}
