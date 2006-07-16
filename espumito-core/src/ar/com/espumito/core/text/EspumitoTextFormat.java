package ar.com.espumito.core.text;

import java.util.Vector;

/**
 * <p>
 * Espumito text format.
 * </p>
 * <p>
 * Date: 12-mar-2006
 * </p>
 * 
 * @author guybrush
 * 
 */
public class EspumitoTextFormat extends RegexpTextFormat {
	private static Vector FORMAT_REPLACEMENTS = new Vector();

	private static Vector PARSE_REPLACEMENTS = new Vector();

	static {
		FORMAT_REPLACEMENTS.add(new Replacement("\n\r", "\n"));
		FORMAT_REPLACEMENTS.add(new Replacement("\r\n", "\n"));
		FORMAT_REPLACEMENTS.add(new Replacement("\r", "\n"));
		FORMAT_REPLACEMENTS.add(new Replacement("\n", "<br/>"));

		PARSE_REPLACEMENTS.add(new Replacement("<br/>", "\n"));
		PARSE_REPLACEMENTS.add(new Replacement("<", "&lt;"));
		PARSE_REPLACEMENTS.add(new Replacement(">", "&gt;"));
		PARSE_REPLACEMENTS.add(new Replacement("\n", "</p>\n<p>"));
		PARSE_REPLACEMENTS.add(new Replacement("$", "</p>"));
		PARSE_REPLACEMENTS.add(new Replacement("^", "<p>"));
		PARSE_REPLACEMENTS.add(new Replacement("<p></p>", "<p>&nbsp;</p>"));
	}

	public EspumitoTextFormat() {
		super();
		addAllFormatReplacements(FORMAT_REPLACEMENTS);
		addAllParseReplacements(PARSE_REPLACEMENTS);
	}

}
