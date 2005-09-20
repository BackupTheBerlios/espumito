package ar.com.espumito.core.web.menu;

import org.apache.struts.tiles.beans.MenuItem;

public interface Menu
{
    public String getTitle();
    public MenuItem[] getItems();
}
