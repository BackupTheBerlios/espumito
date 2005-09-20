package ar.com.espumito.core.web.menu;

import javax.servlet.http.HttpServletRequest;


public interface MenuProvider
{
    public Menu getMenu(HttpServletRequest request);
    public String getMenuKey();
}
