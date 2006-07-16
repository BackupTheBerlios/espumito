package ar.com.espumito.core.web.tags;

public class HtmlAttributes {
	private String id = "";

	private String style = "";

	private String clazz = "";

	public HtmlAttributes() {
	}

	public HtmlAttributes(String id, String style, String clazz) {
		super();
		this.id = id;
		this.style = style;
		this.clazz = clazz;
	}

	public String getClazz() {
		return this.clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}
}
