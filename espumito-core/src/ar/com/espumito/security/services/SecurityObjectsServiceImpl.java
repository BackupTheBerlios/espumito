package ar.com.espumito.security.services;

import java.security.Principal;
import java.util.List;
import java.util.Vector;
import javax.ejb.FinderException;
import ar.com.espumito.core.menu.services.MenuItemVOAssembler;
import ar.com.espumito.security.domain.ExtendedPermissionBean;
import ar.com.espumito.security.domain.ExtendedPermissionHome;
import ar.com.espumito.security.domain.OperationBean;
import ar.com.espumito.security.domain.PermissionBean;
import ar.com.espumito.security.domain.PermissionPolicyBean;
import ar.com.espumito.security.domain.PermissionPolicyHome;
import ar.com.espumito.security.domain.SecurityObjectBean;
import ar.com.espumito.security.domain.SecurityObjectHome;
import ar.com.espumito.security.domain.UserBean;
import ar.com.espumito.security.domain.UserHome;
import ar.com.espumito.services.ValueObjectMappingException;

public class SecurityObjectsServiceImpl
    implements SecurityObjectsService
{

    private UserHome                      userHome;
    private SecurityObjectHome            securityObjectHome;
    private OperationVOAssembler          operationVOAssembler          = new OperationVOAssembler(
                                                                                new MenuItemVOAssembler());
    private SecurityObjectVOAssembler     securityObjectVOAssembler     = new SecurityObjectVOAssembler();
    private SecurityObjectFullVOAssembler securityObjectFullVOAssembler = new SecurityObjectFullVOAssembler();
    private ExtendedPermissionHome        extendedPermissionHome;
    private ExtendedPermissionVOAssembler extendedPermissionVOAssembler = new ExtendedPermissionVOAssembler();
    private PermissionPolicyHome          permissionPolicyHome;
    private PermissionPolicyVOAssembler   permissionPolicyVOAssembler   = new PermissionPolicyVOAssembler();

    public SecurityObjectsServiceImpl(UserHome userHome, SecurityObjectHome securityObjectHome,
            ExtendedPermissionHome extendedPermissionHome, PermissionPolicyHome permissionPolicyHome)
    {
        super();
        this.userHome = userHome;
        this.securityObjectHome = securityObjectHome;
        this.extendedPermissionHome = extendedPermissionHome;
        this.permissionPolicyHome = permissionPolicyHome;
    }

    public List<ExtendedPermissionVO> getExtendedPermissions()
        throws FinderException
    {
        List<ExtendedPermissionBean> extendedPermissions = this.extendedPermissionHome.findAll();
        List<ExtendedPermissionVO> ret = this.extendedPermissionVOAssembler.assemble(extendedPermissions);
        return ret;
    }

    public List<OperationVO> getOperationsForUser(Principal principal, Long securityObjectId)
        throws FinderException
    {
        UserBean user = this.userHome.findUserByUsername(principal.getName());
        SecurityObjectBean securityObject = this.securityObjectHome.findByPrimaryKey(securityObjectId);
        PermissionBean permission = securityObject.getPermissionForUser(user);
        try
        {
            List<OperationVO> ret = new Vector<OperationVO>();
            if (permission.isDelete() && permission.getDeleteOperation() != null)
                ret.add((OperationVO) this.operationVOAssembler.createValueObject(permission.getDeleteOperation()));
            if (permission.isExecute() && permission.getExecuteOperation() != null)
                ret.add((OperationVO) this.operationVOAssembler.createValueObject(permission.getExecuteOperation()));
            if (permission.isRead() && permission.getReadOperation() != null)
                ret.add((OperationVO) this.operationVOAssembler.createValueObject(permission.getReadOperation()));
            if (permission.isWrite() && permission.getWriteOperation() != null)
                ret.add((OperationVO) this.operationVOAssembler.createValueObject(permission.getWriteOperation()));
            for (ExtendedPermissionBean extendedPermission : permission.getExtendedPermissions())
                for (OperationBean operation : extendedPermission.getOperations())
                    ret.add((OperationVO) this.operationVOAssembler.createValueObject(operation));
            return ret;
        } catch (ValueObjectMappingException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    public List<PermissionPolicyVO> getPermissionPolicies()
        throws FinderException
    {
        List<PermissionPolicyBean> permissionPolicies = this.permissionPolicyHome.findAll();
        List<PermissionPolicyVO> ret = this.permissionPolicyVOAssembler.assemble(permissionPolicies);
        return ret;
    }

    public SecurityObjectFullVO getSecurityObject(Long id)
        throws FinderException
    {
        SecurityObjectBean securityObject = this.securityObjectHome.findByPrimaryKey(id);
        SecurityObjectFullVO ret = this.securityObjectFullVOAssembler.assemble(securityObject);
        return ret;
    }

    public List<SecurityObjectVO> getSecurityObjects()
        throws FinderException
    {
        List<SecurityObjectBean> securityObjects = this.securityObjectHome.findAll();
        List<SecurityObjectVO> valueObjects = this.securityObjectVOAssembler.assemble(securityObjects);
        return valueObjects;
    }

    public UserPermissionsVO getUserPermissions(long userId, long securityObjectId)
    {
        return null;
    }
}
