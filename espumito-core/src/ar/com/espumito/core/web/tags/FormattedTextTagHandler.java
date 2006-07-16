package ar.com.espumito.core.web.tags;

import java.io.IOException;
import java.io.Writer;
import java.text.Format;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import ar.com.espumito.core.text.EspumitoTextFormat;
import ar.com.espumito.util.StringUtil;

/**
 * <p>
 * Tag handler to show a formatted text.
 * </p>
 * <p>
 * Date: 12-mar-2006
 * </p>
 * 
 * @author guybrush
 * @jsp.tag name="formattedText"
 */
public class FormattedTextTagHandler extends TagSupport {
	private String beanName;

	private String beanProperty;

	private String formatBeanName;

	private String formatBeanProperty;

	private String scope;

	public FormattedTextTagHandler() {
		super();
	}

	/**
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		Format format = getFormat();
		String text = (String) TagUtils.getInstance().lookup(this.pageContext,
				getBeanName(), getBeanProperty(), getScope());
		Writer writer = this.pageContext.getOut();
		try {
			writer.write(format.format(text));
		} catch (IOException e) {
			throw new JspException(e);
		}
		return SKIP_BODY;
	}

	/**
	 * @return Returns the beanName.
	 * @jsp.attribute required="true" type="java.lang.String"
	 */
	public String getBeanName() {
		return this.beanName;
	}

	/**
	 * @return Returns the beanProperty.
	 * @jsp.attribute required="false" type="java.lang.String"
	 */
	public String getBeanProperty() {
		return this.beanProperty;
	}

	/**
	 * @return The format to use.
	 */
	protected Format getFormat() {
		if (StringUtil.isBlank(getFormatBeanName()))
			return new EspumitoTextFormat();
		else
			try {
				Object format = TagUtils.getInstance().lookup(this.pageContext,
						getFormatBeanName(), getFormatBeanProperty(), getScope());
				Format ret = getFormat(format);
				return ret != null ? ret : new EspumitoTextFormat();
			} catch (JspException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new EspumitoTextFormat();
			}
	}

	/**
	 * @param format
	 * @return
	 */
	private Format getFormat(Object format) {
		if (format == null)
			return new EspumitoTextFormat();
		else if (format instanceof Format)
			return (Format) format;
		else if (format instanceof String)
			if (format.equals("espumito"))
				return new EspumitoTextFormat();
			else
				return new EspumitoTextFormat();
		else
			return new EspumitoTextFormat();
	}

	/**
	 * @return Returns the formatBeanName.
	 * @jsp.attribute required="false" type="java.lang.String"
	 */
	public String getFormatBeanName() {
		return this.formatBeanName;
	}

	/**
	 * @return Returns the formatBeanProperty.
	 * @jsp.attribute required="false" type="java.lang.String"
	 */
	public String getFormatBeanProperty() {
		return this.formatBeanProperty;
	}

	/**
	 * @return Returns the scope.
	 */
	public String getScope() {
		return this.scope;
	}

	/**
	 * @param beanName
	 *            The beanName to set.
	 */
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	/**
	 * @param beanProperty
	 *            The beanProperty to set.
	 */
	public void setBeanProperty(String beanProperty) {
		this.beanProperty = beanProperty;
	}

	/**
	 * @param formatBeanName
	 *            The formatBeanName to set.
	 */
	public void setFormatBeanName(String formatBeanName) {
		this.formatBeanName = formatBeanName;
	}

	/**
	 * @param formatBeanProperty
	 *            The formatBeanProperty to set.
	 */
	public void setFormatBeanProperty(String formatBeanProperty) {
		this.formatBeanProperty = formatBeanProperty;
	}

	/**
	 * @param scope
	 *            The scope to set.
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

}
