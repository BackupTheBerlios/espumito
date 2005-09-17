/*
 * Created on 14-ago-2005
 */
package ar.com.espumito.test;

public class TestClasspath {

    public TestClasspath() {
        super();

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        TestClasspath.class.getResourceAsStream("ar/com/espumito/security/domain/RoleGroupBean.hbm.xml");
    }

}
