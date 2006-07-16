package ar.com.espumito.plaf.test;

import ar.com.espumito.plaf.domain.LookAndFeel;
import ar.com.espumito.plaf.domain.LookAndFeelProvider;
import ar.com.espumito.plaf.services.LookAndFeelService;

/**
 * Implementacion de test de LookAndFeelProvider. 
 *
 * @author guybrush
 * Date: 05-mar-2006
 *
 */
public class MockLookAndFeelServiceImpl implements LookAndFeelService {
	/**
	 * El proveedor a utilizar.
	 */
	private LookAndFeelProvider provider;
	
	/**
	 * @param provider
	 */
	public MockLookAndFeelServiceImpl(LookAndFeelProvider provider) {
		super();
		this.provider = provider;
	}

	/**
	 * Entrega siempre el look and feel DARK.
	 * @see ar.com.espumito.plaf.services.LookAndFeelService#getLookAndFeelForUser(java.lang.String)
	 */
	public LookAndFeel getLookAndFeelForUser(String user) {
		return this.provider.findByPrimaryKey("DARK");
	}

	public LookAndFeel getDefaultLookAndFeel() {
		return this.provider.findByPrimaryKey("DARK");
	}

}
