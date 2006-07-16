package ar.com.espumito.plugins.domain;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.plugins.persistence.SocketDAO;

public class SocketHomeImpl implements SocketHome {
	private SocketDAO socketDAO;

	public SocketHomeImpl(SocketDAO socketDAO) {
		super();
		this.socketDAO = socketDAO;
	}

	public SocketBean createMultiSocket(String name, String description,
			Class expectedClass) throws CreateException {
		SimpleSocketBean socket = new SimpleSocketBean(name, description,
				expectedClass);
		try {
			return (SimpleSocketBean) this.socketDAO.save(socket);
		} catch (PersistenceException e) {
			throw new ar.com.espumito.core.ejb.CreateException(
					"Could not create simple socket.", e);
		}
	}

	public SocketBean createSimpleSocket(String name, String description,
			Class expectedClass) throws CreateException {
		MultiSocketBean socket = new MultiSocketBean(name, description,
				expectedClass);
		try {
			return (MultiSocketBean) this.socketDAO.save(socket);
		} catch (PersistenceException e) {
			throw new ar.com.espumito.core.ejb.CreateException(
					"Could not create multi socket.", e);
		}
	}

	public SocketBean findSocketByName(String name) throws FinderException {
		try {
			return (SocketBean) this.socketDAO.findByName(name);
		} catch (PersistenceException e) {
			throw new ar.com.espumito.core.ejb.FinderException("Could not find socket " + name, e);
		}
	}

}
