package ar.com.espumito.security.domain;

import ar.com.espumito.core.menu.domain.MenuItemBean;

/**
 * <p>
 * TODO: add description for OperationBean
 * </p>
 * <p>
 * Date: 03-abr-2006
 * </p>
 * 
 * @author guybrush
 * @hibernate.class table="core_operations"
 */
public class OperationBean
{

    private Long                        id;
    private String                      name;
    private String                      description;
    private MenuItemBean                menuItem;

    /**
     * @return the description
     * @hibernate.property column="description" type="string"
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * @return the id
     * @hibernate.id column="id" type="long" generator-class="native"
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * @return the menuItem
     * @hibernate.many-to-one column="menu_item_id" class="ar.com.espumito.core.menu.domain.MenuItemBean"
     */
    public MenuItemBean getMenuItem()
    {
        return this.menuItem;
    }

    /**
     * @return the name
     * @hibernate.property column="name" type="string"
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @param menuItem
     *            the menuItem to set
     */
    public void setMenuItem(MenuItemBean menuItem)
    {
        this.menuItem = menuItem;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
