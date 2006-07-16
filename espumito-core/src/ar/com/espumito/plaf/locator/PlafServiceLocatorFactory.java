package ar.com.espumito.plaf.locator;

public class PlafServiceLocatorFactory
{

    private static PlafServiceLocatorFactory instance;

    public static PlafServiceLocatorFactory getInstance()
    {
        if (PlafServiceLocatorFactory.instance == null)
            PlafServiceLocatorFactory.instance = new PlafServiceLocatorFactory();
        return PlafServiceLocatorFactory.instance;
    }

    private PlafServiceLocator serviceLocator;

    protected PlafServiceLocatorFactory()
    {
    }

    public PlafServiceLocator getPlafServiceLocator()
    {
        if (this.serviceLocator == null)
            this.serviceLocator = new PlafServiceLocatorImpl();
        return this.serviceLocator;
    }
}
