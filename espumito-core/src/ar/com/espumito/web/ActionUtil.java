/*
 * Created on 21-may-2005
 */
package ar.com.espumito.web;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ActionUtil {
   
    /**
     * Updates ActionForward object with URL parameters.
     * 
     * @param actionMapping
     *            action mapping object
     * @param forwardName
     *            mapping name
     * @param urlParams
     *            array of "key=value" strings which should be added to
     *            actionForward path as HTTP GET parameters
     * @return modified ActionForward object with updated GET parameters
     */
    public static ActionForward goForward(ActionMapping actionMapping,
            String forwardName, HttpGetParameter[] urlParams) {
        /*
         * Find ActionForward object, defined in struts-config.xml
         */
        ActionForward actionForward = actionMapping.findForward(forwardName);
        if (actionForward == null)
            return null;

        /*
         * Do not use URL modification on forward, ActionForm fields should be
         * used instead.
         */
        if (!actionForward.getRedirect())
            return actionForward;

        /*
         * Build URL parameters necessary on redirect because HTTPRequest object
         * will be destroyed, ActionForm fields can be reset as well if form
         * scope is "request".
         */
        String actionPath = actionForward.getPath();
        if (actionPath != null) {
            if (urlParams != null)
                for (int i = 0; i < urlParams.length; i++) {
                    actionPath += i == 0 ? "?" : "&";
                    actionPath += urlParams[i].toString();
                }
        }

        /*
         * Create new ActionForward object. Stuts does not allow to modify
         * ActionForward objects, statically defined in struts-config.xml
         */
        ActionForward actionRedirect = new ActionForward(actionForward
                .getName(), actionPath, true /* REDIRECT */
        );

        return actionRedirect;
    }

    /**
     * @param actionMapping
     * @param forwardName
     * @param parameter
     * @return
     */
    public static ActionForward goForward(ActionMapping actionMapping,
            String forwardName, HttpGetParameter parameter) {
        return goForward(actionMapping, forwardName,
                new HttpGetParameter[] { parameter });
    }

    /**
     * @param actionMapping
     * @param forwardName
     * @return
     */
    public static ActionForward goForward(ActionMapping actionMapping,
            String forwardName) {
        return goForward(actionMapping, forwardName, (HttpGetParameter[]) null);
    }

}
