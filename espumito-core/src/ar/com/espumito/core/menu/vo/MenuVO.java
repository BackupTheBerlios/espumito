package ar.com.espumito.core.menu.vo;

import java.util.Collection;
import java.util.List;
import java.util.Vector;
import ar.com.espumito.security.services.PermissionVO;
import ar.com.espumito.services.ValueObject;

public class MenuVO
    extends ValueObject
{

    public Long         id;
    public String       name;
    public PermissionVO permissions;
    public String       titleKey;
    public List items = new Vector();

    public MenuVO()
    {
        super();
    }

    /**
     * @return Returns the id.
     */
    public Long getId()
    {
        return this.id;
    }
    
    public void addItem(MenuItemVO item)
    {
        this.items.add(item);
    }
    
    public void addItems(Collection items)
    {
        this.items.addAll(items);
    }
    
    public List getItems()
    {
        return this.items;
    }

    /**
     * @return Returns the name.
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @return Returns the permissions.
     */
    public PermissionVO getPermissions()
    {
        return this.permissions;
    }

    /**
     * @return Returns the titleKey.
     */
    public String getTitleKey()
    {
        return this.titleKey;
    }

    /**
     * @param id
     *            The id to set.
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @param permissions
     *            The permissions to set.
     */
    public void setPermissions(PermissionVO permissions)
    {
        this.permissions = permissions;
    }

    /**
     * @param titleKey
     *            The titleKey to set.
     */
    public void setTitleKey(String titleKey)
    {
        this.titleKey = titleKey;
    }
}
