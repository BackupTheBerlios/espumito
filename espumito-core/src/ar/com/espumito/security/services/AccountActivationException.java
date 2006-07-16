package ar.com.espumito.security.services;

public class AccountActivationException extends Exception {

    public AccountActivationException() {
	super();
    }

    public AccountActivationException(String message) {
	super(message);
    }

    public AccountActivationException(String message, Throwable cause) {
	super(message, cause);
    }

    public AccountActivationException(Throwable cause) {
	super(cause);
    }

}
