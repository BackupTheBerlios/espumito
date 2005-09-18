/*
 * Created on 13-may-2005
 */
package ar.com.espumito.security;

public class InvalidCredentialsException extends AuthenticationException {

    private static String INVALID_CREDENTIALS_MESSAGE = "Invalid credentials";

    public InvalidCredentialsException() {
        super(INVALID_CREDENTIALS_MESSAGE);
    }

    public InvalidCredentialsException(String msg) {
        super(msg);
    }

    public InvalidCredentialsException(Throwable cause) {
        this(INVALID_CREDENTIALS_MESSAGE, cause);
    }

    public InvalidCredentialsException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
