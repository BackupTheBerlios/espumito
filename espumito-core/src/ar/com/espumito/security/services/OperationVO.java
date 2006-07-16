package ar.com.espumito.security.services;

import ar.com.espumito.core.menu.vo.MenuItemVO;
import ar.com.espumito.services.ValueObject;

public class OperationVO
    extends ValueObject
{

    private Long       id;
    private String     name;
    private String     description;
    private MenuItemVO menuItem;

    /**
     * @return the description
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * @return the id
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * @return the menuItem
     */
    public MenuItemVO getMenuItem()
    {
        return this.menuItem;
    }

    /**
     * @return the name
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
    public void setMenuItem(MenuItemVO menuItem)
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
