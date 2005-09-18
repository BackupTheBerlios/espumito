/*
 * Created on 08-mar-2005
 */
package ar.com.espumito.security.services;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;

import ar.com.espumito.ejb.AbstractSessionBean;
import ar.com.espumito.security.AuthenticationException;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;

/**
 * @ejb.bean name="SecuritySvcSession" display-name="Name for SecuritySvcSession"
 *           description="Description for SecuritySvcSession"
 *           jndi-name="ejb/ar/com/espumito/core/SecuritySvcSession"
 *           type="Stateless" view-type="both"
 * @ejb.interface local-extends = "ar.com.espumito.security.services.SecuritySvc"
 */
public class SecuritySvcSessionBean extends AbstractSessionBean implements
        SecuritySvc {

    private SecuritySvc service;

    public SecuritySvcSessionBean() {
        super();
    }

    /**
     * @see ar.com.espumito.security.SecuritySvc#authenticate(java.lang.String,
     *      java.lang.Object[])
     * @ejb.transaction type="Required"
     * @ejb.interface-method view-type="remote"
     */
    public void authenticate(String username, Object[] credentials)
            throws AuthenticationException {
        service.authenticate(username, credentials);
    }

    /**
     * @see ar.com.espumito.security.services.SecuritySvc#createRole(ar.com.espumito.security.vo.RoleVO)
     * @ejb.transaction type="Required"
     * @ejb.interface-method view-type="remote"
     * 
     */
    public void createRole(RoleVO pVO) throws CreateException {
        service.createRole(pVO);
    }

    /**
     * @see ar.com.espumito.security.services.SecuritySvc#editUser(ar.com.espumito.security.vo.UserVO)
     * @ejb.transaction type="Required"
     * @ejb.interface-method view-type="remote"
     * 
     */
    public void editUser(UserVO pVO) throws FinderException {
        service.editUser(pVO);
    }

    /**
     * @see ar.com.espumito.security.services.SecuritySvc#getRoleGroups()
     * @ejb.interface-method view-type="remote"
     * 
     */
    public Collection getRoleGroups() throws ar.org.blah.j2ee.FinderException {
        return service.getRoleGroups();
    }

    /**
     * @see ar.com.espumito.security.services.SecuritySvc#getRoles()
     * @ejb.transaction type="Required"
     * @ejb.interface-method view-type="remote"
     * 
     */
    public Collection getRoles() throws FinderException {
        return service.getRoles();
    }

    /**
     * @see ar.com.espumito.security.services.SecuritySvc#getUser(java.lang.String)
     * @ejb.transaction type="Required"
     * 
     * @ejb.interface-method view-type="remote"
     */
    public UserVO getUser(String pUsername) throws FinderException {
        return service.getUser(pUsername);
    }

    /**
     * @see ar.com.espumito.security.services.SecuritySvc#getUsers()
     * @ejb.transaction type="Required"
     * @ejb.interface-method view-type="remote"
     * 
     */
    public Collection getUsers() throws FinderException {
        return service.getUsers();
    }

    protected void myActivate() throws EJBException {
        super.myActivate();
        try {
            service = (SecuritySvc) getService("securitySvc");
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }

    /**
     * @see ar.com.espumito.security.services.SecuritySvc#recoverPassword(java.lang.String,
     *      java.lang.String)
     * @ejb.transaction type="Required"
     * 
     * @ejb.interface-method view-type="remote"
     */
    public void recoverPassword(String pUsername, String pEmail)
            throws FinderException {
        service.recoverPassword(pUsername, pEmail);
    }

    /**
     * @see ar.com.espumito.security.services.SecuritySvc#registerUser(ar.com.espumito.security.vo.UserVO)
     * @ejb.transaction type="Required"
     * @ejb.interface-method view-type="remote"
     * 
     */
    public void registerUser(UserVO pVO) throws CreateException {
        service.registerUser(pVO);
    }

}
