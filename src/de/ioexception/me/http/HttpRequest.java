package de.ioexception.me.http;

import java.util.Hashtable;

/**
 * An interface for HTTP request classes.
 * 
 * @author Benjamin Erb
 */
public interface HttpRequest
{
	public HttpResponseListener getRequestListener();

	public String getMethod();

	public String getRequestUri();

	public Hashtable getHeaders();

	public byte[] getEntity();
}
