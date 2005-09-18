/*
 * Created on 07-mar-2005
 */
package ar.com.espumito.security.services;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import org.apache.log4j.Logger;

import ar.com.espumito.security.AuthenticationException;
import ar.com.espumito.security.InvalidUsernameException;
import ar.com.espumito.security.domain.RoleBean;
import ar.com.espumito.security.domain.RoleGroupHome;
import ar.com.espumito.security.domain.RoleHome;
import ar.com.espumito.security.domain.UserBean;
import ar.com.espumito.security.domain.UserHome;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;
import ar.org.blah.j2ee.persistence.PersistenceException;
import ar.org.blah.j2ee.vo.ValueObjectAssembler;
import ar.org.blah.j2ee.vo.ValueObjectMappingException;

/**
 * @author guybrush
 */
public class SecuritySvcImpl implements SecuritySvc {
    private static Logger logger = Logger.getLogger(SecuritySvcImpl.class);

    private ValueObjectAssembler userVOAssembler;

    private ValueObjectAssembler roleVOAssembler;

    private ValueObjectAssembler roleGroupVOAssembler;

    private UserHome userHome;

    private RoleHome roleHome;

    private RoleGroupHome roleGroupHome;

    public SecuritySvcImpl() {
        super();
    }

    /**
     * @see ar.com.espumito.security.SecuritySvc#getUser(java.lang.String)
     */
    public UserVO getUser(String pUsername) throws FinderException {
        try {
            return (UserVO) userVOAssembler.createValueObject(userHome
                    .findUserByUsername(pUsername));
        } catch (ValueObjectMappingException e) {
            throw new FinderException(e.getMessage());
        }
    }

    /**
     * @see ar.com.espumito.security.SecuritySvc#registerUser(ar.com.espumito.security.UserVO)
     */
    public void registerUser(UserVO pVO) throws CreateException {
        try {
            UserBean user = (UserBean) userVOAssembler.createInstance(null, pVO);
            user.save();
        } catch (ValueObjectMappingException e) {
            throw new CreateException(e.getMessage());
        } catch (PersistenceException e) {
            throw new ar.org.blah.j2ee.CreateException(e);
        }
    }

    /**
     * @see ar.com.espumito.security.SecuritySvc#editUser(ar.com.espumito.security.UserVO)
     */
    public void editUser(UserVO pVO) throws FinderException {
        try {
            userVOAssembler.updateBean(pVO, userHome.findUserByUsername(pVO
                    .getUsername()));
        } catch (ValueObjectMappingException e) {
            throw new FinderException(e.getMessage());
        }
    }

    /**
     * @see ar.com.espumito.security.SecuritySvc#recoverPassword(java.lang.String,
     *      java.lang.String)
     */
    public void recoverPassword(String pUsername, String pEmail)
            throws FinderException {
        UserBean user = userHome.findUserByUsername(pUsername);
        user.recoverPassword(pEmail);
    }

    /**
     * @see ar.com.espumito.security.SecuritySvc#getUsers()
     */
    public Collection getUsers() throws FinderException {
        Collection users = userHome.findAll();
        try {
            return userVOAssembler.createValueObjectCollection(users);
        } catch (ValueObjectMappingException e) {
            throw new FinderException(e.getMessage());
        }
    }

    /**
     * @TODO: el metodo no esta implementado.
     * @see ar.com.espumito.security.SecuritySvc#getRoles()
     */
    public Collection getRoles() throws FinderException {
        try {
            return roleVOAssembler.createValueObjectCollection(roleHome.findAll());
        } catch (ValueObjectMappingException e) {
            throw new ar.org.blah.j2ee.FinderException(e);
        }
    }

    /**
     * @see ar.com.espumito.security.SecuritySvc#createRole(ar.com.espumito.security.RoleVO)
     */
    public void createRole(RoleVO roleVO) throws CreateException {
        try {
            RoleBean role = (RoleBean) roleVOAssembler.createInstance(null, roleVO);
            role.save();
        } catch (ValueObjectMappingException e) {
            throw new CreateException(e.getMessage());
        } catch (PersistenceException e) {
            throw new CreateException(e.getMessage());
        }
    }

    /**
     * @see ar.com.espumito.security.services.SecuritySvc#authenticate(java.lang.String, java.lang.Object[])
     */
    public void authenticate(String username, Object[] credentials)
            throws AuthenticationException {
        try {
            UserBean user = userHome.findUserByUsername(username);
            user.authenticate(credentials);
        } catch (FinderException e) {
            throw new InvalidUsernameException("User " + username
                    + " does not exist.");
        }

    }

    public void setUserHome(UserHome userHome) {
        this.userHome = userHome;
    }

    public void setRoleHome(RoleHome roleHome) {
        this.roleHome = roleHome;
    }

    public void setRoleVOAssembler(ValueObjectAssembler roleVOAssembler) {
        this.roleVOAssembler = roleVOAssembler;
    }

    public void setUserVOAssembler(ValueObjectAssembler userVOAssembler) {
        this.userVOAssembler = userVOAssembler;
    }

    public Collection getRoleGroups() throws ar.org.blah.j2ee.FinderException {
        try {
            return roleGroupVOAssembler.createValueObjectCollection(roleGroupHome.findAll());
        } catch (ValueObjectMappingException e) {
            throw new ar.org.blah.j2ee.FinderException(e);
        }
    }

    public void setRoleGroupHome(RoleGroupHome roleGroupHome) {
        this.roleGroupHome = roleGroupHome;
    }

    public void setRoleGroupVOAssembler(ValueObjectAssembler roleGroupVOAssembler) {
        this.roleGroupVOAssembler = roleGroupVOAssembler;
    }

}
