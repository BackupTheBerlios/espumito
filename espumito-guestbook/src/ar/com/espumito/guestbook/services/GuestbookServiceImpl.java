package ar.com.espumito.guestbook.services;

import java.util.Collection;

import org.apache.log4j.Logger;

import ar.com.espumito.guestbook.domain.GuestbookEntryBean;
import ar.com.espumito.guestbook.domain.GuestbookEntryHome;
import ar.org.blah.j2ee.CreateException;
import ar.org.blah.j2ee.FinderException;
import ar.org.blah.j2ee.vo.ValueObjectMappingException;

public class GuestbookServiceImpl implements GuestbookService {
	private static Logger logger = Logger.getLogger(GuestbookServiceImpl.class);

	private GuestbookEntryHome guestbookEntryHome;

	private GuestbookEntryVOAssembler guestbookEntryVOAssembler;

	public GuestbookServiceImpl() {

	}

	public GuestbookEntryVO create(GuestbookEntryVO guestbookEntry)
			throws CreateException {

		GuestbookEntryBean entry = guestbookEntryHome.create(guestbookEntry
				.getName(), guestbookEntry.getComment(), guestbookEntry
				.getEmail());
		GuestbookEntryVO vo;
		try {
			vo = (GuestbookEntryVO) guestbookEntryVOAssembler
					.createValueObject(entry);
		} catch (ValueObjectMappingException e) {
			throw new CreateException(e);
		}
		return vo;
	}

	public Collection findAll() throws FinderException {
		try {
			return guestbookEntryVOAssembler
					.createValueObjectCollection(guestbookEntryHome.findAll());
		} catch (ValueObjectMappingException e) {
			throw new FinderException(e);
		}
	}

	public GuestbookEntryHome getGuestbookEntryHome() {
		return guestbookEntryHome;
	}

	public GuestbookEntryVOAssembler getGuestbookEntryVOAssembler() {
		return guestbookEntryVOAssembler;
	}

	public void setGuestbookEntryHome(GuestbookEntryHome guestbookEntryHome) {
		this.guestbookEntryHome = guestbookEntryHome;
	}

	public void setGuestbookEntryVOAssembler(
			GuestbookEntryVOAssembler guestbookEntryVOAssembler) {
		this.guestbookEntryVOAssembler = guestbookEntryVOAssembler;
	}
}
