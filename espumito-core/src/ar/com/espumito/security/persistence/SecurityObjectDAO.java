package ar.com.espumito.security.persistence;

import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.security.domain.SecurityObjectBean;


public interface SecurityObjectDAO extends DataAccessObject
{
    public SecurityObjectBean findByName(String name) throws PersistenceException;
}
