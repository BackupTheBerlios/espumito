package ar.com.espumito.security.domain;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.security.persistence.OperationDAO;


public class OperationHomeImpl
    implements OperationHome
{
    private OperationDAO operationDAO;
    
    public OperationBean create(String name, String description)
        throws CreateException
    {
        OperationBean operation = new OperationBean();
        operation.setName(name);
        operation.setDescription(description);
        try
        {
            return (OperationBean) this.operationDAO.save(operation);
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.CreateException(e);
        }
    }

    public OperationBean findByPrimaryKey(Long id)
        throws FinderException
    {
        try
        {
            return (OperationBean) this.operationDAO.find(id);
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    public OperationBean findByName(String name)
        throws FinderException
    {
        try
        {
            return (OperationBean) this.operationDAO.findByName(name);
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }
}
