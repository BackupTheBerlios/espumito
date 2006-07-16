package ar.com.espumito.core.web.tags.menu;

import java.net.MalformedURLException;
import java.util.Iterator;
import javax.ejb.FinderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import org.apache.struts.taglib.TagUtils;
import ar.com.espumito.core.menu.client.MenuServiceBDlg;
import ar.com.espumito.core.menu.services.MenuService;
import ar.com.espumito.core.menu.vo.MenuItemVO;
import ar.com.espumito.core.menu.vo.MenuVO;
import ar.com.espumito.core.render.RendererConfiguration;
import ar.com.espumito.core.web.tags.DefaultTagHandler;
import ar.com.espumito.core.web.tags.HtmlAttributes;

/**
 * @author guybrush
 * @jsp.tag name="menu"
 * 
 */
public class MenuTagHandler extends DefaultTagHandler {
	private static final String DEFAULT_RENDERER_ID = "ar.com.espumito.core.menu.tags.menu.default";

	private String bundle;

	private String cssClass;

	private String cssStyle;

	private String id;

	private String localeKey;

	private String name;

	private String scope;

	public MenuTagHandler() {
		super(new DefaultMenuRenderer(), DEFAULT_RENDERER_ID);
	}

	/**
	 * @return
	 * @jsp.attribute required="false" type="java.lang.String"
	 */
	public String getBundle() {
		return this.bundle;
	}

	/**
	 * @return
	 * @jsp.attribute required="false" type="java.lang.String"
	 */
	public String getCssClass() {
		return this.cssClass;
	}

	/**
	 * @return
	 * @jsp.attribute required="false" type="java.lang.String"
	 */
	public String getCssStyle() {
		return this.cssStyle;
	}

	/**
	 * @return
	 * @jsp.attribute required="false" type="java.lang.String"
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @return
	 * @jsp.attribute required="false" type="java.lang.String"
	 */
	public String getLocaleKey() {
		return this.localeKey;
	}

	/**
	 * @return
	 * @jsp.attribute required="true" type="java.lang.String"
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return
	 * @jsp.attribute required="false" type="java.lang.String"
	 */
	public String getScope() {
		return this.scope;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public void setCssClass(String cssClazz) {
		this.cssClass = cssClazz;
	}

	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setLocaleKey(String localeKey) {
		this.localeKey = localeKey;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	protected Object getModel() throws JspException {
		HttpServletRequest request = (HttpServletRequest) this.pageContext
				.getRequest();
		MenuService menuSvc = new MenuServiceBDlg();
		MenuVO menu;
        try
        {
            menu = menuSvc.getMenuForUser(request.getUserPrincipal(),
            		getName());
            MenuVO ret = null;
            try {
                ret = transformMenu(menu);
            } catch (MalformedURLException e) {
                throw new JspException(e);
            }
            return ret;
        } catch (FinderException e1)
        {
            throw new JspException(e1);
        }
	}

	private MenuVO transformMenu(MenuVO menu) throws JspException,
			MalformedURLException {
		MenuVO ret = new MenuVO();
		String title = TagUtils.getInstance().message(this.pageContext, getBundle(),
				null, menu.getTitleKey());
		ret.setTitleKey(title);
		for (Iterator i = menu.getItems().iterator(); i.hasNext();)
			ret.addItem(transformMenuItem((MenuItemVO) i.next()));
		return ret;
	}
    
    private MenuItemVO transformMenuItem(MenuItemVO menu) throws JspException, MalformedURLException
    {
        MenuItemVO ret = new MenuItemVO();
        String title = TagUtils.getInstance().message(this.pageContext, getBundle(),
                null, menu.getTitle());
        ret.setTitle(title);
        String url = TagUtils.getInstance().computeURL(this.pageContext, null, null,
              null, menu.getUrl(), menu.getModule(), null, null, false);
        ret.setUrl(url);
        ret.setModule(menu.getModule());
        for (Iterator i = menu.getItems().iterator(); i.hasNext();)
            ret.addItem(transformMenuItem((MenuItemVO) i.next()));
        return ret;
        
    }

	protected RendererConfiguration getRendererConfig() {
		MenuTagRendererConfig rendererConfig = new MenuTagRendererConfig();
		HtmlAttributes htmlAttributes = new HtmlAttributes();
		htmlAttributes.setClazz(getCssClass());
		htmlAttributes.setStyle(getCssStyle());
		htmlAttributes.setId(getId());
		rendererConfig.setHtmlAttributes(htmlAttributes);
		rendererConfig.setBundle(getBundle());
		rendererConfig.setLocaleKey(getLocaleKey());
		return rendererConfig;
	}

}
