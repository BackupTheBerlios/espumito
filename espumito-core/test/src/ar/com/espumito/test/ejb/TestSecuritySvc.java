/*
 * Created on 27-ago-2005
 */
package ar.com.espumito.test.ejb;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import ar.com.espumito.security.services.SecuritySvcSession;
import ar.com.espumito.security.services.SecuritySvcSessionHome;
import ar.com.espumito.security.vo.RoleGroupVO;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;

public class TestSecuritySvc {
    /**
     * @param args
     */
    public static void main(String[] args) {
        new TestSecuritySvc().run();
    }

    SecuritySvcSession session = null;

    public TestSecuritySvc() {
        super();
        InputStream is = getClass().getClassLoader().getResourceAsStream(
                "jndi.properties");
        Properties p = new Properties();
        try {
            p.load(is);
            InitialContext ic = new InitialContext(p);
            Object obj = ic.lookup("ejb/ar/com/espumito/core/SecuritySvcSession");
            SecuritySvcSessionHome home = (SecuritySvcSessionHome) PortableRemoteObject
                    .narrow(obj, SecuritySvcSessionHome.class);
            session = home.create();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (CreateException e) {
            e.printStackTrace();
        }
    }

    private void run() {
        testGetRoleGroups();
        System.out.println("");
//        testRegisterUser();
//        System.out.println("");
        testGetUsers();
        System.out.println("");
        testGetRoles();
    }

    private void testGetUsers() {
        System.out.println("Listing users:");
        try {
            Collection users = session.getUsers();
            for (Iterator iter = users.iterator(); iter.hasNext();) {
                UserVO element = (UserVO) iter.next();
                System.out.println(element.getDisplayName());
            }
        } catch (FinderException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void testGetRoles() {
        System.out.println("Listion roles:");
        try {
            Collection roles = session.getRoles();
            for (Iterator iter = roles.iterator(); iter.hasNext();) {
                RoleVO role = (RoleVO) iter.next();
                System.out.println(role.getName() + " ("
                        + role.getDescription() + ")");
            }
        } catch (FinderException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void testRegisterUser() {
        System.out.println("Registering user");
        InputStream is = getClass().getClassLoader().getResourceAsStream(
                "ar/com/espumito/test/ejb/newUser.properties");
        Properties p = new Properties();
        try {
            p.load(is);
            UserVO user = new UserVO();
            user.setDisplayName(p.getProperty("displayName"));
            user.setEmail(p.getProperty("email"));
            user.setEmailCheck(p.getProperty("email"));
            user.setEnabled(Boolean.valueOf(p.getProperty("enabled"))
                    .booleanValue());
            user.setFirstName(p.getProperty("first"));
            user.setLastName(p.getProperty("last"));
            user.setPassword(p.getProperty("password"));
            user.setPasswordCheck(p.getProperty("password"));
            user.setUsername(p.getProperty("username"));
            session.registerUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CreateException e) {
            e.printStackTrace();
        }
    }

    private void testGetRoleGroups() {
        System.out.println("Getting role groups");
        try {
            Collection roleGroups = session.getRoleGroups();
            for (Iterator i = roleGroups.iterator(); i.hasNext();) {
                RoleGroupVO roleGroup = (RoleGroupVO) i.next();
                System.out.println("    " + roleGroup.getName());
            }
        } catch (ar.org.blah.j2ee.FinderException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

}
