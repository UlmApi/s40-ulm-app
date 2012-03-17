package de.ioexception.me.http;

import java.util.Hashtable;

/**
 * A basic HTTP request class. The class is immutable, so all parameters must be
 * set when instantiating.
 * 
 * @author Benjamin Erb
 */
class HttpRequestImpl implements HttpRequest
{
	private final HttpResponseListener httpRequestListener;
	private final String method;
	private final String requestUri;
	private final Hashtable headers;
	private final byte[] entity;

	/**
	 * Creates a new {@link HttpRequest} instance.
	 * 
	 * @param method Method
	 * @param requestUri URI
	 * @param headers Headers
	 * @param entity optional payload (only POST)
	 * @param httpRequestListener Callback listener
	 */
	public HttpRequestImpl(String method, String requestUri, Hashtable headers, byte[] entity, HttpResponseListener httpRequestListener)
	{
		super();
		
		this.method = method;
		this.requestUri = requestUri;
		this.headers = headers;
		this.entity = entity;
		this.httpRequestListener = httpRequestListener;
	}

	public HttpResponseListener getRequestListener()
	{
		return httpRequestListener;
	}

	public String getMethod()
	{
		return method;
	}

	public String getRequestUri()
	{
		return requestUri;
	}

	public Hashtable getHeaders()
	{
		return headers;
	}

	public byte[] getEntity()
	{
		return entity;
	}
}
