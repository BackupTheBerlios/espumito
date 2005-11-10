/*
 * Created on 12-sep-2005
 */
package ar.com.espumito.security.web;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import ar.com.espumito.security.AuthenticationException;
import ar.com.espumito.security.services.SecuritySvc;
import ar.com.espumito.security.vo.RoleGroupVO;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;

public class MockSecuritySvc implements SecuritySvc {
    private static interface ObjectFactory {
        public Object getObject(String property);
    }

    private Map roleGroups = new Hashtable();

    private Map roles = new Hashtable();

    private Map users = new Hashtable();

    public MockSecuritySvc() throws IOException {
        super();
        loadRoleGroups();
        loadRoles();
        loadUsers();
    }

    public void authenticate(String username, Object[] credentials)
            throws AuthenticationException {
    }

    public void createRole(RoleVO pVO) throws CreateException {
        roles.put(pVO.getName(), pVO);
    }

    public void editUser(UserVO pVO) throws FinderException {
        users.put(pVO.getUsername(), pVO);
    }

    private Properties getProperties(String string) throws IOException {
        InputStream is = getClass().getClassLoader()
                .getResourceAsStream(string);
        Properties p = new Properties();
        p.load(is);
        return p;
    }

    public Collection getRoleGroups() throws ar.org.blah.j2ee.FinderException {
        return roleGroups.values();
    }

    public Collection getRoles() throws FinderException {
        return roles.values();
    }

    public UserVO getUser(String pUsername) throws FinderException {
        UserVO vo = (UserVO) users.get(pUsername);
        if (vo == null)
            throw new FinderException("Could not find user " + pUsername);
        return vo;
    }

    public Collection getUsers() throws FinderException {
        return users.values();
    }

    private void loadMap(Map map, String properties, ObjectFactory factory)
            throws IOException {
        Properties p = getProperties(properties);
        for (Enumeration keys = p.keys(); keys.hasMoreElements();) {
            String key = (String) keys.nextElement();
            Object obj = factory.getObject(p.getProperty(key));
            map.put(key, obj);
        }
    }

    private void loadRoleGroups() throws IOException {
        loadMap(roleGroups, "roleGroups.properties", new ObjectFactory() {
            public Object getObject(String property) {
                StringTokenizer tokenizer = new StringTokenizer(property, ",");
                RoleGroupVO vo = new RoleGroupVO();
                vo.setId(new Long(Long.parseLong(tokenizer.nextToken())));
                vo.setName(tokenizer.nextToken());
                return vo;
            }
        });
    }

    private void loadRoles() throws IOException {
        loadMap(roles, "roles.properties", new ObjectFactory() {
            public Object getObject(String property) {
                StringTokenizer tokenizer = new StringTokenizer(property, ",");
                RoleVO vo = new RoleVO();
                vo.setId(new Long(Long.parseLong(tokenizer.nextToken())));
                vo.setName(tokenizer.nextToken());
                vo.setDescription(tokenizer.nextToken());
                while (tokenizer.hasMoreTokens()) {
                    String groupKey = tokenizer.nextToken();
                    RoleGroupVO roleGroup = (RoleGroupVO) roleGroups
                            .get(groupKey);
                    if (roleGroup != null)
                        roleGroup.addRole(vo);
                }
                return vo;
            }
        });
    }

    private void loadUsers() throws IOException {
        loadMap(users, "users.properties", new ObjectFactory() {
            private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            public Object getObject(String property) {
                StringTokenizer tokenizer = new StringTokenizer(property, ",");
                UserVO vo = new UserVO();
                vo.setUsername(tokenizer.nextToken());
                vo.setDisplayName(tokenizer.nextToken());
                vo.setEmail(tokenizer.nextToken());
                vo.setEnabled(Boolean.valueOf(tokenizer.nextToken())
                        .booleanValue());
                vo.setFirstName(tokenizer.nextToken());
                vo.setLastName(tokenizer.nextToken());
                vo.setPassword(tokenizer.nextToken());
                try {
                    vo.setRegistrationDate(formatter.parse(tokenizer
                            .nextToken()));
                } catch (ParseException e) {
                    e.printStackTrace();
                    vo.setRegistrationDate(new Date());
                }
                while (tokenizer.hasMoreTokens()) {
                    RoleVO role = (RoleVO) roles.get(tokenizer.nextToken());
                    if (role != null)
                        vo.addRole(role);
                }
                return vo;
            }
        });
    }

    public void recoverPassword(String pUsername, String pEmail)
            throws FinderException {
    }

    public void registerUser(UserVO pVO) throws CreateException {
        users.put(pVO.getUsername(), pVO);
    }

}
