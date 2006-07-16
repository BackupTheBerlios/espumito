/*
 * Created on 13-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.security.persistence.UserDAO;

public class UserHomeImpl implements UserHome {

	private UserDAO dao;

	public UserHomeImpl() {
		super();
	}

	public UserBean create(String username, String email, String password,
			boolean enabled) throws CreateException {
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		user.setEnabled(enabled);
		user.setRegistrationDate(new Date());
		try {
			return (UserBean) this.dao.save(user);
		} catch (PersistenceException e) {
			throw new ar.com.espumito.core.ejb.CreateException(
					"Could not create user.", e);
		}
	}

	/**
	 * @return
	 * @throws ar.com.espumito.core.ejb.FinderException
	 */
	public Set findAll() throws ar.com.espumito.core.ejb.FinderException {
		try {
			return new HashSet(this.dao.findAll());
		} catch (PersistenceException e) {
			throw new ar.com.espumito.core.ejb.FinderException(e);
		}
	}

	/**
	 * @see ar.com.espumito.security.UserHome#findUserByUsername(java.lang.String)
	 */
	public UserBean findUserByUsername(String username) throws FinderException {
		if (username == null)
			throw new ObjectNotFoundException();
		try {
			UserBean user = this.dao.findByUsername(username);
			if (user == null)
			    throw new ObjectNotFoundException();
			else
			    return user;
		} catch (PersistenceException e) {
			throw new FinderException(e.getMessage());
		}
	}

	public void setDao(UserDAO dao) {
		this.dao = dao;
	}

}
