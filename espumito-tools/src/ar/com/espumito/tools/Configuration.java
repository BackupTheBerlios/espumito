/*
 * Created on 05-jun-2005
 */
package ar.com.espumito.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class Configuration {
    public static final String DEFAULT_FILENAME = "projects.properties";
    public static final String PROJECTS_HOME = "projects.home.real";
    public static final String PROJECTS_HOME_TEMPLATE = "projects.home.template";
    public static final String TEMPLATES_DIR = "templates.dir";
    public static final String BUILDFILE_TEMPLATE = "build.vm";
    public static final String DESTINATION_FILE = "build.xml";

    private File configFile;

    private Properties properties = new Properties();

    public Configuration() throws FileNotFoundException, IOException {
        this(new File(DEFAULT_FILENAME));
    }

    public Configuration(String filename) throws FileNotFoundException,
            IOException {
        this(new File(filename));
    }

    public Configuration(File file) throws FileNotFoundException, IOException {
        if (file == null)
            throw new IllegalArgumentException("Debe especificar un archivo.");
        if (!file.exists())
            throw new IllegalArgumentException("El archivo " + file.getName()
                    + " no existe.");
        if (!file.canRead())
            throw new IllegalArgumentException("No se puede leer el archivo "
                    + file.getName() + ".");
        configFile = file;
        properties.load(new FileInputStream(configFile));
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public Enumeration propertyNames() {
        return properties.propertyNames();
    }

    public synchronized Object setProperty(String key, String value) {
        return properties.setProperty(key, value);
    }
    
    public String getProjectsHome()
    {
        return properties.getProperty(PROJECTS_HOME);
    }

    public String getBuildfileTemplate() {
        return getProperty(TEMPLATES_DIR) + "/" + BUILDFILE_TEMPLATE;
    }
    
    public String getDefaultDestinationFileName()
    {
        return DESTINATION_FILE;
    }
    
    public String getProjectsHomeForTemplate()
    {
        return getProperty(PROJECTS_HOME_TEMPLATE);
    }

}
