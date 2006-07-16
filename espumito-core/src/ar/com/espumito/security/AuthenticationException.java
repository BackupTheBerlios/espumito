/*
 * Created on 13-may-2005
 */
package ar.com.espumito.security;

import java.security.GeneralSecurityException;

public class AuthenticationException extends GeneralSecurityException {

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(String msg) {
        super(msg);
    }

    public AuthenticationException(Throwable cause) {
        super();
        this.initCause(cause);
    }

    public AuthenticationException(String msg, Throwable cause) {
        super(msg);
        this.initCause(cause);
    }

}
