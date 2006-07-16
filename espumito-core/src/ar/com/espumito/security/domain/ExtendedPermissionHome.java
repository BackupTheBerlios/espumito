package ar.com.espumito.security.domain;

import java.util.List;
import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface ExtendedPermissionHome
{

    public ExtendedPermissionBean create(String name, String description)
        throws CreateException;

    public ExtendedPermissionBean findByName(String name)
        throws FinderException;

    public ExtendedPermissionBean findByPrimaryKey(Long id)
        throws FinderException;
    
    public List<ExtendedPermissionBean> findAll() throws FinderException;
}
