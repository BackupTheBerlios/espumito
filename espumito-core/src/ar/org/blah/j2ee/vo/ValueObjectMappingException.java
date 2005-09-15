/*
 * Created on 02-mar-2005
 */
package ar.org.blah.j2ee.vo;

import ar.org.blah.j2ee.services.ServiceException;

public class ValueObjectMappingException extends ServiceException {

    public ValueObjectMappingException() {
        super();

    }

    public ValueObjectMappingException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);

    }

    public ValueObjectMappingException(String pMessage) {
        super(pMessage);

    }

    public ValueObjectMappingException(Throwable pCause) {
        super(pCause);

    }

}
