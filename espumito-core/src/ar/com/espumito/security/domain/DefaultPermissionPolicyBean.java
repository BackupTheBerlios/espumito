package ar.com.espumito.security.domain;

import java.util.Iterator;
import java.util.Set;

/**
 * <p>
 * TODO: add description for DefaultPermissionPolicyBean
 * </p>
 * <p>
 * Date: 24-mar-2006
 * </p>
 * 
 * @author guybrush
 * @hibernate.joined-subclass table="core_default_permission_policies"
 * @hibernate.joined-subclass-key column="id"
 */
public class DefaultPermissionPolicyBean
    extends PermissionPolicyBean
{

    private RoleBean anonymousRole;

    public DefaultPermissionPolicyBean()
    {
        super();
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
        else
        {
            boolean read = false;
            boolean write = false;
            boolean execute = false;
            boolean delete = false;
            boolean isOver = false;
            for (Iterator roles = user.getRoles().iterator(); roles.hasNext() && !isOver;)
            {
                RoleBean role = (RoleBean) roles.next();
                PermissionBean permission = getPermissionForRole(role, securityObject);
                read = read || permission.isRead();
                write = write || permission.isWrite();
                execute = execute || permission.isExecute();
                delete = delete || permission.isDelete();
                isOver = read && write && execute && delete;
            }
            PermissionBean permission = new PermissionBean(null, delete, execute, read, write);
            return permission;
        }
    }

    /**
     * @return Returns the anonymousRole.
     * @hibernate.many-to-one column="anonymous_role_id" class="ar.com.espumito.security.domain.RoleBean"
     */
    public RoleBean getAnonymousRole()
    {
        return this.anonymousRole;
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
