/*
 * Created on 21-feb-2005
 */
package ar.com.espumito.security.vo;

import ar.com.espumito.services.ValueObject;

/**
 * @author guybrush
 */
public class RoleVO extends ValueObject {
    private String description;

    // private Long group;
    private Long id;

    private String name;

    /**
     * Constructor
     */
    public RoleVO() {
        super();

    }

    // public Long getGroup()
    // {
    // return group;
    // }

    public String getDescription() {
        return this.description;
    }

    public Long getId() {
        return this.id;
    }

    // public void setGroup(Long pGroup)
    // {
    // group = pGroup;
    // }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long pId) {
        this.id = pId;
    }

    public void setName(String pName) {
        this.name = pName;
    }
}
