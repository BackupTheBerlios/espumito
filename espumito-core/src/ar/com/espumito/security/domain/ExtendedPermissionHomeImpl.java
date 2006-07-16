package ar.com.espumito.security.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.security.persistence.ExtendedPermissionDAO;

public class ExtendedPermissionHomeImpl
    implements ExtendedPermissionHome
{

    private ExtendedPermissionDAO extendedPermissionDao;

    public ExtendedPermissionHomeImpl(ExtendedPermissionDAO extendedPermissionDao)
    {
        super();
        this.extendedPermissionDao = extendedPermissionDao;
    }

    public ExtendedPermissionBean create(String name, String description)
        throws CreateException
    {
        ExtendedPermissionBean extendedPermission = new ExtendedPermissionBean();
        extendedPermission.setName(name);
        extendedPermission.setDescription(description);
        try
        {
            return (ExtendedPermissionBean) this.extendedPermissionDao.save(extendedPermission);
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.CreateException(e);
        }
    }

    public ExtendedPermissionBean findByName(String name)
        throws FinderException
    {
        try
        {
            return (ExtendedPermissionBean) this.extendedPermissionDao.findByName(name);
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    public ExtendedPermissionBean findByPrimaryKey(Long id)
        throws FinderException
    {
        try
        {
            return (ExtendedPermissionBean) this.extendedPermissionDao.find(id);
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
    }

    public List<ExtendedPermissionBean> findAll()
        throws FinderException
    {
        List<ExtendedPermissionBean> ret = new Vector<ExtendedPermissionBean>();
        Collection extendedPermissions = null;
        try
        {
            extendedPermissions = this.extendedPermissionDao.findAll();
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
        for (Iterator i = extendedPermissions.iterator(); i.hasNext();)
            ret.add((ExtendedPermissionBean) i.next());
        return ret;
    }
}
