package ar.com.espumito.security.domain;

import java.util.List;
import javax.ejb.FinderException;

public interface SecurityObjectHome
{

    public List<SecurityObjectBean> findAll()
        throws FinderException;

    public SecurityObjectBean findByName(String name)
        throws FinderException;

    public SecurityObjectBean findByPrimaryKey(Long id)
        throws FinderException;
}
