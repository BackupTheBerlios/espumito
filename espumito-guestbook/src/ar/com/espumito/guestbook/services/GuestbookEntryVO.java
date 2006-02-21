// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   GuestbookEntryVO.java

package ar.com.espumito.guestbook.services;

import java.util.Date;

import ar.org.blah.j2ee.vo.ValueObject;

public class GuestbookEntryVO extends ValueObject
{

    private String comment;
    private Date date;
    private String email;
    private Long id;
    private String name;

    public GuestbookEntryVO()
    {
    }

    public GuestbookEntryVO(Long pId, String pName, String pEmail, String pComment, Date pDate)
    {
        id = pId;
        name = pName;
        email = pEmail;
        comment = pComment;
        date = pDate;
    }

    public GuestbookEntryVO(String pName, String pEmail, String pComment, Date pDate)
    {
        name = pName;
        email = pEmail;
        comment = pComment;
        date = pDate;
    }

    public String getComment()
    {
        return comment;
    }

    public Date getDate()
    {
        return date;
    }

    public String getEmail()
    {
        return email;
    }

    public Long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public void setComment(String pComment)
    {
        comment = pComment;
    }

    public void setDate(Date pDate)
    {
        date = pDate;
    }

    public void setEmail(String pEmail)
    {
        email = pEmail;
    }

    public void setId(Long pId)
    {
        id = pId;
    }

    public void setName(String pName)
    {
        name = pName;
    }
}
