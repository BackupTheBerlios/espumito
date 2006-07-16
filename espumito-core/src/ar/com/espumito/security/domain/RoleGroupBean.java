/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ar.com.espumito.core.locator.ServiceLocatorFactory;
import ar.com.espumito.persistence.DataAccessObject;

/**
 * @author guybrush
 * @hibernate.class table = "role_groups"
 */
public class RoleGroupBean implements Set {
	private Long id;

	private String name;

	private Set roles = new HashSet();

	protected RoleGroupBean() {
		super();
	}

	public RoleGroupBean(String name) {
		this();
		setName(name);
	}

	public boolean add(Object o) {
		return this.roles.add(o);
	}

	public boolean addAll(Collection c) {
		return this.roles.addAll(c);
	}

	public void clear() {
		this.roles.clear();
	}

	public boolean contains(Object o) {
		return this.roles.contains(o);
	}

	public boolean containsAll(Collection c) {
		return this.roles.containsAll(c);
	}

	public DataAccessObject getDataAccessObject(Class aClass) {
		return (DataAccessObject) ServiceLocatorFactory.getInstance()
				.getServiceLocator().getBean("roleGroupDao");
	}

	/**
	 * @return
	 * @hibernate.id column = "id" type="long" generator-class = "increment"
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @return
	 * @hibernate.property column = "name" type = "string" not-null = "true"
	 *                     unique = "true"
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return
	 * @hibernate.set cascade = "all" table = "role_groups_roles"
	 * @hibernate.collection-many-to-many column = "role_id" class =
	 *                                    "ar.com.espumito.security.domain.RoleBean"
	 * @hibernate.collection-key column = "group_id"
	 */
	public Set getRoles() {
		return this.roles;
	}

	public boolean isEmpty() {
		return this.roles.isEmpty();
	}

	public Iterator iterator() {
		return this.roles.iterator();
	}

	public boolean remove(Object o) {
		return this.roles.remove(o);
	}

	public boolean removeAll(Collection c) {
		return this.roles.removeAll(c);
	}

	public boolean retainAll(Collection c) {
		return this.roles.retainAll(c);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRoles(Set roles) {
		this.roles = roles;
	}

	public int size() {
		return this.roles.size();
	}

	public Object[] toArray() {
		return this.roles.toArray();
	}

	public Object[] toArray(Object[] a) {
		return this.roles.toArray(a);
	}
}
