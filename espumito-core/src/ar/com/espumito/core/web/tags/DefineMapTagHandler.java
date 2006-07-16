package ar.com.espumito.core.web.tags;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.taglib.TagUtils;

/**
 * <p>
 * A tag to create a map and expose it as a scripting variable.
 * </p>
 * <p>
 * Date: 19-mar-2006
 * </p>
 * </p>
 * 
 * @author guybrush
 * @jsp.tag name="defineMap" tei-class="ar.com.espumito.core.web.tags.DefineMapTagExtraInfo"
 */
public class DefineMapTagHandler
    extends TagSupport
{

    private String name;
    private String scope;

    /* (non-Javadoc)
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag()
        throws JspException
    {
        Map map = new HashMap();
        int scope = getScope() != null ? TagUtils.getInstance().getScope(getScope()) : PageContext.PAGE_SCOPE;
        this.pageContext.setAttribute(getName(), map, scope);
        return EVAL_BODY_INCLUDE;
    }

    /**
     * @return
     * @jsp.attribute required="true" type="java.lang.String"
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return
     * @jsp.attribute required="false" type="java.lang.String"
     */
    public String getScope()
    {
        return this.scope;
    }

    public void setName(String beanName)
    {
        this.name = beanName;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }
}
