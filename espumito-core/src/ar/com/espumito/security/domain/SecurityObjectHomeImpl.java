package ar.com.espumito.security.domain;

import java.util.List;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.security.persistence.SecurityObjectDAO;

public class SecurityObjectHomeImpl
    implements SecurityObjectHome
{

    private SecurityObjectDAO securityObjectDAO;

    public SecurityObjectHomeImpl(SecurityObjectDAO securityObjectDAO)
    {
        super();
        this.securityObjectDAO = securityObjectDAO;
    }

    public SecurityObjectBean findByName(String name)
        throws FinderException
    {
        try
        {
            SecurityObjectBean securityObject = this.securityObjectDAO.findByName(name);
            if (securityObject != null)
                return securityObject;
            else
                throw new ObjectNotFoundException();
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    public SecurityObjectBean findByPrimaryKey(Long id)
        throws FinderException
    {
        try
        {
            SecurityObjectBean securityObject = (SecurityObjectBean) this.securityObjectDAO.find(id);
            if (securityObject != null)
                return securityObject;
            else
                throw new ObjectNotFoundException();
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    public List<SecurityObjectBean> findAll()
        throws FinderException
    {
        try
        {
            List<SecurityObjectBean> ret = (List<SecurityObjectBean>) this.securityObjectDAO.findAll();
            return ret;
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }
}
