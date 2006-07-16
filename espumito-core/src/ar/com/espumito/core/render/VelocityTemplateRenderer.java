package ar.com.espumito.core.render;

import java.io.Writer;
import java.util.Properties;

import javax.servlet.jsp.PageContext;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;

/**
 * Renderer que utiliza un template de Velocity.
 * @author guybrush
 *
 */
public class VelocityTemplateRenderer extends AbstractRenderer {
	private static Logger logger = Logger
			.getLogger(VelocityTemplateRenderer.class);

	private String modelName = CTX_MODEL;

	/**
	 * El template a usar.
	 */
	private Template template;

	/**
	 * El nombre del template.
	 */
	private String templateName;
	
	/**
	 * El engine de Velocity;
	 */
	private VelocityEngine velocityEngine;

	/**
	 * 
	 */
	public VelocityTemplateRenderer() {
		super();
	}

	/**
	 * @param templateName
	 */
	public VelocityTemplateRenderer(String templateName) {
		super();
		setTemplateName(templateName);
	}

	/**
	 * @param templateName
	 * @param modelName
	 */
	public VelocityTemplateRenderer(String templateName, String modelName) {
		super();
		setModelName(modelName);
		setTemplateName(templateName);
	}

	/**
	 * @param template
	 */
	public VelocityTemplateRenderer(Template template) {
		super();
		setTemplate(template);
	}
	
	/**
	 * Crea el contexto que usara el template.
	 * @param model
	 * @param configuration
	 * @return
	 */
	protected Context createContext(Object model, RendererConfiguration configuration) {
		VelocityContext context = new VelocityContext();
		String modelName = getModelName(); 
		context.put(modelName, model);
		String configurationName = getRendererConfigurationName();
		context.put(configurationName, configuration);
		return context;
	}

	/**
	 * Crea el writer para el template.
	 * @param pageContext
	 * @return
	 */
	protected Writer createWriter(PageContext pageContext) {
		return pageContext != null ? pageContext.getOut() : null;
	}

	/**
	 * Método hook para obtener el nombre del modelo.
	 * @return 
	 */
	protected String getModelName()
	{
		return this.modelName;
	}

	/**
	 * Método hook para obtener el nombre de la configuracion del renderer.
	 * @return {@link ar.com.espumito.render.AbstractRenderer#CTX_RENDERER_CONFIGURATION}
	 */
	protected String getRendererConfigurationName() {
		return CTX_RENDERER_CONFIGURATION;
	}

	/**
	 * Obtiene el template
	 * @return
	 * @throws Exception
	 */
	protected Template getTemplate() throws Exception {
		if (this.template == null) {
			VelocityEngine ve = getVelocityEngine();
			this.template = ve.getTemplate(getTemplateName());
		}
		return this.template;
	}

	/**
	 * Método hook para obtener el nombre del template.
	 * @return
	 */
	protected String getTemplateName() {
		return this.templateName;
	}

	/**
	 * Lazy loading para el engine de Velocity.
	 * @return
	 * @throws Exception
	 */
	protected VelocityEngine getVelocityEngine() throws Exception {
		if (this.velocityEngine == null) {
			Properties p = new Properties();
			p.setProperty("class.resource.loader.description",
					"Velocity Classpath Resource Loader");
			p
					.setProperty("class.resource.loader.class",
							"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			p.setProperty("resource.loader", "class");
			this.velocityEngine = new VelocityEngine();
			this.velocityEngine.init(p);
		}
		return this.velocityEngine;
	}

	/**
	 * @see ar.com.espumito.core.render.Renderer#render(java.lang.Object, java.io.Writer, ar.com.espumito.core.render.RendererConfiguration)
	 */
	public void render(Object model, Writer writer, RendererConfiguration configuration)
			throws RenderException {
		try {
			Template t = getTemplate();
			Context c = createContext(model, configuration);
			t.merge(c, writer);
		} catch (Exception e) {
			throw new RenderException(e);
		}
	}

	/**
	 * @param modelName The modelName to set.
	 */
	protected void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * @param template
	 */
	protected void setTemplate(Template template) {
		this.template = template;
	}

	/**
	 * @param templateName
	 */
	protected void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

}
