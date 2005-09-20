package ar.com.espumito.core.menu.services;

import java.security.Principal;
import java.util.Set;

public interface MenuSvc
{
    public Set getMenusForUser(Principal p);
}
