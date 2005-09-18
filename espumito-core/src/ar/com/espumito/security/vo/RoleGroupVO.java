/*
 * Created on 29-ago-2005
 */
package ar.com.espumito.security.vo;

import java.util.HashSet;
import java.util.Set;

import ar.org.blah.j2ee.vo.ValueObject;

public class RoleGroupVO extends ValueObject {
    private Long id;
    private String name;
    private Set roles = new HashSet();
    
    public RoleGroupVO() {
        super();
    }

    /**
     * @param id
     */
    public RoleGroupVO(Long id) {
        super();
        
        this.id = id;
    }

    /**
     * @param id
     * @param name
     */
    public RoleGroupVO(Long id, String name) {
        super();
        
        this.id = id;
        this.name = name;
    }

    /**
     * @param id
     * @param name
     * @param roles
     */
    public RoleGroupVO(Long id, String name, Set roles) {
        super();
        
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    public void addRole(RoleVO role)
    {
        roles.add(role);
    }

    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public Set getRoles() {
        return roles;
    }

    public void removeRole(RoleVO role)
    {
        roles.remove(role);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}
