package ar.com.espumito.security.services;

import ar.com.espumito.security.vo.UserVO;
import ar.com.espumito.services.ValueObject;

public class UserPermissionsVO
    extends ValueObject
{

    private PermissionVO     permissions;
    private SecurityObjectVO securityObject;
    private UserVO           user;

    public UserPermissionsVO()
    {
        super();
    }

    public UserPermissionsVO(UserVO user, SecurityObjectVO securityObject, PermissionVO permissions)
    {
        super();
        this.user = user;
        this.securityObject = securityObject;
        this.permissions = permissions;
    }

    /**
     * @return Returns the permissions.
     */
    public PermissionVO getPermissions()
    {
        return this.permissions;
    }

    /**
     * @return Returns the securityObject.
     */
    public SecurityObjectVO getSecurityObject()
    {
        return this.securityObject;
    }

    /**
     * @return Returns the user.
     */
    public UserVO getUser()
    {
        return this.user;
    }

    /**
     * @see ar.com.espumito.security.services.PermissionVO#isDelete()
     */
    public boolean isDelete()
    {
        return this.permissions.isDelete();
    }

    /**
     * @see ar.com.espumito.security.services.PermissionVO#isExecute()
     */
    public boolean isExecute()
    {
        return this.permissions.isExecute();
    }

    /**
     * @see ar.com.espumito.security.services.PermissionVO#isRead()
     */
    public boolean isRead()
    {
        return this.permissions.isRead();
    }

    /**
     * @see ar.com.espumito.security.services.PermissionVO#isWrite()
     */
    public boolean isWrite()
    {
        return this.permissions.isWrite();
    }

    /**
     * @param permissions
     *            The permissions to set.
     */
    public void setPermissions(PermissionVO permissions)
    {
        this.permissions = permissions;
    }

    /**
     * @param securityObject
     *            The securityObject to set.
     */
    public void setSecurityObject(SecurityObjectVO securityObject)
    {
        this.securityObject = securityObject;
    }

    /**
     * @param user
     *            The user to set.
     */
    public void setUser(UserVO user)
    {
        this.user = user;
    }
}
