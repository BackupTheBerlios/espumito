package ar.com.espumito.core.web.tags.menu;

import javax.servlet.jsp.JspException;

import ar.com.espumito.core.render.Renderer;
import ar.com.espumito.core.web.tags.DefaultTagHandler;

public class PageTopMenuTagHandler extends DefaultTagHandler {
	private static final String DEFAULT_RENDERER_ID = "ar.com.espumito.core.web.tags.menu.pageTop";

	private String beanName;

	/**
	 * @return Returns the beanName.
	 * @jsp.attribute required="true" type="java.lang.String"
	 */
	public String getBeanName() {
		return this.beanName;
	}

	/**
	 * @param beanName
	 *            The beanName to set.
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public PageTopMenuTagHandler() {
		super(new PageTopMenuRenderer(), DEFAULT_RENDERER_ID);
	}

	protected Object getModel() throws JspException {
		// TODO Auto-generated method stub
		return null;
	}

}
