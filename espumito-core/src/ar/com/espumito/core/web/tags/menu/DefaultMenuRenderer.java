package ar.com.espumito.core.web.tags.menu;

import java.util.Iterator;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import ar.com.espumito.core.menu.vo.MenuVO;
import ar.com.espumito.core.render.RendererConfiguration;
import ar.com.espumito.core.render.VelocityTemplateRenderer;

public class DefaultMenuRenderer
    extends VelocityTemplateRenderer
{

    private static Logger      logger                = Logger.getLogger(DefaultMenuRenderer.class);
    public static final String DEFAULT_MENU_RENDERER = "renderer.menu.default";
    public static final String CTX_MENU              = "menu";
    public static final String CTX_MENU_HTML_ATTR_ID = "menu";

    public DefaultMenuRenderer()
    {
        super();
        setTemplateName("ar/com/espumito/core/web/tags/menu/DefaultMenuTemplate.vm");
    }

    protected Context createContext(Object model, RendererConfiguration tagConfig)
    {
        MenuTagRendererConfig menuTagConfig = (MenuTagRendererConfig) tagConfig;
        VelocityContext c = new VelocityContext();
        if (model != null)
        {
            MenuVO vo = (MenuVO) model;
            c.put(CTX_MENU, vo);
//            MemorialVector items = new MemorialVector(vo.getItems().size());
//            for (Iterator i = vo.getItems().iterator(); i.hasNext();)
//            {
//                MenuVO item = (MenuVO) i.next();
//                items.add(item);
//            }
//            // Parchecito porque Velocity, en #foreach, no se aguanta List, sino
//            // MemorialVector.
            c.put("items", vo.getItems());
        }
        c.put(CTX_HTML_ATTRIBUTES, menuTagConfig.getHtmlAttributes());
        return c;
    }
}
