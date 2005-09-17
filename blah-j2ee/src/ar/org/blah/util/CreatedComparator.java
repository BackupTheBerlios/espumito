/*
 * Created on 27-may-2005
 */
package ar.org.blah.util;

/**
 * Comparador para instancias de Created.
 * 
 * @author guybrush
 */
public class CreatedComparator implements Comparator {
    public static final String NAME = "Creation date comparator";

    public static final CreatedComparator INSTANCE = new CreatedComparator();

    public CreatedComparator() {
        super();
    }

    /**
     * @see ar.org.blah.util.Comparator#getName()
     */
    public String getName() {
        return NAME;
    }

    /**
     * Compara segun la fecha de creacion.
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     */
    public int compare(Object o1, Object o2) {
        Created c1 = (Created) o1;
        Created c2 = (Created) o2;
        if (c1.createdBefore(c2))
            return LESS_THAN;
        else if (c2.createdBefore(c1))
            return GREATER_THAN;
        else
            return EQUAL_TO;
    }

}
