package ar.com.espumito.core.web;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;

import org.apache.struts.taglib.tiles.ComponentConstants;

import ar.com.espumito.util.StringUtil;

public class TagUtils {
	public static void setAttributeInScope(String name, Object value,
			String scope, PageContext pageContext) throws JspException {
		int scopeId;
		if (scope != null) {
			scopeId = org.apache.struts.taglib.TagUtils.getInstance().getScope(
					scope);
			if (scopeId != ComponentConstants.COMPONENT_SCOPE)
				pageContext.setAttribute(name, value, scopeId);
		} else
			pageContext.setAttribute(name, value);
	}
	
	public static void writeAttribute(StringBuffer buffer, String attribute, String value)
	{
		if (StringUtil.isNotBlank(value) && StringUtil.isNotBlank(attribute))
		{
			buffer.append(" ");
			buffer.append(attribute);
			buffer.append("=\"");
			buffer.append(value);
			buffer.append("\"");
		} else if (StringUtil.isNotBlank(attribute))
		{
			buffer.append(" ");
			buffer.append(attribute);
			buffer.append("=\"\"");
		}
	}
}
