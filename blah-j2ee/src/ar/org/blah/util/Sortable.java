/*
 * Created on 27-may-2005
 */
package ar.org.blah.util;

/**
 * Una interfaz que representan clases que pueden ser ordenadas por múltiples
 * criterios.
 * 
 * @author guybrush
 * @see ar.org.blah.util.Comparator
 */
public interface Sortable {
    /**
     * Los clientes de la clase pueden asumir que este método devuelve un vector
     * con al menos 1 elemento.
     * 
     * @return Los comparadores que permiten los distintos criterios de
     *         ordenamiento.
     */
    public Comparator[] getComparators();

    /**
     * Los clientes de la clase pueden asumir que este método no devuelve null.
     * 
     * @return El comparador default.
     */
    public Comparator getDefaultComparator();
}
