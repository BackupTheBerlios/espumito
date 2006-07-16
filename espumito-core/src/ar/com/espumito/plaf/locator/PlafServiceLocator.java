package ar.com.espumito.plaf.locator;

import ar.com.espumito.plaf.domain.LookAndFeelProvider;
import ar.com.espumito.plaf.services.LookAndFeelService;


public interface PlafServiceLocator
{
    public LookAndFeelProvider getLookAndFeelProvider();
    public LookAndFeelService getLookAndFeelService();
}
