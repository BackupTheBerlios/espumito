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
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object obj) {
        return obj instanceof Principal && equals((Principal) obj);
    }

    public boolean equals(Principal obj) {
        return obj != null && obj.getName() != null
                && obj.getName().equals(name);
    }

    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String toString() {
        return name != null ? name : "";
    }

}
