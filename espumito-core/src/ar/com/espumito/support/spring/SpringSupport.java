/*
 * Created on 27-ago-2005
 */
package ar.com.espumito.support.spring;

//import java.util.Hashtable;
//import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringSupport {
    //private static Map beanFactories = new Hashtable();

    public static BeanFactory getBeanFactory() {
        return getBeanFactory(new ClassPathResource(
                "META-INF/espumito-core-spring.xml"));
    }

    public static BeanFactory getBeanFactory(Resource resource) {
//        synchronized (beanFactories) {
//            BeanFactory beanFactory = (BeanFactory) beanFactories.get(resource);
//            if (beanFactory == null) {
//                beanFactory = new XmlBeanFactory(resource);
//                beanFactories.put(resource, beanFactory);
//            }
//            return beanFactory;
//         }
        return new XmlBeanFactory(resource);
    }
}
