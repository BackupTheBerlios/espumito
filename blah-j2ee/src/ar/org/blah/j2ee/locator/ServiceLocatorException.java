/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.locator;

public class ServiceLocatorException extends Exception {

    public ServiceLocatorException() {
        super();

    }

    public ServiceLocatorException(String pMessage) {
        super(pMessage);

    }

    public ServiceLocatorException(Throwable pCause) {
        super(pCause);

    }

    public ServiceLocatorException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);

    }

}
