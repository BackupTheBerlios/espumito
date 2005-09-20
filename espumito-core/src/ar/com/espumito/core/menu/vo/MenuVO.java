package ar.com.espumito.core.menu.vo;

import java.util.HashSet;
import java.util.Set;

import ar.com.espumito.security.vo.RoleVO;

public class MenuVO
{
    private String title;
    private Set allowedRoles = new HashSet();
    private String url;
    
    public MenuVO()
    {
        super();
    }

    /**
     * @param pTitle
     * @param pUrl
     */
    public MenuVO(String pTitle, String pUrl)
    {
        super();
        
        title = pTitle;
        url = pUrl;
    }

    public Set getAllowedRoles()
    {
        return allowedRoles;
    }

    public void addAllowedRole(RoleVO role)
    {
        allowedRoles.add(role);
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String pTitle)
    {
        title = pTitle;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String pUrl)
    {
        url = pUrl;
    }
}
