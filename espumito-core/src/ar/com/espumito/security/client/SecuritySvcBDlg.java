/*
 * Created on 20-feb-2005
 */
package ar.com.espumito.security.client;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import ar.com.espumito.security.AuthenticationException;
import ar.com.espumito.security.locator.SecurityServiceLocatorFactory;
import ar.com.espumito.security.services.SecuritySvc;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;

/**
 * <p>
 * Business delegate form {@link ar.com.espumito.core.security.SecuritySvc}.
 * </p>
 * <p>
 * Date: 20-mar-2006
 * </p>
 * 
 * @author guybrush
 */
public class SecuritySvcBDlg implements SecuritySvc {

    private static SecuritySvc service;

    private static SecuritySvc getService() {
	if (service == null)
	    service = SecurityServiceLocatorFactory.getInstance()
		    .getSecurityServiceLocator().getSecurityService();
	return service;
    }

    public SecuritySvcBDlg() {
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#addRole(ar.com.espumito.security.vo.RoleVO)
         */
    public void addRole(RoleVO role) throws CreateException {
	getService().addRole(role);
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#authenticate(java.lang.String,
         *      java.lang.Object[])
         */
    public void authenticate(String username, Object[] credentials)
	    throws AuthenticationException {
	getService().authenticate(username, credentials);
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#createRole(ar.com.espumito.security.vo.RoleVO)
         */
    public void createRole(RoleVO pVO) throws CreateException {
	getService().createRole(pVO);
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#editUser(ar.com.espumito.security.vo.UserVO)
         */
    public void editUser(UserVO pVO) throws FinderException {
	getService().editUser(pVO);
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#getRole(java.lang.Long)
         */
    public RoleVO getRole(Long id) throws FinderException {
	return getService().getRole(id);
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#getRoleGroups()
         */
    public Collection getRoleGroups()
	    throws ar.com.espumito.core.ejb.FinderException {
	return getService().getRoleGroups();
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#getRoles()
         */
    public Collection getRoles() throws FinderException {
	return getService().getRoles();
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#getUser(java.lang.String)
         */
    public UserVO getUser(String pUsername) throws FinderException {
	return getService().getUser(pUsername);
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#getUsers()
         */
    public Collection getUsers() throws FinderException {
	return getService().getUsers();
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#recoverPassword(java.lang.String,
         *      java.lang.String)
         */
    public void recoverPassword(String pUsername, String pEmail)
	    throws FinderException {
	getService().recoverPassword(pUsername, pEmail);
    }
}
