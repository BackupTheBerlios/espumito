package ar.com.espumito.security.client;

import java.security.Principal;
import java.util.List;
import javax.ejb.FinderException;
import ar.com.espumito.security.locator.SecurityServiceLocatorFactory;
import ar.com.espumito.security.services.ExtendedPermissionVO;
import ar.com.espumito.security.services.OperationVO;
import ar.com.espumito.security.services.PermissionPolicyVO;
import ar.com.espumito.security.services.SecurityObjectFullVO;
import ar.com.espumito.security.services.SecurityObjectVO;
import ar.com.espumito.security.services.SecurityObjectsService;
import ar.com.espumito.security.services.UserPermissionsVO;

public class SecurityObjectsServiceBDlg
    implements SecurityObjectsService
{

    private static SecurityObjectsService service;

    /**
     * @return Returns the service.
     */
    public static SecurityObjectsService getService()
    {
        if (service == null)
            service = SecurityServiceLocatorFactory.getInstance().getSecurityServiceLocator()
                    .getSecurityObjectsService();
        return service;
    }

    public SecurityObjectsServiceBDlg()
    {
        super();
    }

    public List<ExtendedPermissionVO> getExtendedPermissions()
        throws FinderException
    {
        return getService().getExtendedPermissions();
    }

    public List<OperationVO> getOperationsForUser(Principal principal, Long securityObjectId)
        throws FinderException
    {
        return getService().getOperationsForUser(principal, securityObjectId);
    }

    public List<PermissionPolicyVO> getPermissionPolicies()
        throws FinderException
    {
        return getService().getPermissionPolicies();
    }

    public SecurityObjectFullVO getSecurityObject(Long id)
        throws FinderException
    {
        return getService().getSecurityObject(id);
    }

    public List<SecurityObjectVO> getSecurityObjects()
        throws FinderException
    {
        return getService().getSecurityObjects();
    }

    /**
     * @see ar.com.espumito.security.services.SecurityObjectsService#getUserPermissions(long, long)
     */
    public UserPermissionsVO getUserPermissions(long userId, long securityObjectId)
    {
        return getService().getUserPermissions(userId, securityObjectId);
    }
}
