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
import ar.com.espumito.security.UserDisabledException;
import ar.com.espumito.security.domain.RoleBean;
import ar.com.espumito.security.domain.RoleGroupHome;
import ar.com.espumito.security.domain.RoleHome;
import ar.com.espumito.security.domain.UserBean;
import ar.com.espumito.security.domain.UserHome;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;
import ar.com.espumito.services.ValueObjectAssembler;
import ar.com.espumito.services.ValueObjectMappingException;

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
    
    public SecuritySvcImpl(ValueObjectAssembler userVOAssembler, ValueObjectAssembler roleVOAssembler,
            ValueObjectAssembler roleGroupVOAssembler, UserHome userHome, RoleHome roleHome, RoleGroupHome roleGroupHome)
    {
        super();
        this.userVOAssembler = userVOAssembler;
        this.roleVOAssembler = roleVOAssembler;
        this.roleGroupVOAssembler = roleGroupVOAssembler;
        this.userHome = userHome;
        this.roleHome = roleHome;
        this.roleGroupHome = roleGroupHome;
    }



    public void addRole(RoleVO role) throws CreateException {
	this.roleHome.create(role.getName());
    }

    /**
         * @see ar.com.espumito.security.services.SecuritySvc#authenticate(java.lang.String,
         *      java.lang.Object[])
         */
    public void authenticate(String username, Object[] credentials)
	    throws AuthenticationException {
	try {
	    UserBean user = this.userHome.findUserByUsername(username);
	    user.authenticate(credentials);
	    if (!user.isEnabled())
		throw new UserDisabledException(user.getUsername());
	} catch (FinderException e) {
	    throw new InvalidUsernameException("User " + username
		    + " does not exist.");
	}

    }

    /**
         * @see ar.com.espumito.security.SecuritySvc#createRole(ar.com.espumito.security.RoleVO)
         */
    public void createRole(RoleVO roleVO) throws CreateException {
	this.roleHome.create(roleVO.getName());
    }

    /**
         * @see ar.com.espumito.security.SecuritySvc#editUser(ar.com.espumito.security.UserVO)
         */
    public void editUser(UserVO pVO) throws FinderException {
	try {
	    UserBean user = this.userHome.findUserByUsername(pVO.getUsername());
	    this.userVOAssembler.updateBean(pVO, user);
	} catch (ValueObjectMappingException e) {
	    throw new FinderException(e.getMessage());
	}
    }

    public RoleVO getRole(Long id) throws FinderException {
	RoleBean role = this.roleHome.findByPrimaryKey(id);
	try {
	    return (RoleVO) this.roleVOAssembler.createValueObject(role);
	} catch (ValueObjectMappingException e) {
	    // TODO: no deberìa pasar
	    logger.error("Error generando value object RoleVO", e);
	    return null;
	}
    }

    public Collection getRoleGroups()
	    throws ar.com.espumito.core.ejb.FinderException {
	try {
	    return this.roleGroupVOAssembler
		    .createValueObjectCollection(this.roleGroupHome.findAll());
	} catch (ValueObjectMappingException e) {
	    throw new ar.com.espumito.core.ejb.FinderException(e);
	}
    }

    /**
         * @TODO: el metodo no esta implementado.
         * @see ar.com.espumito.security.SecuritySvc#getRoles()
         */
    public Collection getRoles() throws FinderException {
	try {
	    return this.roleVOAssembler
		    .createValueObjectCollection(this.roleHome.findAll());
	} catch (ValueObjectMappingException e) {
	    throw new ar.com.espumito.core.ejb.FinderException(e);
	}
    }

    /**
         * @see ar.com.espumito.security.SecuritySvc#getUser(java.lang.String)
         */
    public UserVO getUser(String pUsername) throws FinderException {
	try {
	    return (UserVO) this.userVOAssembler
		    .createValueObject(this.userHome
			    .findUserByUsername(pUsername));
	} catch (ValueObjectMappingException e) {
	    throw new FinderException(e.getMessage());
	}
    }

    /**
         * @see ar.com.espumito.security.SecuritySvc#getUsers()
         */
    public Collection getUsers() throws FinderException {
	Collection users = this.userHome.findAll();
	try {
	    return this.userVOAssembler.createValueObjectCollection(users);
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
	UserBean user = this.userHome.findUserByUsername(pUsername);
	user.recoverPassword(pEmail);
    }


}
