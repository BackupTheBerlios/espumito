package ar.com.espumito.plugins.domain;


public abstract class SocketBean {
	private Long id;

	private String name;

	private String description;

	private Class clazz;

	public SocketBean() {

	}

	public SocketBean(String name, Class expectedClass) {
		super();
		this.name = name;
		this.clazz = expectedClass;
	}

	public SocketBean(String name, String description, Class expectedClass) {
		super();
		this.name = name;
		this.description = description;
		this.clazz = expectedClass;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SocketBean other = (SocketBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDescription() {
		return this.description;
	}

	public Class getExpectedClass() {
		return this.clazz;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setClazz(Class expectedClass) {
		this.clazz = expectedClass;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getClazz() {
	    return this.clazz;
	}

}
