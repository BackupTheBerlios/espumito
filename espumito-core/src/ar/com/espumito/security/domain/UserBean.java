/*
 * Created on 20-feb-2005
 */
package ar.com.espumito.security.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.ObjectNotFoundException;

import ar.com.espumito.core.locator.ServiceLocatorFactory;
import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.security.AuthenticationException;
import ar.com.espumito.security.InvalidCredentialsException;
import ar.com.espumito.support.spring.ServiceId;
import ar.com.espumito.util.StringUtil;

/**
 * @author guybrush
 * @hibernate.class table = "users"
 */
public class UserBean {
	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(UserBean.class);

	private String displayName;

	private String email;

	private long emailVerificationId;

	private boolean emailVerified;

	private boolean enableAfterVerify;

	private boolean enabled;

	private String enabledChar;

	private String firstName;

	private Long id;

	private String lastName;

	private String password;

	private Date registrationDate;

	private Collection roles = new HashSet();

	private String username;

	/**
	 * Constructor
	 */
	public UserBean() {
		super();
	}

	/**
	 * Crea un usuario nuevo, asignandole los roles pertenecientes al grupo de
	 * roles "default". Si el grupo de roles no existe, no asigna ningun rol.
	 * 
	 * @param pUsername
	 * @param pPassword
	 * @param pPasswordConfirmation
	 * @param pEmail
	 * @param pEmailConfirmation
	 * @throws CreateException
	 * @depretated
	 */
	public UserBean(String pUsername, String pPassword,
			String pPasswordConfirmation, String pEmail,
			String pEmailConfirmation) throws CreateException {
		this();
		setUsername(pUsername);
		setPassword(pPassword, pPasswordConfirmation);
		setEmail(pEmail, pEmailConfirmation);
		setRegistrationDate(new Date());
		setEnableAfterVerify(true);
		setEnabled(true);
		setEmailVerified(false);

		try {
			RoleGroupBean roleGroup;
			RoleGroupHome roleGroupHome = (RoleGroupHomeImpl) ServiceLocatorFactory
					.getInstance().getServiceLocator().getBean(
							ServiceId.ROLE_GROUP_HOME.getId());
			roleGroup = roleGroupHome.findDefaultRoleGroup();
			logger.debug("The role group" + roleGroup.getName() + " has "
					+ this.roles.size() + " role(s). Adding roles to user "
					+ this.username + ".");
			addAllRoles(roleGroup.getRoles());
		} catch (ObjectNotFoundException e) {
			logger.warn("The role group with default roles was not found.", e);
			throw new CreateException(e.getMessage());
		} catch (FinderException e) {
			throw new CreateException(e.getMessage());
		}
	}

	/**
	 * Asigna un conjunto de roles al usuario.
	 * 
	 * @param roles
	 */
	public void addAllRoles(Collection roles) {
		getRoles().addAll(roles);
	}

	/**
	 * Asigna un rol al usuario.
	 * 
	 * @param role
	 */
	public void addRole(RoleBean role) {
		getRoles().add(role);
	}

	/**
	 * @param credentials
	 * @throws AuthenticationException
	 */
	public void authenticate(Object[] credentials)
			throws AuthenticationException {
		for (int i = 0; i < credentials.length; i++)
			if (credentials[i] instanceof String) {
				String pwd = (String) credentials[i];
				if (!pwd.equals(getPassword()))
					throw new InvalidCredentialsException();
			}
	}

	public boolean equals(Object obj) {
		return obj instanceof UserBean && equals((UserBean) obj);
	}

	public boolean equals(UserBean obj) {
		return obj != null && obj.getId() != null
				&& obj.getId().equals(this.id);
	}

	public DataAccessObject getDataAccessObject(Class aClass) {
		return (DataAccessObject) ServiceLocatorFactory.getInstance()
				.getServiceLocator().getBean("userDao");
	}

	/**
	 * @return
	 * @hibernate.property column = "display_name" type = "string"
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * @return
	 * @hibernate.property column = "email" type = "string"
	 */
	public String getEmail() {
		return this.email;
	}

	public long getEmailVerificationId() {
		return this.emailVerificationId;
	}

	/**
	 * @return
	 * @hibernate.property column = "enabled" type = "string"
	 */
	protected String getEnabledChar() {
		return this.enabledChar;
	}

	/**
	 * @return
	 * @hibernate.property column = "first_name" type = "string"
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * @return
	 * @hibernate.id column = "id" type = "long" generator-class = "increment"
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @return
	 * @hibernate.property column = "last_name" type = "string"
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * @return
	 * @hibernate.property column = "password" type = "string"
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @return
	 * @hibernate.property column = "registration_date" type = "timestamp"
	 */
	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	/**
	 * @return
	 * @hibernate.set table = "user_roles"
	 * @hibernate.collection-many-to-many column = "role_id" class =
	 *                                    "ar.com.espumito.security.domain.RoleBean"
	 * @hibernate.collection-key column = "user_id"
	 */
	public Collection getRoles() {
		return this.roles;
	}

	/**
	 * @return
	 * @hibernate.property column = "username" type = "string"
	 */
	public String getUsername() {
		return this.username;
	}

	public int hashCode() {
		return super.hashCode();
	}

	public boolean isEmailVerified() {
		return this.emailVerified;
	}

	public boolean isEnableAfterVerify() {
		return this.enableAfterVerify;
	}

	/**
	 * @return
	 */
	public boolean isEnabled() {
		return this.enabledChar.equals("T") || this.enabledChar.equals("t");
	}

	/**
	 * <p>
	 * Envia un email de recuperacion de password a la cuenta del usuario.
	 * </p>
	 * <p>
	 * Verifica que el email especificado sea el mismo que el asociado a la
	 * cuenta. La cuenta debe estar habilitada.
	 * </p>
	 * 
	 * @param pEmail
	 * @throws IllegalStateException
	 *             Si la cuenta esta dehabilitada.
	 * @throws IllegalArgumentException
	 *             Si pEmail no coincide con el email registrado.
	 */
	public void recoverPassword(String pEmail) {
		if (!isEnabled())
			throw new IllegalStateException(
					"The account must be enabled in order to recover it's password.");
		if (pEmail != null && pEmail.equals(getEmail()))
			sendPasswordRecoveryEmail();
		else
			throw new IllegalArgumentException(
					"Email does not match account's email.");
	}

	/**
	 * @param role
	 */
	public void removeRole(RoleBean role) {
		this.roles.remove(role);
	}

	/**
	 * Envia el email de verificacion de email.
	 */
	protected void sendEmailVerification() {
		System.out.println("Enviando email de confirmacion de email.");
		setEmailVerificationId((new Date()).getTime());
		// TODO: implementar.
	}

	/**
	 * Envia el email de recuperacion de password.
	 */
	protected void sendPasswordRecoveryEmail() {
		System.out.println("Enviando email de recuperacion de password.");
		// TODO: implementar.
	}

	public void setDisplayName(String pDisplayName) {
		this.displayName = pDisplayName;
	}

	public void setEmail(String pEmail) {
		this.email = pEmail;
	}

	/**
	 * Establece el email del usuario. TODO: deber�a enviar un email de
	 * confirmaci�n antes de cambiarlo efectivamente.
	 * 
	 * @param pEmail
	 * @param pEmailConfirmation
	 */
	public void setEmail(String pEmail, String pEmailConfirmation) {
		if (StringUtil.isBlank(pEmail))
			throw new IllegalArgumentException("Email cannot be blank.");
		if (!pEmail.equals(pEmailConfirmation))
			throw new IllegalArgumentException("Email does not match check.");
		this.email = pEmail;
	}

	protected void setEmailVerificationId(long pEmailVerificationId) {
		this.emailVerificationId = pEmailVerificationId;
	}

	protected void setEmailVerified(boolean pEmailVerified) {
		this.emailVerified = pEmailVerified;
	}

	protected void setEnableAfterVerify(boolean pEnableAfterVerify) {
		this.enableAfterVerify = pEnableAfterVerify;
	}

	/**
	 * Habilita o deshabilita la cuenta. En caso de deshabilitarla, impide que
	 * la cuenta se habilite al verificar el email. Tenemos que hacer esto dado
	 * que la cuenta se crea como deshabilitada, y se habilita al verificar el
	 * email.
	 * 
	 * @param pEnabled
	 */
	public void setEnabled(boolean pEnabled) {
		this.enabled = pEnabled;
		setEnabledChar(this.enabled ? "T" : "F");
		if (!pEnabled)
			setEnableAfterVerify(false);
	}

	protected void setEnabledChar(String pEnabledChar) {
		this.enabledChar = pEnabledChar;
	}

	public void setFirstName(String pFirstName) {
		this.firstName = pFirstName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLastName(String pLastName) {
		this.lastName = pLastName;
	}

	public void setPassword(String pPassword) {
		setPassword(pPassword, pPassword);
	}

	/**
	 * Cambia la clave el usuario. Verifica que no sea null y que sea igual a la
	 * confirmacion.
	 * 
	 * @param pPassword
	 * @param pPasswordConfirmation
	 * @throws IllegalArgumentException
	 *             si pPassword es null o si no coincide con la confirmacion.
	 */
	public void setPassword(String pPassword, String pPasswordConfirmation) {
		validatePassword(pPassword, pPasswordConfirmation);
		this.password = pPassword;
	}

	public void setRegistrationDate(Date pRegistrationDate) {
		this.registrationDate = pRegistrationDate;
	}

	protected void setRoles(Collection pRoles) {
		this.roles = pRoles;
	}

	public void setUsername(String pUsername) {
		this.username = pUsername;
	}

	public String toString() {
		return super.toString();
	}

	/**
	 * @param pPassword
	 * @param pPasswordCheck
	 */
	private void validatePassword(String pPassword, String pPasswordCheck) {
		if (StringUtil.isBlank(pPassword))
			throw new IllegalArgumentException("Password cannot be blank");
		if (StringUtil.isBlank(pPasswordCheck))
			throw new IllegalArgumentException("Password check cannot be blank");
		if (!pPassword.equals(pPasswordCheck))
			throw new IllegalArgumentException(
					"Password doesn't match password check.");
	}

	/**
	 * Verifica el email de la cuenta.
	 * 
	 * @param pVerificationID
	 */
	protected void verifyEmail(long pVerificationID) {
		if (!isEmailVerified() && (pVerificationID == getEmailVerificationId())) {
			setEmailVerified(true);
			if (!isEnabled() && isEnableAfterVerify())
				setEnabled(true);
		}
	}

}
