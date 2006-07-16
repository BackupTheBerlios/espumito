package ar.com.espumito.security.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * An object to which permissions can be applied.
 * </p>
 * <p>
 * Date: 20-mar-2006
 * </p>
 * 
 * @author guybrush
 * @hibernate.class table = "core_security_objects"
 */
public class SecurityObjectBean
{

    private Set                  children            = new HashSet();
    private String               description;
    private SecurityObjectBean   father;
    private long                 id;
    private String               name;
    private PermissionPolicyBean permissionPolicy;
    private Set                  permissions         = new HashSet();


    public SecurityObjectBean()
    {
        super();
    }

    /**
     * @param child
     */
    public void addChild(SecurityObjectBean child)
    {
        this.children.add(child);
    }

    /**
     * @param permission
     */
    public void addPermission(PermissionBean permission)
    {
        this.permissions.add(permission);
    }

    public PermissionBean getAnonymousPermission()
    {
        return PermissionBean.ANONYMOUS_PERMISSION;
    }

    /**
     * @return Returns the children.
     * @hibernate.set cascade="all" inverse="true"
     * @hibernate.collection-key column="father_id"
     * @hibernate.collection-one-to-many class="ar.com.espumito.security.domain.SecurityObjectBean"
     */
    public Set getChildren()
    {
        return this.children;
    }

    /**
     * @return Returns the description.
     * @hibernate.property column="description" type="string"
     */
    public String getDescription()
    {
        return this.description;
    }

    
    /**
     * @return Returns the father.
     * @hibernate.many-to-one column="father_id" class="ar.com.espumito.security.domain.SecurityObjectBean"
     */
    public SecurityObjectBean getFather()
    {
        return this.father;
    }

    /**
     * @return Returns the id.
     * @hibernate.id column="id" generator-class="increment"
     */
    public long getId()
    {
        return this.id;
    }

    /**
     * @return Returns the name.
     * @hibernate.property column="name" type="string"
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Obtains the permissions stablished on this security object for a given role.
     * 
     * @param role
     * @return
     */
    public PermissionBean getPermissionForRole(RoleBean role)
    {
        PermissionPolicyBean policy = getPermissionPolicy();
        if (policy != null)
            return policy.getPermissionForRole(role, this);
        else if (this.father != null)
            return this.father.getPermissionForRole(role);
        else
            return null;
    }

    /**
     * Determines the permissions on this security object for a given user through its roles.
     * 
     * @param user
     * @return
     */
    public PermissionBean getPermissionForUser(UserBean user)
    {
        PermissionPolicyBean policy = getPermissionPolicy();
        if (policy != null)
            return policy.getPermissionForUser(user, this);
        else if (this.father != null)
            return this.father.getPermissionForUser(user);
        else
            return null;
    }

    /**
     * @return Returns the permissionPolicy.
     * @hibernate.many-to-one column="permission_policy_id" class="ar.com.espumito.security.domain.PermissionPolicyBean"
     */
    public PermissionPolicyBean getPermissionPolicy()
    {
        if (this.permissionPolicy == null && this.father != null)
            return this.father.getPermissionPolicy();
        return this.permissionPolicy;
    }

    /**
     * @return Returns the permissions.
     * @hibernate.set cascade="all" inverse="true"
     * @hibernate.collection-key column="security_object_id"
     * @hibernate.collection-one-to-many class="ar.com.espumito.security.domain.PermissionBean"
     */
    public Set getPermissions()
    {
        return this.permissions;
    }

    /**
     * @param child
     */
    public void removeChild(SecurityObjectBean child)
    {
        this.children.remove(child);
    }

    /**
     * @param permission
     */
    public void removePermission(PermissionBean permission)
    {
        this.permissions.remove(permission);
    }

    /**
     * @param children
     *            The children to set.
     */
    public void setChildren(Set children)
    {
        this.children = children;
    }

    /**
     * @param description
     *            The description to set.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }


    /**
     * @param father
     *            The father to set.
     */
    public void setFather(SecurityObjectBean father)
    {
        this.father = father;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @param permissionPolicy
     *            The permissionPolicy to set.
     */
    public void setPermissionPolicy(PermissionPolicyBean permissionPolicy)
    {
        this.permissionPolicy = permissionPolicy;
    }

    /**
     * @param permissions
     *            The permissions to set.
     */
    public void setPermissions(Set permissions)
    {
        this.permissions = permissions;
    }
}
