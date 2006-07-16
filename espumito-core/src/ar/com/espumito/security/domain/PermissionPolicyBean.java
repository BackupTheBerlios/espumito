package ar.com.espumito.security.domain;


/**
 * <p>
 * Policy used by a security object to assign permissions to users and roles.
 * </p>
 * <p>
 * Date: 24-mar-2006
 * </p>
 * 
 * @author guybrush
 * @hibernate.class table="core_permission_policies"
 * @hibernate.discriminator column="type"
 */
public abstract class PermissionPolicyBean
{

    public String description;
    public Long   id;
    public String name;

    public PermissionPolicyBean()
    {
        super();
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
     * @return Returns the id.
     * @hibernate.id column="id" type="long" generator-class="native"
     */
    public Long getId()
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
     * @param user
     * @param securityObject
     * @return
     */
    public abstract PermissionBean getPermissionForRole(RoleBean role, SecurityObjectBean securityObject);

    /**
     * @param user
     * @param securityObject
     * @return
     */
    public abstract PermissionBean getPermissionForUser(UserBean user, SecurityObjectBean securityObject);

    /**
     * @param description
     *            The description to set.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id)
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
}
