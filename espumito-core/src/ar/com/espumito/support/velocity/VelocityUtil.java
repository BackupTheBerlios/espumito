package ar.com.espumito.support.velocity;

import java.util.Properties;

import org.apache.velocity.app.VelocityEngine;

public class VelocityUtil {
	private static VelocityUtil instance;

	public static VelocityUtil getInstance() {
		if (instance == null)
			instance = new VelocityUtil();
		return instance;
	}

	protected VelocityUtil() {

	}

	public VelocityEngine getClasspathEngine() throws Exception {
		Properties p = new Properties();
		p.setProperty("class.resource.loader.description","Velocity Classpath Resource Loader");
		p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
		p.setProperty("resource.loader", "class");
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init(p);
		return velocityEngine;
	}

}
