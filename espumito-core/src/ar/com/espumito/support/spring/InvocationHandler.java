package ar.com.espumito.support.spring;


public interface InvocationHandler
    extends java.lang.reflect.InvocationHandler
{
    public void setRealObject(Object pRealObject);
}
