/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.locator;


public class ServiceNotAvailableException extends ServiceLocatorException {

    public ServiceNotAvailableException() {
        super();

    }

    public ServiceNotAvailableException(String pMessage) {
        super(pMessage);

    }

    public ServiceNotAvailableException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);

    }

    public ServiceNotAvailableException(Throwable pCause) {
        super(pCause);

    }

}
