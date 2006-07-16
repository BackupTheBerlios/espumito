package ar.com.espumito.plaf.services;

import ar.com.espumito.plaf.domain.LookAndFeel;

public interface LookAndFeelService {
	public LookAndFeel getLookAndFeelForUser(String user);
	public LookAndFeel getDefaultLookAndFeel();
}
