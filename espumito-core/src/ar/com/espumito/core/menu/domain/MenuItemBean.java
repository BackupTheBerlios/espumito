package ar.com.espumito.core.menu.domain;

import java.util.List;
import java.util.Vector;
import ar.com.espumito.security.domain.PermissionBean;
import ar.com.espumito.security.domain.RoleBean;
import ar.com.espumito.security.domain.SecurableObject;
import ar.com.espumito.security.domain.SecurableObjectHelper;
import ar.com.espumito.security.domain.SecurityObjectBean;
import ar.com.espumito.security.domain.UserBean;

/**
 * <p>
 * A menu item. Can have a list of items, or a URL that represents the action to
 * perform.
 * </p>
 * <p>
 * Date: 20-mar-2006
 * </p>
 * 
 * @author guybrush
 * @hibernate.class table="core_menu_items"
 */
public class MenuItemBean implements SecurableObject {

    private Long id;
    private List items = new Vector();
    private String moduleId;
    private SecurableObjectHelper securityHelper = new SecurableObjectHelper(
	    this);
    private SecurityObjectBean securityObject;
    private String titleKey;
    private String url;
    private int order;

    public MenuItemBean() {
	super();
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#getId()
         * @hibernate.id column="id" type="long" generator-class="increment"
         */
    public Long getId() {
	return this.id;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#getItems()
         * @hibernate.bag name="items" cascade="all" lazy="true" inverse="true"
         * @hibernate.collection-key column="parent_item_id"
         * @hibernate.collection-one-to-many class="ar.com.espumito.core.menu.domain.MenuItemBean"
         */
    public List getItems() {
	return this.items;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#getModuleId()
         * @hibernate.property column="module_id" type="string"
         */
    public String getModuleId() {
	return this.moduleId;
    }

    /**
         * @return Returns the order.
         * @hibernate.property column="order_seq" type="integer"
         */
    public int getOrder() {
	return this.order;
    }

    /**
         * @see ar.com.espumito.security.domain.SecurableObjectHelper#getPermissionForRole(ar.com.espumito.security.domain.RoleBean)
         */
    public PermissionBean getPermissionForRole(RoleBean role) {
	return this.securityHelper.getPermissionForRole(role);
    }

    /**
         * @see ar.com.espumito.security.domain.SecurableObjectHelper#getPermissionForUser(ar.com.espumito.security.domain.UserBean)
         */
    public PermissionBean getPermissionForUser(UserBean user) {
	return this.securityHelper.getPermissionForUser(user);
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#getSecurityObject()
         * @hibernate.many-to-one column="security_object_id"
         *                        class="ar.com.espumito.security.domain.SecurityObjectBean"
         */
    public SecurityObjectBean getSecurityObject() {
	return this.securityObject;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#getTitleKey()
         * @hibernate.property column="title_key" type="string"
         */
    public String getTitleKey() {
	return this.titleKey;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#getUrl()
         * @hibernate.property column="url" type="string"
         */
    public String getUrl() {
	return this.url;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#setId(java.lang.Long)
         */
    public void setId(Long id) {
	this.id = id;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#setItems(java.util.List)
         */
    public void setItems(List subitems) {
	this.items = subitems;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#setModuleId(java.lang.String)
         */
    public void setModuleId(String moduleId) {
	this.moduleId = moduleId;
    }

    /**
         * @param order
         *                The order to set.
         */
    public void setOrder(int order) {
	this.order = order;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#setSecurityObject(ar.com.espumito.security.domain.SecurityObjectBean)
         */
    public void setSecurityObject(SecurityObjectBean securityObject) {
	this.securityObject = securityObject;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#setTitleKey(java.lang.String)
         */
    public void setTitleKey(String titleKey) {
	this.titleKey = titleKey;
    }

    /**
         * @see ar.com.espumito.core.menu.domain.MenuItemBean#setUrl(java.lang.String)
         */
    public void setUrl(String url) {
	this.url = url;
    }
}
