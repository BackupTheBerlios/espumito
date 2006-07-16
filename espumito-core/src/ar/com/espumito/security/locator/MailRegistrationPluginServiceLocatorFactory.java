package ar.com.espumito.security.locator;

public class MailRegistrationPluginServiceLocatorFactory {
    private static MailRegistrationPluginServiceLocatorFactory instance;
    
    public static MailRegistrationPluginServiceLocatorFactory getInstance()
    {
	if (instance == null)
	    instance = new MailRegistrationPluginServiceLocatorFactory();
	return instance;
    }
    
    protected MailRegistrationPluginServiceLocatorFactory()
    {
	
    }
    
    private MailRegistrationPluginServiceLocator mailRegistrationPluginServiceLocator;
    
    public MailRegistrationPluginServiceLocator getMailRegistrationPluginServiceLocator()
    {
	if (this.mailRegistrationPluginServiceLocator == null)
	    this.mailRegistrationPluginServiceLocator = new MailRegistrationPluginServiceLocatorImpl();
	return this.mailRegistrationPluginServiceLocator;
    }
}
