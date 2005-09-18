/*
 * Created on 21-feb-2005
 */
package ar.com.espumito.security.vo;

import ar.org.blah.j2ee.vo.ValueObject;

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
        return description;
    }

    public Long getId() {
        return id;
    }

    // public void setGroup(Long pGroup)
    // {
    // group = pGroup;
    // }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(Long pId) {
        id = pId;
    }

    public void setName(String pName) {
        name = pName;
    }
}
