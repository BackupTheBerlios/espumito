package ar.com.espumito.security.domain;

import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 * TODO: add description for NewPermissionPolicyBean
 * </p>
 * <p>
 * Date: 06-abr-2006
 * </p>
 * 
 * @author guybrush
 * @hibernate.joined-subclass table="core_new_permission_policies"
 * @hibernate.joined-subclass-key column="id"
 */
public class NewPermissionPolicyBean
    extends PermissionPolicyBean
{

    private RoleBean anonymousRole;

    /**
     * @return Returns the anonymousRole.
     * @hibernate.many-to-one column="anonymous_role_id" class="ar.com.espumito.security.domain.RoleBean"
     */
    public RoleBean getAnonymousRole()
    {
        return this.anonymousRole;
    }

    public PermissionBean getPermissionForRole(RoleBean role, SecurityObjectBean securityObject)
    {
        Set permissions = securityObject.getPermissions();
        for (Iterator i = permissions.iterator(); i.hasNext();)
        {
            PermissionBean permission = (PermissionBean) i.next();
            if (permission.getRole().equals(role))
                return permission;
        }
        SecurityObjectBean father = securityObject.getFather();
        if (father != null)
            return father.getPermissionForRole(role);
        return PermissionBean.DENIED_PERMISSION;
    }

    public PermissionBean getPermissionForUser(UserBean user, SecurityObjectBean securityObject)
    {
        if (user == null)
            return getPermissionForRole(getAnonymousRole(), securityObject);
        PermissionBean permission = null;
        for (Iterator roles = user.getRoles().iterator(); roles.hasNext() && permission == null;)
            permission = getPermissionForRole((RoleBean) roles.next(), securityObject);
        return permission;
    }

    /**
     * @param anonymousRole
     *            The anonymousRole to set.
     */
    public void setAnonymousRole(RoleBean anonymousRole)
    {
        this.anonymousRole = anonymousRole;
    }
}
