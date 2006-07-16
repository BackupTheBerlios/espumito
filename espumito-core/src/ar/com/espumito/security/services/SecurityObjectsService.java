package ar.com.espumito.security.services;

import java.security.Principal;
import java.util.List;
import javax.ejb.FinderException;

public interface SecurityObjectsService
{

    public List<ExtendedPermissionVO> getExtendedPermissions()
        throws FinderException;

    public List<OperationVO> getOperationsForUser(Principal principal, Long securityObjectId)
        throws FinderException;

    public List<PermissionPolicyVO> getPermissionPolicies()
        throws FinderException;

    public SecurityObjectFullVO getSecurityObject(Long id)
        throws FinderException;

    public List<SecurityObjectVO> getSecurityObjects()
        throws FinderException;

    public UserPermissionsVO getUserPermissions(long userId, long securityObjectId);
}
