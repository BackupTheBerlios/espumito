/*
 * Created on 12-jul-2005
 */
package ar.com.espumito.support.hivemind;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.hivemind.ClassResolver;
import org.apache.hivemind.Registry;
import org.apache.hivemind.impl.DefaultClassResolver;
import org.apache.hivemind.impl.RegistryBuilder;
import org.apache.hivemind.util.ClasspathResource;

public class HiveMindSupport {
    private static HiveMindSupport instance = null;

    private Registry registry;

    public static HiveMindSupport getInstance() {
        if (instance == null)
            instance = new HiveMindSupport();
        return instance;
    }

    protected HiveMindSupport() {

    }

    public Registry getRegistry() {
        if (registry == null)
        {
//            ClassResolver classResolver = new DefaultClassResolver();
//            List resources = new Vector();
//            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("META-INF/hibernate.properties");
//            Properties p = new Properties();
//            try {
//                p.load(is);
//                String descriptorsProperty = p.getProperty("hivemind.modules.descriptors");
//                StringTokenizer tokenizer = new StringTokenizer(descriptorsProperty, ",");
//                while (tokenizer.hasMoreElements())
//                {
//                    ClasspathResource resource = new ClasspathResource(classResolver, tokenizer.nextToken());
//                    resources.add(resource);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            RegistryBuilder registryBuilder = new RegistryBuilder();
//            ModuleDescriptorProvider descriptorProvider = new XmlModuleDescriptorProvider(classResolver, resources);
//            registryBuilder.addModuleDescriptorProvider(descriptorProvider);
//            
            
            
            registry = RegistryBuilder.constructDefaultRegistry();
        }
        return registry;
    }
}
