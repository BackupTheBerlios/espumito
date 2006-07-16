package ar.com.espumito.security.services;

import ar.com.espumito.services.ValueObject;

public class ExtendedPermissionVO
    extends ValueObject
{

    private Long   id;
    private String name;
    private String description;

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
