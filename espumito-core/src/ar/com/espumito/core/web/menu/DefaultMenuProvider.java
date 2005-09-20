package ar.com.espumito.core.web.menu;

import javax.servlet.http.HttpServletRequest;

public abstract class DefaultMenuProvider
    implements MenuProvider
{
    public static final String ATTR_MENU = "attr.menu";
    private String attrKey = ATTR_MENU;
    private String menuKey = ATTR_MENU;

    public DefaultMenuProvider()
    {
        super();
    }

    /**
     * @param pKey
     */
    public DefaultMenuProvider(String pKey)
    {
        super();
        attrKey = pKey;
    }

    /**
     * @param pKey
     * @param pKey2
     */
    public DefaultMenuProvider(String pKey, String pKey2)
    {
        super();
        attrKey = pKey;
        menuKey = pKey2;
    }

    public Menu getMenu(HttpServletRequest pRequest)
    {
        Menu menu = (Menu) pRequest.getSession().getServletContext().getAttribute(attrKey);
        if (menu == null)
            menu = createMenu(pRequest);
        return menu;
    }

    public String getMenuKey()
    {
        return menuKey;
    }

    public void setMenuKey(String pMenuKey)
    {
        menuKey = pMenuKey;
    }

    protected abstract Menu createMenu(HttpServletRequest pRequest);

    protected String getAttrKey()
    {
        return attrKey;
    }

}
