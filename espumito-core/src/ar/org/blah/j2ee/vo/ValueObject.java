/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.vo;

import java.io.Serializable;

public class ValueObject implements Serializable {
    private long version;

    public ValueObject() {
        super();

    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

}
