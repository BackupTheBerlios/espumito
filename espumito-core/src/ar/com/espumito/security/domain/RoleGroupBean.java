/*
 * Created on 14-may-2005
 */
package ar.com.espumito.security.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ar.com.espumito.support.spring.SpringSupport;
import ar.org.blah.j2ee.domain.PersistentClass;
import ar.org.blah.j2ee.domain.PersistentClassImpl;
import ar.org.blah.j2ee.persistence.DataAccessObject;
import ar.org.blah.j2ee.persistence.DataAccessObjectFactory;

/**
 * @author guybrush
 * @hibernate.class table = "role_groups"
 */
public class RoleGroupBean extends PersistentClassImpl implements
        Set, PersistentClass, DataAccessObjectFactory {
    private Long id;

    private String name;

    private Set roles = new HashSet();

    protected RoleGroupBean() {
        super();
        setDaoFactory(this);
    }

    public RoleGroupBean(String name) {
        this();
        setName(name);
    }

    public boolean add(Object o) {
        return roles.add(o);
    }

    public boolean addAll(Collection c) {
        return roles.addAll(c);
    }

    public void clear() {
        roles.clear();
    }

    public boolean contains(Object o) {
        return roles.contains(o);
    }

    public boolean containsAll(Collection c) {
        return roles.containsAll(c);
    }

    public DataAccessObject getDataAccessObject(Class aClass) {
        return (DataAccessObject) SpringSupport.getBeanFactory().getBean("roleGroupDao");
    }

    /**
     * @return
     * @hibernate.id column = "id" type="long" generator-class = "increment"
     */
    public Long getId() {
        return id;
    }

    /**
     * @return
     * @hibernate.property column = "name" type = "string" not-null = "true"
     *                     unique = "true"
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     * @hibernate.set cascade = "all" table = "role_groups_roles"
     * @hibernate.collection-many-to-many column = "role_id" class =
     *                                    "ar.com.espumito.security.domain.RoleBean"
     * @hibernate.collection-key column = "group_id"
     */
    public Set getRoles() {
        return roles;
    }

    public boolean isEmpty() {
        return roles.isEmpty();
    }

    public Iterator iterator() {
        return roles.iterator();
    }

    public boolean remove(Object o) {
        return roles.remove(o);
    }

    public boolean removeAll(Collection c) {
        return roles.removeAll(c);
    }

    public boolean retainAll(Collection c) {
        return roles.retainAll(c);
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
        return roles.size();
    }

    public Object[] toArray() {
        return roles.toArray();
    }

    public Object[] toArray(Object[] a) {
        return roles.toArray(a);
    }
}
