package ar.com.espumito.core.text;

/**
 * <p>
 * Replacement for the {@link RegexpFormat}.
 * </p>
 * <p>
 * Date: 12-mar-2006
 * </p>
 * 
 * @author guybrush
 * 
 */
public class Replacement {
	private String regexp;

	private String replacement;

	public Replacement(String regexp, String replacement) {
		this.regexp = regexp;
		this.replacement = replacement;
	}

	/**
	 * @return Returns the regexp.
	 */
	public String getRegexp() {
		return this.regexp;
	}

	/**
	 * @param regexp The regexp to set.
	 */
	public void setRegexp(String regexp) {
		this.regexp = regexp;
	}

	/**
	 * @return Returns the replacement.
	 */
	public String getReplacement() {
		return this.replacement;
	}

	/**
	 * @param replacement The replacement to set.
	 */
	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}
}
