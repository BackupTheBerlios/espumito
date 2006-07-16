package ar.com.espumito.core.text;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
 * <p>
 * Text format that parses and formats strings using regular expression
 * replacements.
 * </p>
 * <p>
 * Date: 12-mar-2006
 * </p>
 * 
 * @author guybrush
 * @see ar.com.espumito.core.text.Replacement
 */
public class RegexpTextFormat extends Format {
	/**
	 * Replacements used when formatting objects.
	 */
	private Vector formatReplacements = new Vector();

	/**
	 * Replacements used when parsing strings.
	 */
	private Vector parseReplacements = new Vector();

	public RegexpTextFormat() {
		super();
	}

	public void addFormatReplacement(Replacement replacement) {
		this.formatReplacements.add(replacement);
	}

	public void addAllFormatReplacements(Collection replacements) {
		this.formatReplacements.addAll(replacements);
	}

	public void removeFormatReplacement(Replacement replacement) {
		this.formatReplacements.remove(replacement);
	}

	public void addParseReplacement(Replacement replacement) {
		this.parseReplacements.add(replacement);
	}

	public void addAllParseReplacements(Collection replacements) {
		this.parseReplacements.addAll(replacements);
	}

	public void removeParseReplacement(Replacement replacement) {
		this.parseReplacements.remove(replacement);
	}

	/**
	 * @see java.text.Format#format(java.lang.Object, java.lang.StringBuffer,
	 *      java.text.FieldPosition)
	 */
	public StringBuffer format(Object obj, StringBuffer toAppendTo,
			FieldPosition pos) {
		if (!(obj instanceof String))
			throw new IllegalArgumentException(
					"Object to format must be a string.");
		String result = new String((String) obj);
		for (Iterator i = this.formatReplacements.iterator(); i.hasNext();) {
			Replacement replacement = (Replacement) i.next();
			result.replaceAll(replacement.getRegexp(), replacement.getRegexp());
		}
		toAppendTo.append(result);
		return toAppendTo;
	}

	/**
	 * @see java.text.Format#parseObject(java.lang.String,
	 *      java.text.ParsePosition)
	 */
	public Object parseObject(String source, ParsePosition pos) {
		String ret = new String(source);
		for (Iterator i = this.parseReplacements.iterator(); i.hasNext();) {
			Replacement replacement = (Replacement) i.next();
			ret.replaceAll(replacement.getRegexp(), replacement
					.getReplacement());
		}
		return ret;
	}

}
