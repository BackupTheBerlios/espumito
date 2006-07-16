/*
 * Created on 27-may-2005
 */
package ar.com.espumito.util;

/**
 * Una interfaz que representan clases que pueden ser ordenadas por m�ltiples
 * criterios.
 * 
 * @author guybrush
 * @see ar.com.espumito.util.Comparator
 */
public interface Sortable {
    /**
     * Los clientes de la clase pueden asumir que este m�todo devuelve un vector
     * con al menos 1 elemento.
     * 
     * @return Los comparadores que permiten los distintos criterios de
     *         ordenamiento.
     */
    public Comparator[] getComparators();

    /**
     * Los clientes de la clase pueden asumir que este m�todo no devuelve null.
     * 
     * @return El comparador default.
     */
    public Comparator getDefaultComparator();
}
