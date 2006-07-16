package ar.com.espumito.plaf.web;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import ar.com.espumito.plaf.client.LookAndFeelServiceBDlg;
import ar.com.espumito.plaf.domain.LookAndFeel;
import ar.com.espumito.plaf.services.LookAndFeelService;
import ar.com.espumito.plaf.util.LookAndFeelUtil;

/**
 * Session listener to initialize look and feel settings.
 * 
 * @author guybrush Date: 05-mar-2006
 * 
 */
public class LookAndFeelSessionListener implements HttpSessionListener {
	private static Logger logger = Logger
			.getLogger(LookAndFeelSessionListener.class);

	public LookAndFeelSessionListener() {
		super();
	}

	/**
	 * Obtains the default look and feel and stores it in the session, with name
	 * {@link LookAndFeelUtil.LOOK_AND_FEEL_SESSION_ATTRIBUTE}.
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		logger.debug("Initializing look and feel.");
		HttpSession session = sessionEvent.getSession();
		LookAndFeelService service = new LookAndFeelServiceBDlg();
		LookAndFeel laf = service.getDefaultLookAndFeel();
		logger.debug("Storing look and feel " + laf.getId() + " in session.");
		session.setAttribute(LookAndFeelUtil.LOOK_AND_FEEL_SESSION_ATTRIBUTE, laf);
	}

	/**
	 * No behaviour.
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {

	}

}
