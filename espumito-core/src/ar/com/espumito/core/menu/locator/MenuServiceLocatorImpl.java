package ar.com.espumito.core.menu.locator;

import ar.com.espumito.core.locator.ServiceLocatorFactory;
import ar.com.espumito.core.menu.services.MenuService;


public class MenuServiceLocatorImpl
    implements MenuServiceLocator
{
    public MenuServiceLocatorImpl()
    {
        super();
    }

    public MenuService getMenuService()
    {
        return (MenuService) ServiceLocatorFactory.getInstance().getServiceLocator().getBean("menuService");
    }
}
