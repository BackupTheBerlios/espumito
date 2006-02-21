// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   GuestbookEntryBean.java

package ar.com.espumito.guestbook.domain;

import java.util.Date;

import ar.com.espumito.util.StringUtil;
import ar.org.blah.j2ee.domain.PersistentClassImpl;

public class GuestbookEntryBean extends PersistentClassImpl
{

    private Long id;
    private String name;
    private String email;
    private String comment;
    private Date date;

    protected GuestbookEntryBean()
    {
        setDate(new Date());
    }

    public GuestbookEntryBean(String pName, String pEmail, String pComment, Date pDate)
    {
        name = pName;
        email = pEmail;
        comment = pComment;
        date = pDate;
    }

    public GuestbookEntryBean(String pName, String pEmail, String pComment)
    {
        setName(pName);
        setEmail(pEmail);
        setComment(pComment);
        setDate(new Date());
    }

    public Long getId()
    {
        return id;
    }

    protected void setId(Long pId)
    {
        id = pId;
    }

    public String getName()
    {
        return name;
    }

    protected void setName(String pName)
    {
        name = pName;
    }

    public String getEmail()
    {
        return email;
    }

    protected void setEmail(String pEmail)
    {
        email = pEmail;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String pComment)
    {
        comment = StringUtil.convertToNormalFormat(pComment);
    }

    public Date getDate()
    {
        return date;
    }

    protected void setDate(Date pDate)
    {
        date = pDate;
    }
}
