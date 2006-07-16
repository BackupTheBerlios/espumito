/*
 * Created on 28-may-2005
 */
package ar.com.espumito.core.ejb;

public class FinderException extends javax.ejb.FinderException {

    public FinderException() {
        super();
    }

    public FinderException(String msg) {
        super(msg);
    }

    public FinderException(Throwable cause) {
        super();
        this.initCause(cause);
    }

    public FinderException(String msg, Throwable cause) {
        super(msg);
        this.initCause(cause);
    }

}
