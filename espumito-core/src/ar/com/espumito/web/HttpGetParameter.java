/*
 * Created on 21-may-2005
 */
package ar.com.espumito.web;

public class HttpGetParameter {
    private String name;

    private String value;

    public HttpGetParameter(String name, String value) {
        super();
        setName(name);
        setValue(value);
    }

    protected String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = (name != null) ? name.trim() : "";
    }

    protected String getValue() {
        return this.value;
    }

    protected void setValue(String value) {
        this.value = (value != null) ? value.trim() : "";
    }

    public String toString() {
        return this.name.equals("") ? "" : this.name.trim() + "=" + this.value.trim();
    }

}
