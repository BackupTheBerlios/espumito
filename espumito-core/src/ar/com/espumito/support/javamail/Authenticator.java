package ar.com.espumito.support.javamail;

import javax.mail.PasswordAuthentication;

public class Authenticator extends javax.mail.Authenticator {
    private String username;

    private String password;
    public Authenticator() {
	super();
    }

    public Authenticator(String username, String password) {
	super();
	this.username = username;
	this.password = password;
    }

    public String getPassword() {
	return this.password;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(this.username, this.password);
    }

    public String getUsername() {
	return this.username;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setUsername(String username) {
	this.username = username;
    }

}
