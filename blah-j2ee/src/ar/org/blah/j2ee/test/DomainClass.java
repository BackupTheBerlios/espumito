/*
 * Created on 03-mar-2005
 */
package ar.org.blah.j2ee.test;

import ar.org.blah.j2ee.domain.PersistentClassImpl;

/**
 * @author guybrush
 * @hibernate.class table="domain"
 */
public class DomainClass extends PersistentClassImpl {
    private Long id;

    private String name;

    public DomainClass() {
        super();

    }

    /**
     * @return
     * @hibernate.id column="id" type="long"  generator-class="increment"
     */
    public Long getId() {
        return id;
    }

    protected void setId(Long pId) {
        id = pId;
    }

    /**
     * @return
     * @hibernate.property column="name" type="string"
     */
    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

}
