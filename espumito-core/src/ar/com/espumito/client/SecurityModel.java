/*
 * Created on 20-feb-2005
 */
package ar.com.espumito.client;

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
        bdlg = new SecuritySvcBDlg();
    }
    private SecuritySvcBDlg bdlg;

    public void editUser(UserVO pVO)
        throws FinderException
    {
        bdlg.editUser(pVO);
    }

    public void recoverPassword(String pUsername, String pEmail)
        throws FinderException
    {
        bdlg.recoverPassword(pUsername, pEmail);
    }

    public void registerUser(UserVO pVO)
        throws CreateException
    {
        bdlg.registerUser(pVO);
    }

    public void createRole(RoleVO pVO)
        throws CreateException
    {
        bdlg.createRole(pVO);
    }

    public Collection getRoles()
        throws FinderException
    {
        return bdlg.getRoles();
    }

    public Collection getUsers()
        throws FinderException
    {
        return bdlg.getUsers();
    }

    public UserVO getUser(String pUsername)
        throws FinderException
    {
        return bdlg.getUser(pUsername);
    }
}
