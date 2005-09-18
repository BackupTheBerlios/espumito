/*
 * Created on 20-feb-2005
 */
package ar.com.espumito.security.services;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import ar.com.espumito.security.AuthenticationException;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;

/**
 * @author guybrush TODO: no funcionan los tags de XDoclet.
 */
public interface SecuritySvc {
    public UserVO getUser(String pUsername) throws FinderException;

    /**
     * @param pVO
     * @throws CreateException
     */
    public void registerUser(UserVO pVO) throws CreateException;

    /**
     * @param pVO
     * @throws FinderException
     */
    public void editUser(UserVO pVO) throws FinderException;

    /**
     * @param pUsername
     * @param pEmail
     * @throws FinderException
     */
    public void recoverPassword(String pUsername, String pEmail)
            throws FinderException;

    /**
     * @return
     * @throws FinderException
     */
    public Collection getUsers() throws FinderException;

    /**
     * @return
     * @throws FinderException
     */
    public Collection getRoles() throws FinderException;

    /**
     * @param pVO
     * @throws CreateException
     */
    public void createRole(RoleVO pVO) throws CreateException;

    /**
     * @param username
     * @param credentials
     * @throws AuthenticationException
     */
    public void authenticate(String username, Object[] credentials)
            throws AuthenticationException;

    /**
     * @return
     * @throws ar.org.blah.j2ee.FinderException
     */
    public Collection getRoleGroups() throws ar.org.blah.j2ee.FinderException;
}
