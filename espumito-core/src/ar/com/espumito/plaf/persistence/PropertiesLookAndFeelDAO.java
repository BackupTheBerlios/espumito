package ar.com.espumito.plaf.persistence;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ar.com.espumito.core.common.SimpleObjectLoader;
import ar.com.espumito.core.io.Resource;
import ar.com.espumito.persistence.PersistenceException;
import ar.com.espumito.plaf.domain.LookAndFeel;

public class PropertiesLookAndFeelDAO
    implements LookAndFeelDAO
{

    private Resource                 resource;
    private boolean initialized = false;
    private Map<String, LookAndFeel> loadedLookAndFeels = new HashMap<String, LookAndFeel>();

    public PropertiesLookAndFeelDAO(Resource resource)
    {
        super();
        this.resource = resource;
        try
        {
            loadResources();
        } catch (IOException e)
        {
            throw new IllegalArgumentException("Could not load look and feels from resource " + resource.getName());
        }
    }

    public void delete(Object object)
        throws PersistenceException
    {
        throw new UnsupportedOperationException();
    }

    public Object find(Serializable id)
        throws PersistenceException
    {
        LookAndFeel laf = this.loadedLookAndFeels.get((String) id);
        if (laf != null)
            return laf;
        else
            throw new PersistenceException("Look and feel " + id + " not found.");
    }

    public Collection findAll()
        throws PersistenceException
    {
        try
        {
            loadResources();
        } catch (IOException e)
        {
            throw new PersistenceException("Could not load look and feel list.", e);
        }
        return this.loadedLookAndFeels.values();
    }

    private LookAndFeel loadFromResource(Resource resource)
        throws IOException
    {
        PropertiesLookAndFeelLoader loader = new PropertiesLookAndFeelLoader();
        return (LookAndFeel) loader.loadObjectFromResource(resource);
    }

    private void loadResources()
        throws IOException
    {
        if (!this.initialized)
        {
            this.initialized = true;
            SimpleObjectLoader loader = new SimpleObjectLoader();
            List<LookAndFeelResource> resources = (List<LookAndFeelResource>) loader.loadObjectsFromResource(
                    this.resource, new LookAndFeelResourceTransformationStrategy());
            for (LookAndFeelResource r : resources)
            {
                LookAndFeel laf = loadFromResource(r.getResource());
                this.loadedLookAndFeels.put(r.getId(), laf);
            }
            
        }
    }

    public Object save(Object object)
        throws PersistenceException
    {
        throw new UnsupportedOperationException();
    }

    public Object update(Object object)
        throws PersistenceException
    {
        throw new UnsupportedOperationException();
    }
}
