package de.ioexception.me.util;

import java.util.Hashtable;

/**
 * Static table of HTML entites.
 * 
 * @author Benjamin Erb
 */
public class HtmlEntities
{
	private static Hashtable htmlEntities = new Hashtable();

	static
	{
		htmlEntities.put("&lt;", "<");
		htmlEntities.put("&gt;", ">");
		htmlEntities.put("&amp;", "&");
		htmlEntities.put("&quot;", "\"");
		htmlEntities.put("&agrave;", "�");
		htmlEntities.put("&Agrave;", "�");
		htmlEntities.put("&acirc;", "�");
		htmlEntities.put("&auml;", "�");
		htmlEntities.put("&Auml;", "�");
		htmlEntities.put("&Acirc;", "�");
		htmlEntities.put("&aring;", "�");
		htmlEntities.put("&Aring;", "�");
		htmlEntities.put("&aelig;", "�");
		htmlEntities.put("&AElig;", "�");
		htmlEntities.put("&ccedil;", "�");
		htmlEntities.put("&Ccedil;", "�");
		htmlEntities.put("&eacute;", "�");
		htmlEntities.put("&Eacute;", "�");
		htmlEntities.put("&egrave;", "�");
		htmlEntities.put("&Egrave;", "�");
		htmlEntities.put("&ecirc;", "�");
		htmlEntities.put("&Ecirc;", "�");
		htmlEntities.put("&euml;", "�");
		htmlEntities.put("&Euml;", "�");
		htmlEntities.put("&iuml;", "�");
		htmlEntities.put("&Iuml;", "�");
		htmlEntities.put("&ocirc;", "�");
		htmlEntities.put("&Ocirc;", "�");
		htmlEntities.put("&ouml;", "�");
		htmlEntities.put("&Ouml;", "�");
		htmlEntities.put("&oslash;", "�");
		htmlEntities.put("&Oslash;", "�");
		htmlEntities.put("&szlig;", "�");
		htmlEntities.put("&ugrave;", "�");
		htmlEntities.put("&Ugrave;", "�");
		htmlEntities.put("&ucirc;", "�");
		htmlEntities.put("&Ucirc;", "�");
		htmlEntities.put("&uuml;", "�");
		htmlEntities.put("&Uuml;", "�");
		htmlEntities.put("&nbsp;", " ");
		htmlEntities.put("&copy;", "\u00a9");
		htmlEntities.put("&reg;", "\u00ae");
		htmlEntities.put("&euro;", "\u20a0");
	}

	public static String decode(String entity)
	{
		return (String) htmlEntities.get(entity);
	}

	public static String decodeSaxEntity(String entity)
	{
		return (String) htmlEntities.get("&" + entity + ";");
	}
}
