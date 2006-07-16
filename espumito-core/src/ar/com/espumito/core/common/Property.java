package ar.com.espumito.core.common;

/**
 * Simple key;value pair. 
 *
 * @author guybrush
 * Date: 02-mar-2006
 *
 */
public class Property {
	private String key;

	private String value;

	public Property() {
		super();
	}

	public Property(String name, String value) {
		super();
		this.key = name;
		this.value = value;
	}

	/**
	 * @return Returns the key.
	 */
	public String getKey() {
		return this.key;
	}

	/**
	 * @param key
	 *            The key to set.
	 */
	public void setKey(String name) {
		this.key = name;
	}

	/**
	 * @return Returns the value.
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * @param value
	 *            The value to set.
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
