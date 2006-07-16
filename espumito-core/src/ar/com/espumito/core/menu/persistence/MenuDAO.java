package ar.com.espumito.core.menu.persistence;

import ar.com.espumito.core.menu.domain.MenuBean;
import ar.com.espumito.persistence.DataAccessObject;
import ar.com.espumito.persistence.PersistenceException;


/**
 * <p>TODO: add description for MenuDAO</p>
 * <p>Date: 21-mar-2006</p>
 *
 * @author guybrush
 *
 */
public interface MenuDAO
    extends DataAccessObject
{
    public MenuBean findByName(String name) throws PersistenceException;
}
