package ar.com.espumito.blogs.web;

import java.util.Iterator;
import java.util.Properties;

import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RequestUtils {
	public static ActionForward getRedirectAfterPostForward(
			ActionMapping pMapping, String pForwardName, Properties pParameters) {
		ActionForward actionForward = pMapping.findForward(pForwardName);
		if (actionForward == null)
			return null;

		if (!actionForward.getRedirect())
			return actionForward;

		StringBuffer actionPath = new StringBuffer(actionForward.getPath());
		if (actionPath != null && pParameters != null) {
			boolean first = actionPath.indexOf("?") == -1;
			for (Iterator i = pParameters.keySet().iterator(); i.hasNext();) {
				String key = (String) i.next();
				String value = pParameters.getProperty(key);
				actionPath.append(first ? "?" : "&");
				actionPath.append(key);
				actionPath.append("=");
				actionPath.append(value);
				first = false;
			}
		}

		ActionForward actionRedirect = new ActionForward(actionForward
				.getName(), actionPath.toString(), true);

		return actionRedirect;
	}

	/**
	 * @param pMapping
	 * @param pForwardName
	 * @return
	 */
	public static ActionForward getRedirectAfterPostForward(
			ActionMapping pMapping, String pForwardName) {
		return getRedirectAfterPostForward(pMapping, pForwardName, null);
	}

	public static ActionForward getRedirectAfterPostForward(
			ActionMapping pMapping, String pForwardName, String paramName,
			String paramValue) {
		Properties p = new Properties();
		p.setProperty(paramName, paramValue);
		return getRedirectAfterPostForward(pMapping, pForwardName, p);
	}

}
