package ar.com.espumito.core.web.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import ar.com.espumito.core.web.WebSymbols;
import ar.com.espumito.support.spring.SpringSupport;

/**
 * <p>
 * Accion genérica para obtener un menu y dejarlo en el request.
 * </p>
 * <p>
 * Fecha de creacion: Sep 15, 2005
 * </p>
 * 
 * @author FIT - Martin Straus
 */
public class MenuAction extends Action {
	private static Logger logger = Logger.getLogger(MenuAction.class);

	public static final String FWD_NO_MENU_PROVIDER = "fwd.menu.noProvider";

	public MenuAction() {
		super();
	}

	public ActionForward execute(ActionMapping pMapping, ActionForm pForm,
			HttpServletRequest pRequest, HttpServletResponse pResponse)
			throws Exception {
		MenuProvider provider = getMenuProvider(pMapping);
		if (provider != null) {
			Menu menu = provider.getMenu(pRequest);
			pRequest.setAttribute(provider.getMenuKey(), menu);
			return pMapping.findForward(WebSymbols.FWD_SUCCESS);
		} else
			return pMapping.findForward(FWD_NO_MENU_PROVIDER);

	}

	/**
	 * Obtiene el provider del menú instanciando la clase.
	 * 
	 * @param mapping
	 * @return
	 */
	private MenuProvider getMenuProvider(ActionMapping mapping) {
		String providerName = mapping.getParameter();

		try {
			return (MenuProvider) SpringSupport.getBeanFactory(
					SpringSupport.CLIENT_RESOURCE).getBean(providerName);
		} catch (NoSuchBeanDefinitionException e) {
			logger.error("An error ocurred while obtaining menu provider "
					+ providerName + " from Spring.", e);
			logger.error("We'll now assume " + providerName
					+ " is a classname and instantiate through reflection.");
		}

		try {
			Class clazz = Class.forName(providerName);
			return (MenuProvider) clazz.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
