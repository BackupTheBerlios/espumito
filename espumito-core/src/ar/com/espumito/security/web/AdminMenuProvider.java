package ar.com.espumito.security.web;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.tiles.beans.SimpleMenuItem;

import ar.com.espumito.core.web.menu.DefaultMenu;
import ar.com.espumito.core.web.menu.DefaultMenuProvider;
import ar.com.espumito.core.web.menu.Menu;

public class AdminMenuProvider extends DefaultMenuProvider {
	private static final Logger logger = Logger.getLogger(AdminMenuProvider.class);

	protected Menu createMenu(HttpServletRequest pRequest) {
		Principal user = pRequest.getUserPrincipal();
		logger.debug("Creating admin menu for principal " + user);
		DefaultMenu menu = new DefaultMenu("espumito.admin.menu.title");
		SimpleMenuItem item = new SimpleMenuItem();
		item.setLink("/core/admin/usersAdmin.do");
		item.setValue("espumito.admin.usersAdmin.title");
		menu.addItem(item);
		item = new SimpleMenuItem();
		item.setLink("/core/admin/rolesAdmin.do");
		item.setValue("espumito.admin.rolesAdmin.title");
		menu.addItem(item);
		item = new SimpleMenuItem();
		item.setLink("/core/admin/roleGroupsAdmin.do");
		item.setValue("espumito.admin.roleGroupsAdmin.title");
		menu.addItem(item);
		return menu;
	}

}
