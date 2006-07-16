package ar.com.espumito.core.web.tags;

import ar.com.espumito.core.render.DefaultRendererConfiguration;

public class DefaultTagRendererConfig extends DefaultRendererConfiguration {
	private HtmlAttributes htmlAttributes;

	private String[] args;

	private String bundle;

	private String localeKey;

	public String[] getArgs() {
		return this.args;
	}

	public String getBundle() {
		return this.bundle;
	}

	public String getLocaleKey() {
		return this.localeKey;
	}

	public void setArgs(String[] args) {
		this.args = args;
	}

	public void setBundle(String bundle) {
		this.bundle = bundle;
	}

	public void setLocaleKey(String localeKey) {
		this.localeKey = localeKey;
	}

	public HtmlAttributes getHtmlAttributes() {
		return this.htmlAttributes;
	}

	public void setHtmlAttributes(HtmlAttributes htmlAttributes) {
		this.htmlAttributes = htmlAttributes;
	}
}
