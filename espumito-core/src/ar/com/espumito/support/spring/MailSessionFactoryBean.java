package ar.com.espumito.support.spring;

import java.util.Properties;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import ar.com.espumito.support.javamail.Authenticator;

public class MailSessionFactoryBean extends AbstractFactoryBean {
    private Properties properties;
    private String username;
    private String password;

    @Override
    protected Object createInstance() throws Exception {
	return javax.mail.Session.getInstance(this.properties, new Authenticator(this.username, this.password));
    }

    public Class getObjectType() {
	return javax.mail.Session.class;
    }

    public String getPassword() {
	return this.password;
    }

    public Properties getProperties() {
	return this.properties;
    }

    public String getUsername() {
	return this.username;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setProperties(Properties properties) {
	this.properties = properties;
    }

    public void setUsername(String username) {
	this.username = username;
    }

}
