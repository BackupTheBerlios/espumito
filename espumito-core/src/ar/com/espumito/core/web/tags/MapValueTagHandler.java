package ar.com.espumito.core.web.tags;

import java.util.Map;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.struts.taglib.TagUtils;

/**
 * <p>
 * Tag to add a value to a map. Must be within a 'defineMap' tag.
 * </p>
 * <p>
 * Date: 19-mar-2006
 * </p>
 * </p>
 * 
 * @author guybrush
 * @jsp.tag name="mapValue"
 */
public class MapValueTagHandler
    extends TagSupport
{

    private String key;
    private String beanName;
    private String beanProperty;
    private String scope;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag()
        throws JspException
    {
        Object value = TagUtils.getInstance().lookup(this.pageContext, getBeanName(), getBeanProperty(), getScope());
        DefineMapTagHandler parent = (DefineMapTagHandler) this.getParent();
        String mapName = parent.getName();
        Map map = (Map) this.pageContext.getAttribute(mapName);
        map.put(getKey(), value);
        return SKIP_BODY;
    }

    /**
     * @return
     * @jsp.attribute required="true" type="java.lang.String"
     */
    public String getBeanName()
    {
        return this.beanName;
    }

    /**
     * @return
     * @jsp.attribute required="false" type="java.lang.String"
     */
    public String getBeanProperty()
    {
        return this.beanProperty;
    }

    /**
     * @return
     * @jsp.attribute required="true" type="java.lang.String"
     */
    public String getKey()
    {
        return this.key;
    }

    /**
     * @return
     * @jsp.attribute required="false" type="java.lang.String"
     */
    public String getScope()
    {
        return this.scope;
    }

    public void setBeanName(String beanName)
    {
        this.beanName = beanName;
    }

    public void setBeanProperty(String beanProperty)
    {
        this.beanProperty = beanProperty;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public void setScope(String scope)
    {
        this.scope = scope;
    }
}
