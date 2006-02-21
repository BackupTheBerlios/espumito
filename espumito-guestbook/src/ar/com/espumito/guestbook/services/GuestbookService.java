// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   GuestbookService.java

package ar.com.espumito.guestbook.services;

import java.util.Collection;

import ar.org.blah.j2ee.CreateException;
import ar.org.blah.j2ee.FinderException;

public interface GuestbookService
{

    public GuestbookEntryVO create(GuestbookEntryVO guestbookEntry)
        throws CreateException;

    public Collection findAll()
        throws FinderException;
}
