/*
 * Created on 02-mar-2005
 */
package ar.com.espumito.services;

import java.io.Serializable;

public class ValueObject implements Serializable {
    private long version;

    public ValueObject() {
        super();

    }

    public long getVersion() {
        return this.version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

}
