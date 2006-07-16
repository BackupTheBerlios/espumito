package ar.com.espumito.security.services;

import java.util.Properties;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import org.apache.log4j.Logger;

import ar.com.espumito.plugins.domain.SimpleSocketBean;
import ar.com.espumito.plugins.domain.SocketHome;
import ar.com.espumito.security.domain.RoleGroupBean;
import ar.com.espumito.security.domain.RoleGroupHome;
import ar.com.espumito.security.domain.UserBean;
import ar.com.espumito.security.domain.UserHome;
import ar.com.espumito.security.plugins.RegistrationPlugin;

public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger logger = Logger
	    .getLogger(RegistrationServiceImpl.class);

    private SocketHome socketHome;

    private UserHome userHome;

    private RoleGroupHome roleGroupHome;

    public RegistrationServiceImpl(UserHome userHome,
	    RoleGroupHome roleGroupHome, SocketHome socketHome) {
	super();
	this.userHome = userHome;
	this.roleGroupHome = roleGroupHome;
	this.socketHome = socketHome;
    }

    public void activateUser(String username, Properties parameters)
	    throws FinderException, AccountActivationException {
	UserBean user = this.userHome.findUserByUsername(username);
	try {
	    RegistrationPlugin plugin = getRegistrationPlugin();
	    if (plugin != null)
		plugin.userActivated(user, parameters);
	    else
		logger.warn("No hay ningun plugin de registracion configurado.");
	} catch (InstantiationException e) {
	    throw new AccountActivationException(e);
	} catch (IllegalAccessException e) {
	    throw new AccountActivationException(e);
	}

    }

    private RegistrationPlugin getRegistrationPlugin()
	    throws InstantiationException, IllegalAccessException {
	try {
	    SimpleSocketBean socket = (SimpleSocketBean) this.socketHome
		    .findSocketByName(RegistrationPlugin.SOCKET_NAME);
	    RegistrationPlugin plugin;
	    plugin = (RegistrationPlugin) socket.getPlugin().newInstance();
	    return plugin;
	} catch (FinderException e) {
	    logger.warn("No hay ningun socket de registracion configurado.");
	    return null;
	}
    }

    public void registerUser(String username, String password, String name,
	    String lastName, String email, String displayName)
	    throws CreateException, RegistrationException {
	UserBean user = this.userHome.create(username, email, displayName,
		false);
	try {
	    RoleGroupBean defaultRoleGroup = this.roleGroupHome
		    .findDefaultRoleGroup();
	    user.addAllRoles(defaultRoleGroup.getRoles());
	} catch (FinderException e) {
	    new ar.com.espumito.core.ejb.FinderException(e);
	}
	try {
	    RegistrationPlugin plugin = getRegistrationPlugin();
	    if (plugin != null)
		plugin.userRegistered(user);
	    else
		logger
			.warn("No hay ningun plugin de registracion configurado.");
	} catch (InstantiationException e) {
	    throw new RegistrationException(e);
	} catch (IllegalAccessException e) {
	    throw new RegistrationException(e);
	}

    }

}
