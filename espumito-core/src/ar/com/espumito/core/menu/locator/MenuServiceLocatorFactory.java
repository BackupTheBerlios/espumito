package ar.com.espumito.core.menu.locator;

public class MenuServiceLocatorFactory
{

    private static MenuServiceLocatorFactory instance;

    public static MenuServiceLocatorFactory getInstance()
    {
        if (MenuServiceLocatorFactory.instance == null)
            MenuServiceLocatorFactory.instance = new MenuServiceLocatorFactory();
        return MenuServiceLocatorFactory.instance;
    }

    protected MenuServiceLocatorFactory()
    {
    }
    
    private MenuServiceLocator serviceLocator;
    
    public MenuServiceLocator getMenuServiceLocator()
    {
        if (this.serviceLocator == null)
            this.serviceLocator = new MenuServiceLocatorImpl();
        return this.serviceLocator;
    }
}
