package ar.com.espumito.plaf.services;

import ar.com.espumito.plaf.domain.LookAndFeelPlugin;

/**
 * TODO: add description for LookAndFeelPluginProvider 
 *
 * @author guybrush
 * Date: 27-feb-2006
 *
 */
public interface LookAndFeelPluginProvider {
	public LookAndFeelPlugin[] getLookAndFeelPlugins(String lookAndFeelId);
	public LookAndFeelPlugin getLookAndFeelPlugin(String lookAndFeelId, String pluginId);
}
