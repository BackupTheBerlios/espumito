/*
 * Created on 14-ago-2005
 */
package ar.com.espumito.ejb;

import ar.com.espumito.support.spring.SpringSupport;
import ar.org.blah.j2ee.GenericSessionBean;

public class AbstractSessionBean extends GenericSessionBean {

    public AbstractSessionBean() {
        super();
    }
    
    protected Object getService(String name) {
        return SpringSupport.getBeanFactory().getBean(name);
    }
}
