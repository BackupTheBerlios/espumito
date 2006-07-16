/*
 * Created on 20-feb-2005
 */
package ar.com.espumito.security.vo;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import ar.com.espumito.services.ValueObject;

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

    private Collection roles = new HashSet();

    private String username;

    private boolean enabled;

    /**
     * Constructor
     */
    public UserVO() {
        super();
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEmailCheck() {
        return this.emailCheck;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPasswordCheck() {
        return this.passwordCheck;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public Collection getRoles() {
        return this.roles;
    }

    public boolean hasRole(String rolename) {
        Iterator roles = this.roles.iterator();
        boolean roleFound = false;
        while (roles.hasNext() && !roleFound) {
            RoleVO role = (RoleVO) roles.next();
            logger.debug("User " + this.username + " has role " + role.getName());
            roleFound = role.getName().equals(rolename);
            if (roleFound)
                logger.debug("Found role " + role.getName() + " for user "
                        + this.username);
        }
        return roleFound;
    }

    public String getUsername() {
        return this.username;
    }

    public void setDisplayName(String pDisplayName) {
        this.displayName = pDisplayName;
    }

    public void setEmail(String pEmail) {
        this.email = pEmail;
    }

    public void setEmailCheck(String pEmailConfirmation) {
        this.emailCheck = pEmailConfirmation;
    }

    public void setFirstName(String pFirstName) {
        this.firstName = pFirstName;
    }

    public void setLastName(String pLastName) {
        this.lastName = pLastName;
    }

    public void setPassword(String pPassword) {
        this.password = pPassword;
    }

    public void setPasswordCheck(String pPasswordConfirmation) {
        this.passwordCheck = pPasswordConfirmation;
    }

    public void setRegistrationDate(Date pRegistrationDate) {
        this.registrationDate = pRegistrationDate;
    }

    protected void setRoles(Collection pRoles) {
        this.roles = pRoles;
    }
    
    public void addRole(RoleVO role)
    {
        this.roles.add(role);
    }

    public void setUsername(String pUsername) {
        this.username = pUsername;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean pEnabled) {
        this.enabled = pEnabled;
    }
}
