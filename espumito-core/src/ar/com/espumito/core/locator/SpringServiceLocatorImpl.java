package ar.com.espumito.core.locator;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringServiceLocatorImpl
    implements ServiceLocator
{

    private BeanFactory beanFactory;

    public SpringServiceLocatorImpl()
    {
        super();
    }

    public Object getBean(String name)
    {
        BeanFactory beanFactory = getBeanFactory();
        Object bean = beanFactory.getBean(name);
        return bean;
    }

    protected BeanFactory getBeanFactory()
    {
        if (this.beanFactory == null)
            this.beanFactory = new XmlBeanFactory(getResource());
        return this.beanFactory;
    }
    
    protected Resource getResource()
    {
        String prop = System.getProperty("ar.com.espumito.core.locator.spring.config");
        if (prop != null)
            return new ClassPathResource(prop);
        else
            return new ClassPathResource("META-INF/espumito-beans.xml");
    }
}
