/*
 * Created on 27-may-2005
 */
package ar.org.blah.j2ee.vo;

import java.util.Date;

import ar.org.blah.util.Created;

/**
 * Clase de utilidad que implementa interfaces aplicables a varios value
 * objects.
 * 
 * @author guybrush
 */
public class FullValueObject extends IDValueObject implements Created {
    protected java.util.Date creationDate;

    public FullValueObject() {
        super();

    }

    public FullValueObject(Long id) {
        super(id);

    }

    public FullValueObject(Long id, Date creationDate) {
        super(id);
        this.creationDate = creationDate;
    }

    /**
     * @see ar.org.blah.util.Created#createdBefore(ar.org.blah.util.Created)
     */
    public boolean createdBefore(Created created) {
        return creationDate.before(created.getCreationDate());
    }

    /**
     * @see ar.org.blah.util.Created#createdBefore(java.util.Date)
     */
    public boolean createdBefore(Date date) {
        return creationDate.before(date);
    }

    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }
}
