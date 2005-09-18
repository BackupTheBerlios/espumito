/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Set;

import javax.ejb.FinderException;

/**
 * @author guybrush
 */
public interface RoleHome {
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
     * @throws ar.org.blah.j2ee.FinderException
     */
    public Set findAll() throws ar.org.blah.j2ee.FinderException;
}
