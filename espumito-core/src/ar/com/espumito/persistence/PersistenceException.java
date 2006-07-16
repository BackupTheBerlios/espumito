/*
 * Created on 02-mar-2005
 */
package ar.com.espumito.persistence;

public class PersistenceException extends Exception {

    public PersistenceException() {
        super();

    }

    public PersistenceException(String pMessage) {
        super(pMessage);

    }

    public PersistenceException(Throwable pCause) {
        super(pCause);

    }

    public PersistenceException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);

    }

}
