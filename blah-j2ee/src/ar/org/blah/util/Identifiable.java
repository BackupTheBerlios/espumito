/*
 * Created on 27-may-2005
 */
package ar.org.blah.util;

/**
 * @author guybrush
 */
public interface Identifiable {
    public static final Comparator IDENTIFIABLE_COMPARATOR = IdentifiableComparator.INSTANCE;

    public Long getId();
}
