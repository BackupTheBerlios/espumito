/*
 * Created on 14-ago-2005
 */
package ar.com.espumito.test.spring;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.FinderException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import ar.com.espumito.security.services.SecuritySvc;
import ar.com.espumito.security.vo.RoleVO;
import ar.com.espumito.security.vo.UserVO;

public class TestSpring {

    public TestSpring() {
        super();

    }

    public static void main(String[] args) {
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.addAppender(new ConsoleAppender(new SimpleLayout()));
        rootLogger.setLevel(Level.DEBUG);
        XmlBeanFactory bf = new XmlBeanFactory(new FileSystemResource(
                "./bin/META-INF/espumito-core-spring-test.xml"));
        SecuritySvc security = (SecuritySvc) bf.getBean("securitySvc");
        try {
            Collection c = security.getUsers();
            for (Iterator i = c.iterator(); i.hasNext();)
            {
                UserVO user = (UserVO) i.next();
                System.out.println("User: " + user.getDisplayName());
                System.out.println("    Roles:");
                for (Iterator r = user.getRoles().iterator(); r.hasNext(); )
                {
                    System.out.println("        " + ((RoleVO) r.next()).getDescription());
                }
            }
        } catch (FinderException e) {
            e.printStackTrace();
        }
    }

}
