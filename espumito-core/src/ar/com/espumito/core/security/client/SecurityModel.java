/*
 * Created on 20-feb-2005
 */
package ar.com.espumito.core.security.client;

import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import ar.com.espumito.security.client.SecuritySvcBDlg;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;

/**
 * @author guybrush
 */
public class SecurityModel
{
    private static SecurityModel instance = null;

    public static SecurityModel getInstance()
    {
        if (instance == null)
            instance = new SecurityModel();
        return instance;
    }

    protected SecurityModel()
    {
        this.bdlg = new SecuritySvcBDlg();
    }
    private SecuritySvcBDlg bdlg;

    public void editUser(UserVO pVO)
        throws FinderException
    {
        this.bdlg.editUser(pVO);
    }

    public void recoverPassword(String pUsername, String pEmail)
        throws FinderException
    {
        this.bdlg.recoverPassword(pUsername, pEmail);
    }

    public void createRole(RoleVO pVO)
        throws CreateException
    {
        this.bdlg.createRole(pVO);
    }

    public Collection getRoles()
        throws FinderException
    {
        return this.bdlg.getRoles();
    }

    public Collection getUsers()
        throws FinderException
    {
        return this.bdlg.getUsers();
    }

    public UserVO getUser(String pUsername)
        throws FinderException
    {
        return this.bdlg.getUser(pUsername);
    }
}
