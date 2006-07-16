/*
 * Created on 16-ene-2005
 */
package ar.com.espumito.web;

/**
 * @author guybrush
 */
public class CommonSymbols
{
    
    // Forwards comunes. 
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String ID = "id";
    
    public static final String STANDARD_ERROR = "STANDARD_ERROR";
    /**
     * Nombre del forward al que se enviara la coleccion.
     */
    public static final String SHOW_COLLECTION_FORWARD = "showCollection";
    public static final String REDIRECT_FORWARD_ATTRIBUTE = "espumito.redirect.attribute";
    
    /**
     * Nombre del atributo que contiene la coleccion a mostrar.
     */
    public static final String SHOW_COLLECTION_OBJECT = "espumito.redirect.object";
    /**
     * Nombre del atributo que contiene el item a mostrar.
     */
    public static final String SHOW_COLLECTION_ITEM = "espumito.redirect.item";
    /**
     * Nombre de la definicion del tile a utilizar.
     */
    public static final String SHOW_COLLECTION_TILES_DEFINITION = "espumito.showCollection.tileDefinition";
    /**
     * Codigo del titulo de la pagina a utilizar.
     */
    public static final String SHOW_COLLECTION_PAGE_TITLE = "espumito.showCollection.pageTitle";
    /**
     * Nombre del atributo donde se guarda el forward que muestra cada item de la coleccion.
     */
    public static final String SHOW_COLLECTION_VIEW = "espumito.showCollection.view";
    /**
     * Nombre del forward al JSP que renderiza cada item de la coleccion.
     */
    public static final String SHOW_COLLECTION_VIEW_FORWARD = "espumito.showCollection.viewForward";
}
