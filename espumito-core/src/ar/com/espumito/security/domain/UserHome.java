/*
 * Created on 13-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Set;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface UserHome {
	public UserBean create(String username, String email, String password,
			boolean enabled) throws CreateException;

	/**
	 * Encuentra todos los usuarios.
	 * 
	 * @return
	 * @throws ar.com.espumito.core.ejb.FinderException
	 */
	public Set findAll() throws ar.com.espumito.core.ejb.FinderException;

	/**
	 * Finds a user by its username.
	 * 
	 * @param username
	 * @return
	 * @throws FinderException
	 */
	public UserBean findUserByUsername(String username) throws FinderException;
}
