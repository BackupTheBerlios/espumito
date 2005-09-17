/*
 * Created on 06-feb-2005
 */
package ar.org.blah.j2ee.domain;

/**
 * TODO Falta descripcion de 
 * @author guybrush
 */
public abstract class BasicBean
{
    private long _version;

    /**
     * Constructor
     */
    public BasicBean()
    {
        super();

    }

    /**
     * @return Returns the version.
     * @hibernate.version type = "long" column = "version"
     * 
     */
    public long getVersion()
    {
        return _version;
    }

    /**
     * @param pVersion The version to set.
     */
    public void setVersion(long pVersion)
    {
        _version = pVersion;
    }
}
