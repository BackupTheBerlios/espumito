package ar.com.espumito.security.services;

import ar.com.espumito.services.ValueObject;

public class PermissionPolicyVO
    extends ValueObject
{

    public String description;
    public Long   id;
    public String name;

    public String getDescription()
    {
        return this.description;
    }

    public Long getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
