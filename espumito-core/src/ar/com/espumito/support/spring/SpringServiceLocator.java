package ar.com.espumito.support.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.Resource;


public class SpringServiceLocator
{
    private BeanFactory beanFactory;
    
    public SpringServiceLocator(Resource resource)
    {
        super();
        this.beanFactory = new XmlBeanFactory(resource);
    }

    
    /**
     * @return Returns the beanFactory.
     */
    protected BeanFactory getBeanFactory()
    {
        return this.beanFactory;
    }
    
    /**
     * @param name
     * @return
     */
    protected Object getBean(String name)
    {
        return this.beanFactory.getBean(name);
    }
}
