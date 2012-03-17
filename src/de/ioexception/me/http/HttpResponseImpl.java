package de.ioexception.me.http;

import java.util.Hashtable;

/**
 * A basic HTTP response class. The class is immutable, so all parameters must
 * be set when instantiating.
 * 
 * @author Benjamin Erb
 */
class HttpResponseImpl implements HttpResponse
{
	private final byte[] entity;
	private final int statusCode;
	private final Hashtable headers;

	public HttpResponseImpl(int statusCode, Hashtable headers, byte[] entity)
	{
		super();
		
		this.statusCode = statusCode;
		this.headers = headers;
		this.entity = entity;
	}

	public byte[] getEntity()
	{
		return entity;
	}

	public int getStatusCode()
	{
		return statusCode;
	}

	public Hashtable getHeaders()
	{
		return headers;
	}
}
