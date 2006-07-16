package ar.com.espumito.plugins.domain;

public class SimpleSocketBean extends SocketBean {
    private PluginBean plugin;

    public SimpleSocketBean() {
	super();
    }

    public SimpleSocketBean(String name, Class clazz) {
	super(name, clazz);
    }

    public SimpleSocketBean(String name, String description, Class clazz) {
	super(name, description, clazz);
    }

    public PluginBean getPlugin() {
	return this.plugin;
    }

    public void setPlugin(PluginBean plugin) {
	this.plugin = plugin;
    }

}
