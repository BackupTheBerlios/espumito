/*
 * Created on 28-may-2005
 */
package ar.org.blah.j2ee;

public class CreateException extends javax.ejb.CreateException {

    public CreateException() {
        super();
    }

    public CreateException(String msg) {
        super(msg);
    }

    public CreateException(Throwable cause) {
        super();
        this.initCause(cause);
    }

    public CreateException(String msg, Throwable cause) {
        super(msg);
        this.initCause(cause);
    }

}
