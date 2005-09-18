/*
 * Created on 11-may-2005
 */
package ar.com.espumito.support.securityfilter;

import java.rmi.RemoteException;
import java.security.Principal;

import javax.ejb.FinderException;

import org.securityfilter.realm.SecurityRealmInterface;

import ar.com.espumito.security.InvalidCredentialsException;
import ar.com.espumito.security.InvalidUsernameException;
import ar.com.espumito.security.client.SecuritySvcBDlg;
import ar.com.espumito.security.services.SecuritySvc;
import ar.com.espumito.security.vo.UserVO;
import ar.com.espumito.util.StringUtil;

public class EspumitoRealmAdapter implements SecurityRealmInterface {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(EspumitoRealmAdapter.class);

    private SecuritySvc security;

    public EspumitoRealmAdapter() {
        super();

    }

    public Principal authenticate(String username, String password) {
        logger.debug("Authenticating user " + username);
        try {
            getSecurityBDlg().authenticate(username, new Object[] { password });
            return new ar.com.espumito.security.Principal(username);
        } catch (InvalidUsernameException e) {
            return null;
        } catch (InvalidCredentialsException e) {
            return null;
        } catch (Exception e) {
            logger.error("An error ocurred while authenticating the user "
                    + username, e);
            return null;
        }
    }

    public boolean isUserInRole(Principal principal, String rolename) {
        if (principal == null || StringUtil.isBlank(rolename))
            return false;
        logger.debug("Checking principal " + principal.getName() + " for role "
                + rolename);
        try {
            UserVO user = getSecurityBDlg().getUser(principal.getName());
            boolean isInRole = user.hasRole(rolename);
            logger.debug("Principal " + principal.getName()
                    + (isInRole ? " has role " : " hasn´t role ")
                    + rolename);
            return isInRole;
        } catch (FinderException e) {
            logger.error(
                    "An error ocurred while checking the roles of the user "
                            + principal.getName(), e);
            return false;
        }
    }

    /**
     * Lazy loading para {@link #security}
     * 
     * @return
     */
    protected synchronized SecuritySvc getSecurityBDlg() {
        if (security == null)
            security = new SecuritySvcBDlg();
        return security;
    }
}
