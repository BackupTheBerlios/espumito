/*
 * Created on 27-may-2005
 */
package ar.com.espumito.util;

/**
 * Un comparador para implementaciones de
 * {@link ar.com.espumito.util.Identifiable} La clase es thread-safe.
 * 
 * @author guybrush
 */
public class IdentifiableComparator implements Comparator {
    public static final String NAME = "Generic Indentifiable comparator";

    public static final Comparator INSTANCE = new IdentifiableComparator();

    public IdentifiableComparator() {
        super();
    }

    public String getName() {
        return NAME;
    }

    /**
     * Asume que o1 y o2 son instancias de
     * {@link ar.com.espumito.util.Identifiable}. Compara el resultado del
     * {@link ar.com.espumito.util.Identifiable#getId()} de cada objeto.
     * 
     * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
     * @throws NullPointerException
     *             si o1 == null � o2 == null.
     */
    public int compare(Object o1, Object o2) {
        Identifiable i1 = (Identifiable) o1;
        Identifiable i2 = (Identifiable) o2;
        return (i1.getId().compareTo(i2.getId()));
    }

}
