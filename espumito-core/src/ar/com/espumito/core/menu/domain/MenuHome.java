package ar.com.espumito.core.menu.domain;

import java.util.Collection;
import javax.ejb.FinderException;

/**
 * <p>
 * Home interface for MenuBean
 * </p>
 * <p>
 * Date: 20-mar-2006
 * </p>
 * 
 * @author guybrush
 */
public interface MenuHome
{
    /**
     * Finds a menu by its id.
     * @param id
     * @return
     */
    public MenuBean findByPrimaryKey(Long id) throws FinderException;
    
    /**
     * Finds a menu by its name.
     * @param name
     * @return
     * @throws FinderException
     */
    public MenuBean findByName(String name) throws FinderException;
    
    /**
     * Finds all menues.
     * @return
     * @throws FinderException
     */
    public Collection findAll() throws FinderException;
}
