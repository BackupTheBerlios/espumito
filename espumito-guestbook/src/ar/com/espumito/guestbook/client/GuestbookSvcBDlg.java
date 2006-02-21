// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   GuestbookSvcBDlg.java

package ar.com.espumito.guestbook.client;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;

import ar.com.espumito.guestbook.services.GuestbookEntryVO;
import ar.com.espumito.guestbook.services.GuestbookService;
import ar.com.espumito.support.spring.SpringSupport;

public class GuestbookSvcBDlg implements GuestbookService
{

    private static Logger logger = Logger.getLogger(GuestbookSvcBDlg.class);;
    private GuestbookService guestbookSvc;

    public GuestbookSvcBDlg()
    {
        logger.debug("Initializing " + getClass().getName());
        guestbookSvc = (GuestbookService) SpringSupport.getBeanFactory(
				new ClassPathResource(
				"META-INF/espumito-guestbook-client-spring.xml")).getBean("guestbookSvc");
    }

	public GuestbookEntryVO create(GuestbookEntryVO guestbookEntry) throws ar.org.blah.j2ee.CreateException {
		return guestbookSvc.create(guestbookEntry);
	}

	public Collection findAll() throws ar.org.blah.j2ee.FinderException {
		return guestbookSvc.findAll();
	}



}
