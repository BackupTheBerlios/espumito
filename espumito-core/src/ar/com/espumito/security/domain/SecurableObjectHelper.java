package ar.com.espumito.security.domain;

public class SecurableObjectHelper
    implements SecurableObject
{

    private SecurableObject object;

    public SecurableObjectHelper(SecurableObject object)
    {
        super();
        this.object = object;
    }

    public SecurityObjectBean getSecurityObject()
    {
        return this.object.getSecurityObject();
    }

    public PermissionBean getPermissionForUser(UserBean user)
    {
        SecurityObjectBean so = this.object.getSecurityObject();
        return so != null ? so.getPermissionForUser(user) : PermissionBean.DENIED_PERMISSION;
    }

    public PermissionBean getPermissionForRole(RoleBean role)
    {
        SecurityObjectBean so = this.object.getSecurityObject();
        return so != null ? so.getPermissionForRole(role) : PermissionBean.DENIED_PERMISSION;
    }
}
