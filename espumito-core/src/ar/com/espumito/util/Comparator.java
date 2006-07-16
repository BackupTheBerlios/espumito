/*
 * Created on 27-may-2005
 */
package ar.com.espumito.util;

/**
 * Extensi�n de la interfaz {@link java.util.Comparator} para agregarle un
 * nombre a un comparador.
 * 
 * @author guybrush
 */
public interface Comparator extends java.util.Comparator {
    public static final int LESS_THAN = -1;

    public static final int EQUAL_TO = 0;

    public static final int GREATER_THAN = 1;

    public String getName();
}
