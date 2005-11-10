package ar.com.espumito.blogs.web;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;

public class RequestWrapperFilter implements Filter {
	public static final String REQUEST_CLASS_PARAM = "requestClass";

	private Class requestClass;

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Iniciando " + getClass().getName());
		String classname = config.getInitParameter(REQUEST_CLASS_PARAM);
		if (classname != null && !classname.trim().equals(""))
		{
			try {
				requestClass = Class.forName(classname);
			} catch (ClassNotFoundException e) {
				throw new UnavailableException("Could not load class " + classname);
			}
		} 
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Aplicando " + getClass().getName());
		HttpServletRequest newRequest = (HttpServletRequest) request;
		if (requestClass != null)
			try {
				Constructor constructor = requestClass.getConstructor(new Class[] {HttpServletRequest.class});
				newRequest = (HttpServletRequest) constructor.newInstance(new Object[] {request});
			} catch (InstantiationException e) {
				throw new ServletException(e);
			} catch (IllegalAccessException e) {
				throw new ServletException(e);
			} catch (SecurityException e) {
				throw new ServletException(e);
			} catch (NoSuchMethodException e) {
				throw new ServletException(e);
			} catch (IllegalArgumentException e) {
				throw new ServletException(e);
			} catch (InvocationTargetException e) {
				throw new ServletException(e);
			}
		chain.doFilter(newRequest, response);
	}

	public void destroy() {
	}

}
