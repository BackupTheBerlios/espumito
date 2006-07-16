package ar.com.espumito.security.services;

import ar.com.espumito.services.ValueObject;

public class SecurityObjectVO
    extends ValueObject
{

    private String             description;
    private long               id;
    private String             name;
    private SecurityObjectVO   father;
    private PermissionPolicyVO permissionPolicy;

    public SecurityObjectVO()
    {
        super();
    }

    public SecurityObjectVO(long id)
    {
        super();
        this.id = id;
    }

    public SecurityObjectVO(long id, String name, String description)
    {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * @return Returns the description.
     */
    public String getDescription()
    {
        return this.description;
    }

    public SecurityObjectVO getFather()
    {
        return this.father;
    }

    /**
     * @return Returns the id.
     */
    public long getId()
    {
        return this.id;
    }

    /**
     * @return Returns the name.
     */
    public String getName()
    {
        return this.name;
    }

    public PermissionPolicyVO getPermissionPolicy()
    {
        return this.permissionPolicy;
    }

    /**
     * @param description
     *            The description to set.
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setFather(SecurityObjectVO father)
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

    public void setPermissionPolicy(PermissionPolicyVO permissionPolicy)
    {
        this.permissionPolicy = permissionPolicy;
    }
}
