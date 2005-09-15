/*
 * Created on 14-ago-2005
 */
package ar.org.blah.j2ee.persistence;

/**
 * @author guybrush
 */
public interface DataAccessObjectFactory {
    /**
     * Obtiene el DAO para una clase determinada.
     * @param aClass
     * @return
     */
    public DataAccessObject getDataAccessObject(Class aClass);
}
