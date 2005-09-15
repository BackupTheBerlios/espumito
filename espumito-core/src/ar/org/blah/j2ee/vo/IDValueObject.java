/*
 * Created on 27-may-2005
 */
package ar.org.blah.j2ee.vo;

import ar.org.blah.util.Comparator;
import ar.org.blah.util.Identifiable;
import ar.org.blah.util.Sortable;

public class IDValueObject extends ValueObject implements Identifiable,
        Sortable {
    private static final Comparator[] COMPARATORS = new Comparator[] { IDENTIFIABLE_COMPARATOR };

    protected Long id;

    /**
     * 
     */
    public IDValueObject() {
        super();
    }

    /**
     * @param id
     */
    public IDValueObject(Long id) {
        super();
        this.id = id;
    }

    /**
     * @see ar.org.blah.util.Sortable#getComparators()
     */
    public Comparator[] getComparators() {
        return COMPARATORS;
    }

    /**
     * @see ar.org.blah.util.Sortable#getDefaultComparator()
     */
    public Comparator getDefaultComparator() {
        return IDENTIFIABLE_COMPARATOR;
    }

    /**
     * @see ar.org.blah.util.Identifiable#getId()
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
