package ar.com.espumito.blogs.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ar.com.espumito.blogs.model.DefaultBlogModel;
import ar.com.espumito.blogs.vo.BlogVO;

public class TestFilter implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Iniciando " + getClass().getName());

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Aplicando " + getClass().getName());
		BlogSpecificRequest r = (BlogSpecificRequest) request;
		if (!r.isBlogModelAvailable()) {
			BlogVO vo = new BlogVO();
			vo.setAuthor("guybrush threepwood");
			vo.setName("Paseando por Meleé Island");
			r.setBlogModel(new DefaultBlogModel(vo));
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
