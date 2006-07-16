package ar.com.espumito.security.locator;

public class SecurityServiceLocatorFactory
{

    private static SecurityServiceLocatorFactory instance;

    public static SecurityServiceLocatorFactory getInstance()
    {
        if (SecurityServiceLocatorFactory.instance == null)
            SecurityServiceLocatorFactory.instance = new SecurityServiceLocatorFactory();
        return SecurityServiceLocatorFactory.instance;
    }

    private SecurityServiceLocator serviceLocator;

    protected SecurityServiceLocatorFactory()
    {
    }

    public SecurityServiceLocator getSecurityServiceLocator()
    {
        if (this.serviceLocator == null)
            // TODO: instanciar a partir de configuracion.
            this.serviceLocator = new SecurityServiceLocatorImpl();
        return this.serviceLocator;
    }
}
