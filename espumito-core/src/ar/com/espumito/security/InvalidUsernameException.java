/*
 * Created on 13-may-2005
 */
package ar.com.espumito.security;

public class InvalidUsernameException extends AuthenticationException {
    private static String INVALID_USERNAME_MESSAGE = "Invalid username";
    
    public InvalidUsernameException() {
        super(INVALID_USERNAME_MESSAGE);
    }

    public InvalidUsernameException(String msg) {
        super(msg);
    }

    public InvalidUsernameException(Throwable cause) {
        this(INVALID_USERNAME_MESSAGE, cause);
    }

    public InvalidUsernameException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
