package ar.com.espumito.guestbook.services;

import ar.com.espumito.guestbook.domain.GuestbookEntryBean;
import ar.org.blah.j2ee.vo.ValueObject;
import ar.org.blah.j2ee.vo.ValueObjectAssemblerImpl;
import ar.org.blah.j2ee.vo.ValueObjectMappingException;

public class GuestbookEntryVOAssembler extends ValueObjectAssemblerImpl {

	public GuestbookEntryVOAssembler() {
		super();
	}

	public ValueObject createValueObject(Object bean) throws ValueObjectMappingException {
		GuestbookEntryVO vo = new GuestbookEntryVO();
		GuestbookEntryBean entry = (GuestbookEntryBean) bean;
		vo.setComment(entry.getComment());
		vo.setDate(entry.getDate());
		vo.setEmail(entry.getEmail());
		vo.setId(entry.getId());
		vo.setName(entry.getName());
		vo.setVersion(vo.getVersion());
		return vo;
	}

}
