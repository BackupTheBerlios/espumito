package ar.com.espumito.core.web.portal;

import java.security.Principal;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.tiles.beans.MenuItem;
import org.apache.struts.tiles.beans.SimpleMenuItem;

import ar.com.espumito.core.menu.client.MenuSvcBDlg;
import ar.com.espumito.core.menu.services.MenuSvc;
import ar.com.espumito.core.menu.vo.MenuVO;
import ar.com.espumito.core.web.menu.DefaultMenu;
import ar.com.espumito.core.web.menu.DefaultMenuProvider;
import ar.com.espumito.core.web.menu.Menu;

public class SectionsMenuProvider
    extends DefaultMenuProvider
{
	private static final Logger logger = Logger.getLogger(SectionsMenuProvider.class);
	
    public SectionsMenuProvider()
    {
        super();
    }

	protected Menu createMenu(HttpServletRequest pRequest) {
		Principal user = pRequest.getUserPrincipal();
		logger.debug("Creating sections menu for principal " + user);
		MenuSvc menuSvc = new MenuSvcBDlg();
		Set menus = menuSvc.getMenusForUser(user);
		DefaultMenu sectionsMenu = new DefaultMenu("espumito.portal.sections.title");
		for (Iterator i = menus.iterator(); i.hasNext();)
		{
			MenuVO menu = (MenuVO) i.next();
			if (userHasAccess(menu, user))
			{
				MenuItem item = new SimpleMenuItem();
				item.setLink(menu.getUrl());
				item.setValue(menu.getTitle());
				sectionsMenu.addItem(item);
			}
		}
		return sectionsMenu;
	}

	private boolean userHasAccess(MenuVO menu, Principal user) {
		// TODO implementar
		return true;
	}


}
