/*
 * Created on 29-ene-2005
 */
package ar.com.espumito.security.web;

import ar.com.espumito.web.GenericForm;


/**
 * TODO Falta descripcion de 
 * @author guybrush
 */
public class RecoverPasswordForm
    extends GenericForm
{
    private String email;

    public RecoverPasswordForm()
    {

    }

    /**
     * @return Returns the email.
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param pEmail The email to set.
     */
    public void setEmail(String pEmail)
    {
        email = pEmail;
    }
}
