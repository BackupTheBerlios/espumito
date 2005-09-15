/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.locator;

public class ServiceNotProvidedException extends ar.org.blah.j2ee.locator.ServiceLocatorException {

    public ServiceNotProvidedException() {
        super();

    }

    public ServiceNotProvidedException(String pMessage) {
        super(pMessage);

    }

    public ServiceNotProvidedException(Throwable pCause) {
        super(pCause);

    }

    public ServiceNotProvidedException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);

    }

}
