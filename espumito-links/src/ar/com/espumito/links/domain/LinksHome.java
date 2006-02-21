package ar.com.espumito.links.domain;

import java.util.Set;

import ar.org.blah.j2ee.CreateException;

public interface LinksHome {
	public abstract LinkBean findByPrimaryKey(Long long1);

	public abstract LinkBean create(LinkBean linkbean) throws CreateException;

	public abstract Set findAll();
}
