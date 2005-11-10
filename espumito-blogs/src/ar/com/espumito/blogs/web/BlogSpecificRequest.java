package ar.com.espumito.blogs.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import ar.com.espumito.blogs.model.BlogModel;

public class BlogSpecificRequest extends HttpServletRequestWrapper {

	public BlogSpecificRequest(HttpServletRequest request) {
		super(request);
	}

	public BlogModel getBlogModel() {
		return (BlogModel) getSession(true).getAttribute(Symbols.ATTR_BLOG_MODEL);
	}

	public boolean isBlogModelAvailable() {
		return getBlogModel() != null;
	}

	public void setBlogModel(BlogModel model) {
		getSession(true).setAttribute(Symbols.ATTR_BLOG_MODEL, model);
	}

}
