package ar.com.espumito.core.menu.domain;

import java.util.HashSet;
import java.util.Set;
import ar.com.espumito.security.domain.PermissionBean;
import ar.com.espumito.security.domain.RoleBean;
import ar.com.espumito.security.domain.SecurableObject;
import ar.com.espumito.security.domain.SecurableObjectHelper;
import ar.com.espumito.security.domain.SecurityObjectBean;
import ar.com.espumito.security.domain.UserBean;

/**
 * <p>
 * Bean to store a menu.
 * </p>
 * <p>
 * Date: 20-mar-2006
 * </p>
 * 
 * @author guybrush
 * @hibernate.class table="core_menues"
 */
public class MenuBean
    implements SecurableObject
{

    private Long                  id;
    private Set                   items          = new HashSet();
    private String                name;
    private SecurableObjectHelper securityHelper = new SecurableObjectHelper(this);
    private SecurityObjectBean    securityObject;
    private String                titleKey;

    public MenuBean()
    {
        super();
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuBean#addItem(ar.com.espumito.core.menu.domain.MenuItemBean)
     */
    public void addItem(MenuItemBean item)
    {
        this.items.add(item);
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuBean#getId()
     * @hibernate.id column="id" type="long" generator-class="identity"
     */
    public Long getId()
    {
        return this.id;
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuBean#getItems()
     * @hibernate.set cascade="all" order-by="order_seq"
     * @hibernate.collection-key column="menu_id"
     * @hibernate.collection-one-to-many class="ar.com.espumito.core.menu.domain.MenuItemBean"
     */
    public Set getItems()
    {
        return this.items;
    }

    /**
     * @return Returns the name.
     * @hibernate.property column="name" type="string"
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * @see ar.com.espumito.security.domain.SecurableObjectHelper#getPermissionForRole(ar.com.espumito.security.domain.RoleBean)
     */
    public PermissionBean getPermissionForRole(RoleBean role)
    {
        return this.securityHelper.getPermissionForRole(role);
    }

    /**
     * @see ar.com.espumito.security.domain.SecurableObjectHelper#getPermissionForUser(ar.com.espumito.security.domain.UserBean)
     */
    public PermissionBean getPermissionForUser(UserBean user)
    {
        return this.securityHelper.getPermissionForUser(user);
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuBean#getSecurityObject()
     * @hibernate.many-to-one column="security_object_id" class="ar.com.espumito.security.domain.SecurityObjectBean"
     */
    public SecurityObjectBean getSecurityObject()
    {
        return this.securityObject;
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuBean#getTitleKey()
     * @hibernate.property column="titleKey" type="string"
     */
    public String getTitleKey()
    {
        return this.titleKey;
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuBean#removeItem(ar.com.espumito.core.menu.domain.MenuItemBean)
     */
    public void removeItem(MenuItemBean item)
    {
        this.items.remove(item);
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
     * @param items
     *            The items to set.
     */
    public void setItems(Set items)
    {
        this.items = items;
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
     * @see ar.com.espumito.core.menu.domain.MenuBean#setSecurityObject(ar.com.espumito.security.domain.SecurityObjectBean)
     */
    public void setSecurityObject(SecurityObjectBean securityObject)
    {
        this.securityObject = securityObject;
    }

    /**
     * @see ar.com.espumito.core.menu.domain.MenuBean#setTitleKey(java.lang.String)
     */
    public void setTitleKey(String titleKey)
    {
        this.titleKey = titleKey;
    }
}
