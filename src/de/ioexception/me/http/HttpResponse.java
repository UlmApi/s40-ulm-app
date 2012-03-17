package de.ioexception.me.http;

import java.util.Hashtable;

/**
 * @author Benjamin Erb
 */
public interface HttpResponse
{
	public byte[] getEntity();

	public int getStatusCode();

	public Hashtable getHeaders();
}
