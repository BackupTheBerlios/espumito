package ar.com.espumito.plugins.domain;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

public interface SocketHome {
	public SocketBean createSimpleSocket(String name, String description,
			Class clazz) throws CreateException;

	public SocketBean createMultiSocket(String name, String description,
			Class clazz) throws CreateException;
	
	public SocketBean findSocketByName(String name) throws FinderException;
}
