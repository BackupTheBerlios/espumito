package ar.com.espumito.core.web.menu;

import java.util.Vector;

import org.apache.struts.tiles.beans.MenuItem;

public class DefaultMenu
    implements Menu
{
    private static final MenuItem[] template = new MenuItem[] {};
    private Vector items = new Vector();
    private String title;
                    
    public DefaultMenu()
    {
        super();
    }

    /**
     * @param pItems
     * @param pTitle
     */
    public DefaultMenu(MenuItem[] pItems, String pTitle)
    {
        super();
        addItems(pItems);
        setTitle(pTitle);
    }

    /**
     * @param pTitle
     */
    public DefaultMenu(String pTitle)
    {
        super();
        setTitle(pTitle);
    }
    
    public void addItem(MenuItem item)
    {
        items.add(item);
    }

    public void addItems(MenuItem[] items)
    {
        for (int i = 0; i < items.length; i++)
            this.items.add(items[i]);
    }

    
    public MenuItem[] getItems()
    {
        return (MenuItem[])items.toArray(template);
    }
    
	public String getTitle()
    {
        return title;
    }
    
    public void removeItem(MenuItem item)
    {
        items.remove(item);
    }

    public void setTitle(String pTitle)
    {
        title = pTitle;
    }
    

}
