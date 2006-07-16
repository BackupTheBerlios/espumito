/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Collection;

import javax.ejb.FinderException;

public interface RoleGroupHome {
    /**
     * Busca un grupo de roles por nombre.
     * @param id
     * @return
     * @throws FinderException
     */
    public RoleGroupBean findByPrimaryKey(Long id) throws FinderException;
    
    /**
     * @return
     * @throws FinderException
     */
    public RoleGroupBean findDefaultRoleGroup() throws FinderException;
    
    public Collection findAll() throws ar.com.espumito.core.ejb.FinderException;

}
