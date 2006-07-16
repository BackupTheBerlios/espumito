package ar.com.espumito.security.persistence;

import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.security.domain.ExtendedPermissionBean;


public interface ExtendedPermissionDAO
    extends DataAccessObject
{
    public ExtendedPermissionBean findByName(String name) throws PersistenceException;
}
