/*
 * Created on 21-feb-2005
 */
package ar.com.espumito.security.domain;

import ar.com.espumito.core.locator.ServiceLocatorFactory;
import ar.com.espumito.persistence.DataAccessObject;

/**
 * @author guybrush
 * @hibernate.class table = "roles"
 */
public class RoleBean {

	private String description;

	private Long id;

	private String name;

	/**
	 * Constructor
	 */
	protected RoleBean() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param pName
	 * @param pGroup
	 */
	public RoleBean(String pName) {
		this();
		setName(pName);
	}

	public RoleBean(String name, String description) {
		super();
		setName(name);
		setDescription(description);
	}

	public boolean equals(Object obj) {
		return obj instanceof RoleBean && equals((RoleBean) obj);
	}

	public boolean equals(RoleBean obj) {
		return obj != null && obj.getId() != null
				&& obj.getId().equals(this.id);
	}

	public DataAccessObject getDataAccessObject(Class aClass) {
		return (DataAccessObject) ServiceLocatorFactory.getInstance()
				.getServiceLocator().getBean("roleDao");
	}

	/**
	 * @return
	 * @hibernate.property column = "description" type = "string"
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @return
	 * @hibernate.id column = "id" type = "long" generator-class = "increment"
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @return
	 * @hibernate.property column = "name" type = "string"
	 */
	public String getName() {
		return this.name;
	}

	public int hashCode() {
		return this.id != null ? this.id.hashCode() : 0;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	protected void setId(Long pId) {
		this.id = pId;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public String toString() {
		return "[Role: " + this.name + " (id =" + this.id + ")]";
	}

}
