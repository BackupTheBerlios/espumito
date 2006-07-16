/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security;

import java.io.Serializable;

/**
 * @author guybrush
 */
public class Principal implements java.security.Principal, Serializable {
    private String name;

    public Principal(String name) {
        super();
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        return obj instanceof Principal && equals((Principal) obj);
    }

    public boolean equals(Principal obj) {
        return obj != null && obj.getName() != null
                && obj.getName().equals(this.name);
    }

    public int hashCode() {
        return this.name != null ? this.name.hashCode() : 0;
    }

    public String toString() {
        return this.name != null ? this.name : "";
    }

}
