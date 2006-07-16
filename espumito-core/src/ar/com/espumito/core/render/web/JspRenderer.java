package ar.com.espumito.core.render.web;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import ar.com.espumito.core.render.AbstractRenderer;
import ar.com.espumito.core.render.RenderException;
import ar.com.espumito.core.render.RendererConfiguration;
import ar.com.espumito.core.web.HttpServletResponseWrapper;

public class JspRenderer extends AbstractRenderer {
	private String jsp;
	private String beanName;

	public JspRenderer(String jsp, String beanName) {
		super();
		// TODO Auto-generated constructor stub
		this.jsp = jsp;
		this.beanName = beanName;
	}

	public JspRenderer() {
		super();
	}

	/**
	 * @return Returns the jsp.
	 */
	public String getJsp() {
		return this.jsp;
	}

	/**
	 * @see ar.com.espumito.core.render.AbstractRenderer#render(java.lang.Object,
	 *      java.io.Writer, ar.com.espumito.core.render.RendererConfiguration)
	 */
	public void render(Object model, Writer writer, RendererConfiguration config)
			throws RenderException {
		JspRendererConfiguration configuration = (JspRendererConfiguration) config;
		PageContext pageContext = configuration.getPageContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		request.setAttribute(this.beanName, model);
		try {
			pageContext.include(this.jsp);
		} catch (ServletException e) {
			throw new RenderException(e);
		} catch (IOException e) {
			throw new RenderException(e);
		}

	}

	/**
	 * @param jsp
	 *            The jsp to set.
	 */
	public void setJsp(String jsp) {
		this.jsp = jsp;
	}

}
