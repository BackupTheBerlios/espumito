/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

/**
 * @author guybrush
 */
public interface RoleHome {
	public RoleBean create(String name) throws CreateException;
	
    /**
     * @param id
     * @return
     * @throws FinderException
     */
    public RoleBean findByPrimaryKey(Long id) throws FinderException;

    /**
     * @param name
     * @return
     * @throws FinderException
     */
    public RoleBean findByName(String name) throws FinderException;

    /**
     * @return
     * @throws ar.com.espumito.core.ejb.FinderException
     */
    public Set findAll() throws ar.com.espumito.core.ejb.FinderException;
}
