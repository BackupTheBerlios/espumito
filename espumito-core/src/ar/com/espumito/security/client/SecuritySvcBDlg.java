/*
 * Created on 20-feb-2005
 */
package ar.com.espumito.security.client;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;

import ar.com.espumito.client.BusinessDelegate;
import ar.com.espumito.security.AuthenticationException;
import ar.com.espumito.security.services.SecuritySvc;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;
import ar.com.espumito.support.spring.ServiceId;
import ar.com.espumito.support.spring.SpringSupport;

/**
 * @author guybrush
 */
public class SecuritySvcBDlg extends BusinessDelegate implements SecuritySvc {
    private static Logger logger = Logger.getLogger(SecuritySvcBDlg.class);

    private SecuritySvc component;

    public SecuritySvcBDlg() {
        component = (SecuritySvc) SpringSupport.getBeanFactory(
                new ClassPathResource("META-INF/espumito-core-client-spring.xml"))
                .getBean(ServiceId.SECURITY_SVC.getId());
    }

    public void editUser(UserVO pVO) throws FinderException {
            component.editUser(pVO);
    }

    public void recoverPassword(String pUsername, String pEmail)
            throws FinderException {

            component.recoverPassword(pUsername, pEmail);
    }

    public void registerUser(UserVO pVO) throws CreateException {
            component.registerUser(pVO);
    }

    public void createRole(RoleVO pVO) throws CreateException {
            component.createRole(pVO);
    }

    public Collection getRoles() throws FinderException {
            return component.getRoles();
    }

    public Collection getUsers() throws FinderException {
            return component.getUsers();
    }

    public UserVO getUser(String pUsername) throws FinderException {
            return component.getUser(pUsername);
    }

    public void authenticate(String username, Object[] credentials)
            throws AuthenticationException {
            component.authenticate(username, credentials);
    }

    public Collection getRoleGroups() throws ar.org.blah.j2ee.FinderException {
            return component.getRoleGroups();
    }
}
