/*
 * Created on 16-ene-2005
 */
package ar.com.espumito.web;

/**
 * TODO Falta descripcion de 
 * @author guybrush
 */
public class BasicError
{
    private String message;

    /**
     * Constructor
     * @param pMessage
     */
    public BasicError(String pMessage)
    {
        super();
        message = pMessage;
    }

    /**
     * @return Returns the message.
     */
    public String getMessage()
    {
        return message;
    }
}
