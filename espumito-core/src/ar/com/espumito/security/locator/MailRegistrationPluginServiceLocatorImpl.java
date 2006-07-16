package ar.com.espumito.security.locator;

import javax.mail.Session;

import ar.com.espumito.core.locator.ServiceLocatorFactory;

public class MailRegistrationPluginServiceLocatorImpl implements
	MailRegistrationPluginServiceLocator {

    public Session getSession() {
	return (Session) ServiceLocatorFactory.getInstance().getServiceLocator().getBean("mailRegistrationPluginSession");
    }

}
