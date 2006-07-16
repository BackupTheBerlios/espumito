package ar.com.espumito.plugins.domain;

public class PluginBean {
    private Long id;

    private String name;

    private String description;

    private Class clazz;

    private SocketBean socket;

    public PluginBean() {
	super();
    }

    public PluginBean(String name, Class clazz) {
	super();
	this.name = name;
	this.clazz = clazz;
    }

    public PluginBean(String name, Class clazz, String description) {
	super();
	this.name = name;
	this.description = description;
	this.clazz = clazz;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	final PluginBean other = (PluginBean) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

    public Class getClazz() {
	return this.clazz;
    }

    public String getDescription() {
	return this.description;
    }

    public Long getId() {
	return this.id;
    }

    public String getName() {
	return this.name;
    }

    public SocketBean getSocket() {
	return this.socket;
    }

    @Override
    public int hashCode() {
	final int PRIME = 31;
	int result = 1;
	result = PRIME * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    /**
         * @return A new instance of {@link #clazz} obtained by
         *         {@link Class#newInstance()}.
         * @throws InstantiationException
         * @throws IllegalAccessException
         */
    public Object newInstance() throws InstantiationException,
	    IllegalAccessException {
	return this.clazz.newInstance();
    }

    public void setClazz(Class clazz) {
	this.clazz = clazz;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setSocket(SocketBean socket) {
	this.socket = socket;
    }

}
