/*
 * Created on 02-mar-2005
 */
package ar.com.espumito.services;

public class ServiceException extends Exception {

    public ServiceException() {
        super();

    }

    public ServiceException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);

    }

    public ServiceException(String pMessage) {
        super(pMessage);

    }

    public ServiceException(Throwable pCause) {
        super(pCause);

    }

}
