package ar.com.espumito.security.domain;


public interface SecurableObject
{
    public SecurityObjectBean getSecurityObject();
    public PermissionBean getPermissionForUser(UserBean user);
    public PermissionBean getPermissionForRole(RoleBean role);
}
