package ar.com.espumito.core.locator;

public class ServiceLocatorFactory
{

    private static ServiceLocatorFactory instance;

    public static ServiceLocatorFactory getInstance()
    {
        if (instance == null)
            instance = new ServiceLocatorFactory();
        return instance;
    }

    private ServiceLocator serviceLocator;

    protected ServiceLocatorFactory()
    {
        super();
    }

    private ServiceLocator createServiceLocator()
    {
        // TODO: crear el service locator de alguna configuracion.
        return new SpringServiceLocatorImpl();
    }

    public ServiceLocator getServiceLocator()
    {
        if (this.serviceLocator == null)
            this.serviceLocator = createServiceLocator();
        return this.serviceLocator;
    }
}
