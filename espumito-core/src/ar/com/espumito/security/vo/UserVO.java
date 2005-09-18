/*
 * Created on 20-feb-2005
 */
package ar.com.espumito.security.vo;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import ar.org.blah.j2ee.vo.ValueObject;

/**
 * TODO Falta descripcion de
 * 
 * @author guybrush
 */
public class UserVO extends ValueObject {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(UserVO.class);

    private String displayName;

    private String email;

    private String emailCheck;

    private String firstName;

    private String lastName;

    private String password;

    private String passwordCheck;

    private Date registrationDate;

    private Collection roles;

    private String username;

    private boolean enabled;

    /**
     * Constructor
     */
    public UserVO() {
        super();
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailCheck() {
        return emailCheck;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public Collection getRoles() {
        return roles;
    }

    public boolean hasRole(String rolename) {
        Iterator roles = this.roles.iterator();
        boolean roleFound = false;
        while (roles.hasNext() && !roleFound) {
            RoleVO role = (RoleVO) roles.next();
            logger.debug("User " + username + " has role " + role.getName());
            roleFound = role.getName().equals(rolename);
            if (roleFound)
                logger.debug("Found role " + role.getName() + " for user "
                        + username);
        }
        return roleFound;
    }

    public String getUsername() {
        return username;
    }

    public void setDisplayName(String pDisplayName) {
        displayName = pDisplayName;
    }

    public void setEmail(String pEmail) {
        email = pEmail;
    }

    public void setEmailCheck(String pEmailConfirmation) {
        emailCheck = pEmailConfirmation;
    }

    public void setFirstName(String pFirstName) {
        firstName = pFirstName;
    }

    public void setLastName(String pLastName) {
        lastName = pLastName;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    public void setPasswordCheck(String pPasswordConfirmation) {
        passwordCheck = pPasswordConfirmation;
    }

    public void setRegistrationDate(Date pRegistrationDate) {
        registrationDate = pRegistrationDate;
    }

    protected void setRoles(Collection pRoles) {
        roles = pRoles;
    }
    
    public void addRole(RoleVO role)
    {
        roles.add(role);
    }

    public void setUsername(String pUsername) {
        username = pUsername;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean pEnabled) {
        enabled = pEnabled;
    }
}
