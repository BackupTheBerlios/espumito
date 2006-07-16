package ar.com.espumito.core.menu.vo;

import java.util.List;
import java.util.Vector;
import ar.com.espumito.security.services.PermissionVO;
import ar.com.espumito.services.ValueObject;

public class MenuItemVO
    extends ValueObject
{

    private Long         id;
    private List         items = new Vector();
    private String       module;
    private PermissionVO permissions;
    private String       title;
    private String       url;

    public MenuItemVO()
    {
        super();
    }

    /**
     * @param pTitle
     * @param pUrl
     */
    public MenuItemVO(String pTitle, String pUrl)
    {
        super();
        this.title = pTitle;
        this.url = pUrl;
    }

    public MenuItemVO(String title, String url, String module)
    {
        super();
        this.module = module;
        this.title = title;
        this.url = url;
    }

    public void addItem(MenuItemVO item)
    {
        this.items.add(item);
    }

    /**
     * @return Returns the id.
     */
    public Long getId()
    {
        return this.id;
    }

    public List getItems()
    {
        return new Vector(this.items);
    }

    public String getModule()
    {
        return this.module;
    }

    /**
     * @return Returns the permissions.
     */
    public PermissionVO getPermissions()
    {
        return this.permissions;
    }

    public String getTitle()
    {
        return this.title;
    }

    public String getUrl()
    {
        return this.url;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    public void setModule(String module)
    {
        this.module = module;
    }

    /**
     * @param permissions
     *            The permissions to set.
     */
    public void setPermissions(PermissionVO permissions)
    {
        this.permissions = permissions;
    }

    public void setTitle(String pTitle)
    {
        this.title = pTitle;
    }

    public void setUrl(String pUrl)
    {
        this.url = pUrl;
    }
}
