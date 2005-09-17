/*
 * Created on 14-may-2005
 */
package ar.org.blah.j2ee.domain;

import ar.org.blah.j2ee.persistence.PersistenceException;

public interface PersistentClass {

    public abstract Object save() throws PersistenceException;

    public abstract void update() throws PersistenceException;

    public abstract void delete() throws PersistenceException;

}