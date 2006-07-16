package ar.com.espumito.core.web.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;
import org.apache.struts.taglib.TagUtils;
import ar.com.espumito.util.StringUtil;

/**
 * <p>
 * Extra info for 'defineMap' tag.
 * </p>
 * <p>
 * Date: 19-mar-2006
 * </p>
 * </p>
 * 
 * @author guybrush
 */
public class DefineMapTagExtraInfo
    extends TagExtraInfo
{

    public VariableInfo[] getVariableInfo(TagData tagData)
    {
        String name = (String) tagData.getAttribute("name");
        String scopeName = (String) tagData.getAttribute("scope");
        int scope;
        try
        {
            scope = StringUtil.isBlank(scopeName) ? PageContext.PAGE_SCOPE : TagUtils.getInstance().getScope(scopeName);
        } catch (JspException e)
        {
            scope = PageContext.PAGE_SCOPE;
        }
        return new VariableInfo[] { new VariableInfo(name, "java.util.Map", true, scope) };
    }
}
