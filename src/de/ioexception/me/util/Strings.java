package de.ioexception.me.util;

import java.util.Vector;

/**
 * String utility classes.
 * 
 * @author Michael Mueller
 */
public class Strings
{
	/**
	 * String split method.
	 * 
	 * @param original
	 * @param separator
	 * @return
	 */
	public static String[] split(String original, String separator)
	{
		Vector nodes = new Vector();
		int index = original.indexOf(separator);

		while(index >= 0)
		{
			nodes.addElement(original.substring(0, index));
			original = original.substring(index + separator.length());
			index = original.indexOf(separator);
		}
		
		if(original.length() > 0)
		{
			nodes.addElement(original);
		}

		String[] result = new String[nodes.size()];
		
		if(nodes.size() > 0)
		{
			for(int loop = 0; loop < nodes.size(); loop++)
			{
				result[loop] = (String) nodes.elementAt(loop);
			}
		}

		return result;
	}
}
