package ar.com.espumito.core.render.web;

import javax.servlet.jsp.PageContext;

import ar.com.espumito.core.render.RendererConfiguration;

/**
 * <p>
 * Configuration for a JSP renderer.
 * </p>
 * <p>
 * Date: 12-mar-2006
 * </p>
 * 
 * @author guybrush
 * 
 */
public class JspRendererConfiguration implements RendererConfiguration {
	private PageContext pageContext;

	public JspRendererConfiguration() {
		super();
	}

	public JspRendererConfiguration(PageContext pageContext) {
		super();
		this.pageContext = pageContext;
	}

	/**
	 * @return Returns the pageContext.
	 */
	public PageContext getPageContext() {
		return this.pageContext;
	}

	/**
	 * @param pageContext
	 *            The pageContext to set.
	 */
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

}
