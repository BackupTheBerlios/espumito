package ar.com.espumito.plaf.util;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.log4j.Logger;
import org.apache.struts.taglib.TagUtils;

import ar.com.espumito.plaf.domain.LookAndFeel;

/**
 * Look and feel utilities. 
 *
 * @author guybrush
 * Date: 06-mar-2006
 *
 */
public class LookAndFeelUtil {
	private static final Logger logger = Logger
			.getLogger(LookAndFeelUtil.class);

	/**
	 * The name of the Session attribute for the user's look and feel.
	 */
	public static final String LOOK_AND_FEEL_SESSION_ATTRIBUTE = "ar.com.espumito.core.plaf.userLookAndFeel";

	/**
	 * The name of the Session attribute for the application's default look and
	 * feel.
	 */
	public static final String LOOK_AND_FEEL_DEFAULT_ATTRIBUTE = "ar.com.espumito.core.plaf.defaultLookAndFeel";

	/**
	 * Returns a look and feel. The look and feel is first search for in page
	 * scope, then request scope, then session scope, then application scope. If
	 * it's not found, the application's default look and feel is retreived.
	 * 
	 * @param pageContext
	 *            The JSP page context.
	 * @param id
	 *            The ID of the look ant feel to find.
	 * @return
	 * @throws JspException
	 */
	public static LookAndFeel getLookAndFeel(PageContext pageContext)
			throws JspException {
		LookAndFeel lookAndFeel = null;
		lookAndFeel = (LookAndFeel) TagUtils.getInstance().lookup(pageContext,
				LookAndFeelUtil.LOOK_AND_FEEL_SESSION_ATTRIBUTE, null);
		if (lookAndFeel == null) {
			logger
					.debug("Look and feel not found in any scope. Obtaining default look and feel.");
			lookAndFeel = (LookAndFeel) TagUtils.getInstance().lookup(
					pageContext,
					LookAndFeelUtil.LOOK_AND_FEEL_DEFAULT_ATTRIBUTE, null);
		}
		return lookAndFeel;
	}
}
