package ar.com.espumito.support.spring;

import java.lang.reflect.Proxy;
import org.springframework.beans.factory.FactoryBean;

public class ProxyFactoryBean
    implements FactoryBean
{

    private Class[]           interfaces;
    private InvocationHandler invocationHandler;
    private Object            realObject;

    
    /**
     * @param realObject The realObject to set.
     */
    public void setRealObject(Object realObject)
    {
        this.realObject = realObject;
    }

    public ProxyFactoryBean()
    {
        super();
    }

    public Object getObject()
        throws Exception
    {
        this.invocationHandler.setRealObject(this.realObject);
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), this.interfaces,
                this.invocationHandler);
    }

    public Class getObjectType()
    {
        return Proxy.class;
    }

    public boolean isSingleton()
    {
        return false;
    }

    public void setInterfaces(String[] interfaces)
    {
        this.interfaces = new Class[interfaces.length];
        for (int i = 0; i < interfaces.length; i++)
            try
            {
                this.interfaces[i] = Class.forName(interfaces[i]);
            } catch (ClassNotFoundException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    /**
     * @param invocationHandler
     *            The invocationHandler to set.
     */
    public void setInvocationHandler(InvocationHandler invocationHandler)
    {
        this.invocationHandler = invocationHandler;
    }
}
