package ar.com.espumito.persistence;

import java.io.Serializable;
import java.util.Collection;

public interface GenericDataAccessObject<T, I extends Serializable>
{

    public void delete(T object)
        throws PersistenceException;

    public T find(I id)
        throws PersistenceException;

    public Collection<T> findAll()
        throws PersistenceException;

    public T save(T object)
        throws PersistenceException;

    public T update(T object)
        throws PersistenceException;
}
