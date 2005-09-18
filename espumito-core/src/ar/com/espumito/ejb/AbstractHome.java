/*
 * Created on 28-may-2005
 */
package ar.com.espumito.ejb;


/**
 * Superclase de todas las implementaciones de interfaces Home.
 * 
 * @author guybrush
 */
public abstract class AbstractHome {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
            .getLogger(AbstractHome.class);
        
    /**
     * 
     */
    public AbstractHome() {
        super();
        logger.debug("Creating Home implementation of class "
                + getClass().getName());
    }
}
