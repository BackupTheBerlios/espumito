package ar.com.espumito.security.persistence;

import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.security.domain.OperationBean;


public interface OperationDAO
    extends DataAccessObject
{
    public OperationBean findByName(String name) throws PersistenceException;
}
