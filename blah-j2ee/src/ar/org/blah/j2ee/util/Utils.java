/*
 * Created on 04-mar-2005
 */
package ar.org.blah.j2ee.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class Utils {
    private static Logger logger = Logger.getLogger(Utils.class);

    public static Properties readProperties(String pFileName)
            throws IOException {
        logger.debug("Loading properties from " + pFileName);
        Properties properties = readProperties(pFileName, Thread
                .currentThread().getContextClassLoader());
        if (properties == null)
            properties = readProperties(pFileName, ClassLoader
                    .getSystemClassLoader());
        return properties;
    }

    public static Properties readProperties(String resource,
            ClassLoader classloader) {
        InputStream inputStream = classloader.getResourceAsStream(resource);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            return properties;
        } catch (IOException e) {
            logger.error("Could not load properties from " + resource
                    + " using classloader " + classloader, e);
            return null;
        }
    }

    /**
     * Muestra una lista de properties.
     * 
     * @param properties
     */
    public static void listProperties(Properties properties, Level level) {
        if (properties != null)
            for (Enumeration i = properties.keys(); i.hasMoreElements();) {
                String key = (String) i.nextElement();
                String value = properties.getProperty(key);
                logger.log(level, "[" + key + "]=[" + value + "]");
            }
    }

    public static void listProperties(Properties properties) {
        listProperties(properties, Level.DEBUG);
    }

}
