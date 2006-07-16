package ar.com.espumito.plaf.persistence;

import ar.com.espumito.core.io.Resource;

public class LookAndFeelResource
{

    private String   id;
    private Resource resource;

    public LookAndFeelResource()
    {
        super();
    }

    public LookAndFeelResource(String id, Resource resource)
    {
        super();
        this.id = id;
        this.resource = resource;
    }

    /**
     * @return the id
     */
    public String getId()
    {
        return this.id;
    }

    /**
     * @return the resource
     */
    public Resource getResource()
    {
        return this.resource;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id)
    {
        this.id = id;
    }

    /**
     * @param resource
     *            the resource to set
     */
    public void setResource(Resource resource)
    {
        this.resource = resource;
    }
}
