package ar.com.espumito.support.spring;

import javax.ejb.FinderException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import ar.com.espumito.plugins.domain.MultiSocketBean;
import ar.com.espumito.plugins.domain.PluginBean;
import ar.com.espumito.plugins.domain.SimpleSocketBean;
import ar.com.espumito.plugins.domain.SocketBean;
import ar.com.espumito.plugins.domain.SocketHome;

/**
 * Factory bean para instanciar plugines.
 * 
 * @author guybrush
 * 
 */
public class PluginFactoryBean extends AbstractFactoryBean {
    private static final Logger logger = Logger
	    .getLogger(PluginFactoryBean.class);

    private SocketHome socketHome;

    private String socketName;

    private String pluginName;

    public PluginFactoryBean(SocketHome socketHome, String socketName) {
	super();
	this.socketHome = socketHome;
	this.socketName = socketName;
    }

    public PluginFactoryBean(SocketHome socketHome, String socketName,
	    String pluginName) {
	super();
	this.socketHome = socketHome;
	this.socketName = socketName;
	this.pluginName = pluginName;
    }

    @Override
    protected Object createInstance() throws Exception {
	SocketBean socket = (SimpleSocketBean) this.socketHome
		.findSocketByName(this.socketName);
	if (socket instanceof SimpleSocketBean)
	    return getFromSimpleSocket((SimpleSocketBean) socket);
	else
	    return (getFromMultiSocket((MultiSocketBean) socket,
		    this.pluginName));
    }

    private Object getFromMultiSocket(MultiSocketBean socket, String pluginName)
	    throws InstantiationException, IllegalAccessException {
	PluginBean plugin = socket.getPlugin(pluginName);
	return (plugin != null) ? plugin.newInstance() : null;
    }

    private Object getFromSimpleSocket(SimpleSocketBean socket)
	    throws InstantiationException, IllegalAccessException {
	PluginBean plugin = socket.getPlugin();
	return (plugin != null) ? plugin.newInstance() : null;
    }

    public Class getObjectType() {
	try {
	    SimpleSocketBean socket = (SimpleSocketBean) this.socketHome
		    .findSocketByName(this.socketName);
	    return socket.getClass();
	} catch (FinderException e) {
	    logger.error("Error obteniendo socket " + this.socketName, e);
	    return null;
	}
    }

    public String getPluginName() {
	return this.pluginName;
    }

    public SocketHome getSocketHome() {
	return this.socketHome;
    }

    public String getSocketName() {
	return this.socketName;
    }

    public void setPluginName(String pluginName) {
	this.pluginName = pluginName;
    }

    public void setSocketHome(SocketHome socketHome) {
	this.socketHome = socketHome;
    }

    public void setSocketName(String socketName) {
	this.socketName = socketName;
    }

}
