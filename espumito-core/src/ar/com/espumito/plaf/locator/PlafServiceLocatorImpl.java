package ar.com.espumito.plaf.locator;

import ar.com.espumito.core.locator.ServiceLocatorFactory;
import ar.com.espumito.plaf.domain.LookAndFeelProvider;
import ar.com.espumito.plaf.services.LookAndFeelService;

public class PlafServiceLocatorImpl
    implements PlafServiceLocator
{

    public PlafServiceLocatorImpl()
    {
        super();
    }

    public LookAndFeelProvider getLookAndFeelProvider()
    {
        return (LookAndFeelProvider) ServiceLocatorFactory.getInstance().getServiceLocator().getBean(
                "lookAndFeelProvider");
    }

    public LookAndFeelService getLookAndFeelService()
    {
        return (LookAndFeelService) ServiceLocatorFactory.getInstance().getServiceLocator().getBean(
                "lookAndFeelService");
    }
}
