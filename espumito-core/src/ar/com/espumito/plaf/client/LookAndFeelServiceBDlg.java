package ar.com.espumito.plaf.client;

import ar.com.espumito.plaf.domain.LookAndFeel;
import ar.com.espumito.plaf.locator.PlafServiceLocatorFactory;
import ar.com.espumito.plaf.services.LookAndFeelService;

/**
 * Business delegate para LookAndFeelService
 * 
 * @author guybrush Date: 05-mar-2006
 */
public class LookAndFeelServiceBDlg
    implements LookAndFeelService
{
    /**
     * El servicio a utilizar.
     */
    private static LookAndFeelService service;

    /**
     * @return the service
     */
    private static LookAndFeelService getService()
    {
        if (service == null)
        {
            service = PlafServiceLocatorFactory.getInstance().getPlafServiceLocator().getLookAndFeelService();
        }
        return service;
    }

    /**
     * 
     */
    public LookAndFeelServiceBDlg()
    {
        super();
    }

    /**
     * @see ar.com.espumito.plaf.services.LookAndFeelService#getDefaultLookAndFeel()
     */
    public LookAndFeel getDefaultLookAndFeel()
    {
        return getService().getDefaultLookAndFeel();
    }

    /**
     * @see ar.com.espumito.plaf.services.LookAndFeelService#getLookAndFeelForUser(java.lang.String)
     */
    public LookAndFeel getLookAndFeelForUser(String user)
    {
        return getService().getLookAndFeelForUser(user);
    }
}
