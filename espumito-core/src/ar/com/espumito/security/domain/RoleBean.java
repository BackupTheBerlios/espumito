/*
 * Created on 21-feb-2005
 */
package ar.com.espumito.security.domain;

import ar.com.espumito.support.spring.SpringSupport;
import ar.org.blah.j2ee.domain.PersistentClassImpl;
import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.persistence.DataAccessObjectFactory;

/**
 * @author guybrush
 * @hibernate.class table = "roles"
 */
public class RoleBean extends PersistentClassImpl implements DataAccessObjectFactory{

    private String description;

    private Long id;

    private String name;

    /**
     * Constructor
     */
    protected RoleBean() {
        super();
        setDaoFactory(this);
    }

    /**
     * Constructor
     * 
     * @param pName
     * @param pGroup
     */
    public RoleBean(String pName) {
        this();
        setName(pName);
    }

    public RoleBean(String name, String description) {
        super();
        setName(name);
        setDescription(description);
    }

    public boolean equals(Object obj) {
        return obj instanceof RoleBean && equals((RoleBean) obj);
    }

    public boolean equals(RoleBean obj) {
        return obj != null && obj.getId() != null && obj.getId().equals(id);
    }

    /**
     * @return
     * @hibernate.property column = "description" type = "string"
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return hibernate.property column = "group_id" type = "long"
     */
    // public Long getGroup() {
    // return groupId;
    // }
    /**
     * @return
     * @hibernate.id column = "id" type = "long" generator-class = "increment"
     */
    public Long getId() {
        return id;
    }

    /**
     * @return
     * @hibernate.property column = "name" type = "string"
     */
    public String getName() {
        return name;
    }

    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // protected void setGroup(Long pGroup) {
    // groupId = pGroup;
    // }

    protected void setId(Long pId) {
        id = pId;
    }

    public void setName(String pName) {
        name = pName;
    }

    public String toString() {
        return "[Role: " + name + " (id =" + id + ")]";
    }

    public DataAccessObject getDataAccessObject(Class aClass) {
        return (DataAccessObject) SpringSupport.getBeanFactory().getBean("roleDao");
    }

}
