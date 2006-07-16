package ar.com.espumito.security.domain;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface OperationHome
{

    public OperationBean create(String name, String description)
        throws CreateException;
    
    public OperationBean findByPrimaryKey(Long id) throws FinderException;
    
    public OperationBean findByName(String name) throws FinderException;
}
