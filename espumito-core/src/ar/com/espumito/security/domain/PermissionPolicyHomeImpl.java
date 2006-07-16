package ar.com.espumito.security.domain;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.ejb.FinderException;
import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.persistence.PersistenceException;


public class PermissionPolicyHomeImpl
    implements PermissionPolicyHome
{
    private DataAccessObject permissionPolicyDAO;

    public PermissionPolicyHomeImpl(DataAccessObject permissionPolicyDAO)
    {
        super();
        this.permissionPolicyDAO = permissionPolicyDAO;
    }

    public List<PermissionPolicyBean> findAll()
        throws FinderException
    {
        List<PermissionPolicyBean> ret = new Vector<PermissionPolicyBean>();
        Collection permissionPolicies = null;
        try
        {
            permissionPolicies = this.permissionPolicyDAO.findAll();
        } catch (PersistenceException e)
        {
            throw new ar.com.espumito.core.ejb.FinderException(e);
        }
        for (Iterator i = permissionPolicies.iterator(); i.hasNext();)
            ret.add((PermissionPolicyBean) i.next());
        return ret;
    }
}
