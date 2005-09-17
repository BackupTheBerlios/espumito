/*
 * Created on 05-mar-2005
 */
package ar.org.blah.j2ee.test;

import ar.org.blah.j2ee.vo.ValueObject;

public class DomainVO extends ValueObject {
    private Long id;

    private String name;

    public DomainVO() {
        super();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
