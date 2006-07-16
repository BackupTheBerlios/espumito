package ar.com.espumito.plugins.persistence;

import java.util.Collection;

import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.plugins.domain.MultiSocketBean;
import ar.com.espumito.plugins.domain.SimpleSocketBean;
import ar.com.espumito.plugins.domain.SocketBean;

public interface SocketDAO extends DataAccessObject {
	public Collection<MultiSocketBean> findAllMultiSockets()
			throws PersistenceException;

	public Collection<SimpleSocketBean> findAllSimpleSockets()
			throws PersistenceException;

	public SocketBean findByName(String name) throws PersistenceException;

}
