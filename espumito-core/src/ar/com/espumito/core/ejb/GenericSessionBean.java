package ar.com.espumito.core.ejb;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.log4j.Logger;

/**
 * Superclase de los Session EJB.
 * 
 * 02/08/2004
 * 
 * @author Martin Straus
 */

public class GenericSessionBean implements SessionBean {
    protected static Logger logger = Logger.getLogger(GenericSessionBean.class);

    protected SessionContext context = null;

    /**
     * Constructor default
     */
    public GenericSessionBean() {
        super();
    }

    /**
     * @param pContext
     * @throws javax.ejb.EJBException
     * @throws java.rmi.RemoteException
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext pContext) throws EJBException {
        logger.debug(getClass().getName() + ".setSessionContext()");
        this.context = pContext;
    }

    /**
     * @throws javax.ejb.EJBException
     * @throws java.rmi.RemoteException
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() throws EJBException {
        logger.debug(getClass().getName() + ".ejbRemove()");
    }

    /**
     * @throws javax.ejb.EJBException
     * @throws java.rmi.RemoteException
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() throws EJBException {
        logger.debug(getClass().getName() + ".ejbActivate()");
        myActivate();
    }

    /**
     * @throws javax.ejb.EJBException
     * @throws java.rmi.RemoteException
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() throws EJBException {
        logger.debug(getClass().getName() + ".ejbPassivate()");
    }

    /**
     * 
     * @throws CreateException
     * @throws EJBException
     */
    public void ejbCreate() throws CreateException, EJBException {
        myActivate();
    }

    /**
     * Este m�todo se llama al despu�s de <code>ejbCreate</code> y
     * <code>ejbPassivate</code>
     * 
     * @throws EJBException
     */
    protected void myActivate() throws EJBException {
        logger.debug(getClass().getName() + ".myActivate()");
    }
}
