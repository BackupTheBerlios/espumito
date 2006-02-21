package ar.com.espumito.links.domain;

public class LinkBean {

	private String description;

	private Long id;

	private String label;

	private String url;

	public LinkBean() {
	}

	public LinkBean(String url) {
		this.url = url;
	}

	public LinkBean(String url, String label) {
		this.url = url;
		this.label = label;
	}

	public LinkBean(String url, String label, String description) {
		this.url = url;
		this.label = label;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public Long getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}

	public String getUrl() {
		return url;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
