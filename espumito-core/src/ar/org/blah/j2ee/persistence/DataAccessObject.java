/*
 * Created on 06-feb-2005
 */
package ar.org.blah.j2ee.persistence;

import java.io.Serializable;
import java.util.Collection;

/**
 * Interfaz de los DataAccessObject.
 * 
 * @author guybrush
 */
public interface DataAccessObject {
    /**
     * @param object
     * @return
     * @throws PersistenceException
     */
    public Object save(Object object) throws PersistenceException;

    /**
     * @param id
     * @return
     * @throws PersistenceException
     */
    public Object find(Serializable id) throws PersistenceException;

    /**
     * @return
     * @throws PersistenceException
     */
    public Collection findAll() throws PersistenceException;

    /**
     * @param object
     * @throws PersistenceException
     */
    public void delete(Object object) throws PersistenceException;

    /**
     * @param object
     * @return
     * @throws PersistenceException
     */
    public Object update(Object object) throws PersistenceException;
}
