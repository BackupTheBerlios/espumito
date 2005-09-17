/*
 * Created on 04-mar-2005
 */
package ar.org.blah.j2ee.test;

import junit.framework.TestCase;
import ar.org.blah.j2ee.locator.ServiceLocator;
import ar.org.blah.j2ee.locator.ServiceLocatorException;
import ar.org.blah.j2ee.locator.ServiceLocatorFactory;
import ar.org.blah.j2ee.persistence.DataAccessObject;

public class TestServiceLocatorFactory extends TestCase {

    public void testCreateServiceLocator() {
        ServiceLocator sl = null;
        try {
            sl = ServiceLocatorFactory.getInstance().createServiceLocator();
        } catch (ServiceLocatorException e) {
            e.printStackTrace();
        }
        if (sl == null)
            fail();
        else
            System.out.println("Se creo el service locator de tipo "
                    + sl.getClass().getName());
    }

    public void testCreateDataAccessObject() {
        ServiceLocator sl = null;
        try {
            sl = ServiceLocatorFactory.getInstance().createServiceLocator();
        } catch (ServiceLocatorException e) {
            fail();
        }
        try {
            DataAccessObject dao = sl.getDataAccessObject(null);
            if (dao != null)
                System.out.println("Se creó el DAO de tipo "
                        + dao.getClass().getName());
            else
                fail();
        } catch (Exception e) {
            fail();
        }
    }

}
