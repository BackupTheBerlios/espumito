package ar.com.espumito.security.plugins;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import ar.com.espumito.security.domain.UserBean;
import ar.com.espumito.security.locator.MailRegistrationPluginServiceLocatorFactory;
import ar.com.espumito.security.services.AccountActivationException;
import ar.com.espumito.security.services.RegistrationException;
import ar.com.espumito.support.velocity.VelocityUtil;
import ar.com.espumito.util.StringUtil;

public class MailValidationRegistrationPlugin implements RegistrationPlugin {
    private static final String PARAM_HASH = "hash";
    private static final String DEFAULT_MAIL_TEMPLATE = "ar/com/espumito/security/plugins/confirmation.vm";

    private String template = DEFAULT_MAIL_TEMPLATE;

    private String generateHash(UserBean user) throws NoSuchAlgorithmException {
	MessageDigest md = MessageDigest.getInstance("MD5");
	md.update(user.getUsername().getBytes());
	BigInteger hash = new BigInteger(1, md.digest());
	return hash.toString(16);
    }

    private String getRegistrationMessage(UserBean user) throws Exception {
	VelocityContext context = new VelocityContext();
	context.put("user", user);
	context.put("hash", generateHash(user));
	context.put("url", "http://espumito.no-ip.org/core/security/users/activateAccount.do");
	VelocityEngine engine = VelocityUtil.getInstance().getClasspathEngine();
	Template template = engine.getTemplate(this.template);
	Writer writer = new StringWriter();
	template.merge(context, writer);
	return writer.toString();
    }

    public void userActivated(UserBean user, Properties parameters)
	    throws AccountActivationException {
	String expectedHash = null;
	try {
	    expectedHash = generateHash(user);
	} catch (NoSuchAlgorithmException e) {
	    throw new AccountActivationException("Error activating account.", e);
	}
	String receivedHash = parameters.getProperty(PARAM_HASH);
	if (expectedHash.equalsIgnoreCase(receivedHash))
	    user.setEnabled(true);
	else
	    throw new AccountActivationException(
		    "Received hash doesn't mach expected hash.");
    }

    public void userRegistered(UserBean user) throws RegistrationException {
	String messageText = null;
	try {
	    messageText = getRegistrationMessage(user);
	} catch (Exception e) {
	    throw new RegistrationException("Error generation message.", e);
	}
	try {
	    Session session = MailRegistrationPluginServiceLocatorFactory
		    .getInstance().getMailRegistrationPluginServiceLocator()
		    .getSession();
	    MimeMessage message = new MimeMessage(session);
	    message.setContent(messageText, "text/plain");
	    message.setSubject("Activacion de cuenta " + user.getUsername()
		    + " en Espumito");
	    Address destinationAddress = new InternetAddress(user.getEmail(),
		    StringUtil.isNotBlank(user.getDisplayName()) ? user
			    .getDisplayName() : user.getUsername());
	    Address senderAddress = new InternetAddress("espumito@gmail.com.",
		    "Espumito");
	    message.setFrom(senderAddress);
	    message.addRecipient(Message.RecipientType.TO, destinationAddress);
	    message.saveChanges();
	    Transport transport = session.getTransport();
	    transport.connect("espumito", "popotito");
	    transport.sendMessage(message, message.getAllRecipients());
	    transport.close();
	} catch (MessagingException e) {
	    throw new RegistrationException(e);
	} catch (UnsupportedEncodingException e) {
	    throw new RegistrationException(e);
	}
    }

    public Properties getRegistrationProperties(HttpServletRequest request) {
	Properties properties = new Properties();
	properties.setProperty(PARAM_HASH, request.getParameter(PARAM_HASH));
	return properties;
    }

}
