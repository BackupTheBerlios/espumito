package ar.com.espumito.plaf.client;

import ar.com.espumito.plaf.domain.LookAndFeel;
import ar.com.espumito.plaf.domain.LookAndFeelProvider;
import ar.com.espumito.plaf.locator.PlafServiceLocatorFactory;

/**
 * Business delegate de LookAndFeelProvider
 * 
 * @author guybrush Date: 05-mar-2006
 */
public class LookAndFeelProviderBDlg
    implements LookAndFeelProvider
{

    /**
     * El servicio configurado en Spring.
     */
    private static LookAndFeelProvider lafProvider;

    /**
     * @return the lafProvider
     */
    private static LookAndFeelProvider getLafProvider()
    {
        if (lafProvider == null)
        {
            lafProvider = PlafServiceLocatorFactory.getInstance().getPlafServiceLocator().getLookAndFeelProvider();
        }
        return lafProvider;
    }

    /**
     * 
     */
    public LookAndFeelProviderBDlg()
    {
        super();
    }

    /**
     * @see ar.com.espumito.plaf.domain.LookAndFeelProvider#findAll()
     */
    public LookAndFeel[] findAll()
    {
        return getLafProvider().findAll();
    }

    /**
     * @see ar.com.espumito.plaf.domain.LookAndFeelProvider#findByPrimaryKey(java.lang.String)
     */
    public LookAndFeel findByPrimaryKey(String id)
    {
        return getLafProvider().findByPrimaryKey(id);
    }
}
