package ar.com.espumito.guestbook.domain;

import java.util.Set;

import ar.org.blah.j2ee.CreateException;
import ar.org.blah.j2ee.FinderException;

public interface GuestbookEntryHome {
	public GuestbookEntryBean create(String name, String comment, String email)
			throws CreateException;

	public GuestbookEntryBean findByPrimaryKey(Long id) throws FinderException;

	public Set findAll() throws FinderException;
}
