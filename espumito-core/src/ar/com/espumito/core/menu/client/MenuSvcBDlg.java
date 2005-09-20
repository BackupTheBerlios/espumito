package ar.com.espumito.core.menu.client;

import java.security.Principal;
import java.util.Set;

import org.springframework.core.io.ClassPathResource;

import ar.com.espumito.core.menu.services.MenuSvc;
import ar.com.espumito.core.menu.services.MockMenuSvc;
import ar.com.espumito.security.services.SecuritySvc;
import ar.com.espumito.support.spring.ServiceId;
import ar.com.espumito.support.spring.SpringSupport;

public class MenuSvcBDlg implements MenuSvc {
	private MenuSvc service;

	public MenuSvcBDlg() {
		super();
		service = getService();
	}

	private MenuSvc getService() {
		return (MenuSvc) SpringSupport.getBeanFactory(
				new ClassPathResource(
						"META-INF/espumito-core-client-spring.xml")).getBean(
				ServiceId.MENU_SVC.getId());

	}

	public Set getMenusForUser(Principal p) {
		return service.getMenusForUser(p);
	}

}
