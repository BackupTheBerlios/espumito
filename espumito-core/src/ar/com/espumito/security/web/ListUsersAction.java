/*
 * Created on 21-feb-2005
 */
package ar.com.espumito.security.web;

import java.util.Collection;

import javax.ejb.FinderException;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import ar.com.espumito.client.SecurityModel;
import ar.com.espumito.web.EspumitoSymbols;
import ar.com.espumito.web.GetObjectAction;

/**
 * @author guybrush
 */
public class ListUsersAction
    extends GetObjectAction
{
    private static Logger logger = Logger.getLogger(ListUsersAction.class);
    
    /**
     * Constructor
     */
    public ListUsersAction()
    {
        super();
    }

    /**
     * @see ar.com.espumito.web.GetObjectAction#getObject(ActionMapping, ActionForm, HttpServletRequest)
     */
    protected Object getObject(ActionMapping pMapping, ActionForm pForm, HttpServletRequest pRequest)
        throws FinderException
    {
        Collection users = SecurityModel.getInstance().getUsers();
        if (users != null)
            logger.info("Se encontraron " + users.size() + " usuarios.");
        else
            logger.info("La lista de usuarios == null");
        return users;
    }

    /**
     * @see ar.com.espumito.web.GetObjectAction#getResultSymbol()
     */
    protected String getResultSymbol()
    {
        return EspumitoSymbols.USER_ADMIN_USERS;
    }

    /**
     * @see ar.com.espumito.web.GetObjectAction#getErrorMessage()
     */
    protected String getErrorMessage()
    {
        return "Error obteniendo usuarios.";
    }

}
