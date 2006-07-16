package ar.com.espumito.core.web.tags;

import java.io.Writer;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import ar.com.espumito.core.render.RenderException;
import ar.com.espumito.core.render.Renderer;
import ar.com.espumito.core.render.RendererConfiguration;
import ar.com.espumito.plaf.domain.LookAndFeel;
import ar.com.espumito.plaf.util.LookAndFeelUtil;
import ar.com.espumito.util.StringUtil;

/**
 * Tag Handler base class. Uses the Look and Feel to obtain the renderer that
 * must be used to "write" the tag to the page writer. If no Look and Feel is
 * configured, or the component is not configured in the look and feel, uses the
 * configuration provided by the subclass.
 * 
 * @author guybrush
 * 
 */
public abstract class DefaultTagHandler extends TagSupport {
    private static final Renderer DEFAULT_RENDERER = new DummyRenderer();

    /**
     * Default renderer for this tag. It's used when: no renderer is specified
     * in the tag; no renderer is provided by the subclass; the specified
     * renderer is not supported by the current look and feel.
     */
    private Renderer defaultRenderer;

    /**
     * The id of the default renderer in the look and feel.
     */
    private String defaultRendererId;

    /**
     * The renderer to use.
     */
    private Renderer renderer;

    /**
     * The ID of the renderer.
     */
    private String rendererId;

    /**
     * @param defaultRenderer
     */
    public DefaultTagHandler(Renderer defaultRenderer) {
        super();
        this.defaultRenderer = defaultRenderer;
    }

    /**
     * @param defaultRenderer
     * @param defaultRendererId
     */
    public DefaultTagHandler(Renderer defaultRenderer, String defaultRendererId)
    {
        super();
        this.defaultRenderer = defaultRenderer;
        this.defaultRendererId = defaultRendererId;
    }
    
    /**
     * @param defaultRendererId
     */
    public DefaultTagHandler(String defaultRendererId) {
        super();
        this.defaultRendererId = defaultRendererId;
    }

    /**
     * Writes the tag to the page writer using a renderer.
     * 
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    public int doStartTag() throws JspException {
        return render();
    }
    
    protected int render() throws JspException 
    {
        Renderer renderer = getRendererToUse();
        Object model = getModel();
        Writer writer = this.pageContext.getOut();
        RendererConfiguration tagConfig = getRendererConfig();
        try {
            renderer.render(model, writer, tagConfig);
        } catch (RenderException e) {
            throw new JspException(e);
        }
        return SKIP_BODY;
    }

    /**
     * @return The default renderer.
     */
    protected Renderer getDefaultRenderer() {
        return this.defaultRenderer;
    }

    /**
     * @return Returns the defaultRendererId.
     */
    protected String getDefaultRendererId() {
        return this.defaultRendererId;
    }

    /**
     * Obtains the model of the tag.
     * 
     * @return
     * @throws JspException
     */
    protected abstract Object getModel() throws JspException;

    /**
     * @return Returns the renderer.
     */
    protected Renderer getRenderer() {
        return this.renderer;
    }

    /**
     * The configuration for the renderer. Must be overrided by the subclass in
     * order perform special configurations for the renderer.
     * 
     * @return null
     */
    protected RendererConfiguration getRendererConfig() {
        return null;
    }

    /**
     * Obtains a renderer from the current look and feel. If not found, or no
     * look and feel is configured, returns null.
     * 
     * @param rendererId
     * @return
     * @throws JspException
     */
    protected Renderer getRendererFromLookAndFeel(String rendererId)
            throws JspException {
        LookAndFeel lookAndFeel = LookAndFeelUtil.getLookAndFeel(this.pageContext);
        if (lookAndFeel != null)
            return lookAndFeel.getRenderer(rendererId);
        else
            return null;
    }

    /**
     * The ID of the renderer to use.
     * 
     * @return
     * @jsp.attribute required="false" type="java.lang.String"
     */
    public String getRendererId() {
        return this.rendererId;
    }

    /**
     * <p>
     * The renderer that must be used. This is the renderer finding priority:
     * <ul>
     * <li>The renderer specified through the tag, obtained from the look and
     * feel.</li>
     * <li>The default renderer for the component, obtained from the look and
     * feel.</li>
     * <li>The renderer specified by the subclass.</li>
     * <li>The default renderer specified by the subclass.</li>
     * </ul>
     * </p>
     * 
     * @return
     * @throws JspException
     */
    protected Renderer getRendererToUse() throws JspException {
        Renderer renderer = null;
        if (StringUtil.isNotBlank(this.rendererId))
            renderer = getRendererFromLookAndFeel(this.rendererId);
        if (renderer == null && StringUtil.isNotBlank(this.defaultRendererId))
            renderer = getRendererFromLookAndFeel(this.defaultRendererId);
        if (renderer == null && this.renderer != null)
            renderer = this.renderer;
        if (renderer == null && this.defaultRenderer != null)
            renderer = this.defaultRenderer;
        if (renderer == null)
            renderer = DEFAULT_RENDERER;
        return renderer;
    }

    /**
     * @param defaultRenderer
     */
    protected void setDefaultRenderer(Renderer defaultRenderer) {
        this.defaultRenderer = defaultRenderer;
    }

    /**
     * @param defaultRendererId The defaultRendererId to set.
     */
    protected void setDefaultRendererId(String defaultRendererId) {
        this.defaultRendererId = defaultRendererId;
    }

    /**
     * @param renderer
     */
    protected void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    /**
     * @param rendererId
     */
    public void setRendererId(String rendererId) {
        this.rendererId = rendererId;
    }
}
