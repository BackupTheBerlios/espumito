package ar.com.espumito.security.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * TODO: add description for ExtendedPermissionBean
 * </p>
 * <p>
 * Date: 04-abr-2006
 * </p>
 * 
 * @author guybrush
 */
public class ExtendedPermissionBean
{

    private Long               id;
    private String             name;
    private String             description;
    private Set<OperationBean> operations = new HashSet<OperationBean>();

    public ExtendedPermissionBean()
    {
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * @return the id
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * @return the name
     * @hibernate.property column="name" type="string" unique="true"
     */
    public String getName()
    {
        return this.name;
    }

    public Set<OperationBean> getOperations()
    {
        return this.operations;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public void setOperations(Set<OperationBean> operations)
    {
        this.operations = operations;
    }
}
