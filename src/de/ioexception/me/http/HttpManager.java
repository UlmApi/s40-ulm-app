package de.ioexception.me.http;

import java.util.Hashtable;

import de.ioexception.me.util.Base64;
import de.ioexception.me.util.BlockingQueue;
import de.ioexception.me.util.VectorBlockingQueue;

/**
 * A singleton manager class for handling HTTP requests. Requests can be handled
 * synchronously or asynchronous. Response must be handled by providing an
 * appropriate {@link HttpResponseListener}.
 * 
 * @author Benjamin Erb
 */
public final class HttpManager
{
	private static HttpManager instance = null;
	private static final int WORKER_THREADS = 2;
	private final Thread[] pool;

	private final BlockingQueue requestQueue;

	private HttpManager()
	{
		requestQueue = new VectorBlockingQueue();
		pool = new Thread[WORKER_THREADS];

		for(int i = 0; i < pool.length; i++)
		{
			pool[i] = new Thread(new HttpRequestWorker(requestQueue));
			pool[i].start();
		}
	}

	/**
	 * Returns the singleton instance of {@link HttpManager}.
	 * 
	 * @return
	 */
	public static synchronized HttpManager getInstance()
	{
		if(instance == null)
		{
			instance = new HttpManager();
		}
		
		return instance;
	}

	/**
	 * Puts the request in the queue.
	 * 
	 * @param request
	 */
	private void dispatch(HttpRequest request)
	{
		try
		{
			requestQueue.put(request);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Executes a GET request.
	 * 
	 * @param uri
	 * @param listener
	 */
	public void get(String uri, HttpResponseListener listener)
	{
		this.request(Http.GET, uri).send(listener);
	}

	/**
	 * Executes a GET request using Basic Authentication.
	 * 
	 * @param uri
	 * @param username
	 * @param password
	 * @param listener
	 */
	public void get(String uri, String username, String password, HttpResponseListener listener)
	{
		this.request(Http.GET, uri).auth(username, password).send(listener);
	}

	/**
	 * Executes a POST request.
	 * 
	 * @param uri
	 * @param contentType
	 * @param entity
	 * @param listener
	 */
	public void post(String uri, String contentType, byte[] entity, HttpResponseListener listener)
	{
		this.request(Http.POST, uri).header(Http.CONTENT_TYPE, contentType).entity(entity).send(listener);
	}

	/**
	 * Executes a POST request using Basic Authentication.
	 * 
	 * @param uri
	 * @param username
	 * @param password
	 * @param contentType
	 * @param entity
	 * @param listener
	 */
	public void post(String uri, String username, String password, String contentType, byte[] entity, HttpResponseListener listener)
	{
		this.request(Http.POST, uri).auth(username, password).header(Http.CONTENT_TYPE, contentType).entity(entity).send(listener);
	}

	/**
	 * Returns a {@link RequestBuilder} instance for request configuration.
	 * 
	 * @param method HTTP method
	 * @param uri target URI
	 * @return
	 */
	public RequestBuilder request(String method, String uri)
	{
		return new RequestBuilder(this, method, uri);
	}

	private void execute(String method, String uri, Hashtable headers, byte[] entity, HttpResponseListener listener)
	{
		dispatch(new HttpRequestImpl(method, uri, headers, entity, listener));
		
		// System.out.println("[" + method + "] " + uri);
	}

	private void setBasicAuthenticationHeader(Hashtable headers, String username, String password)
	{
		if(headers != null && username != null && password != null)
		{
			String value = username + ":" + password;
			headers.put(Http.AUTHORIZATION, "Basic " + Base64.encodeToString(value.getBytes(), false));
		}
	}

	/**
	 * A class for request configuration based on the "builder pattern".
	 * 
	 * @author Benjamin Erb
	 */
	public static class RequestBuilder
	{
		private final String method;
		private final String uri;
		private final HttpManager http;
		private final Hashtable headers;

		private String username = null;
		private String password = null;
		private byte[] entity;

		/**
		 * Creates a new basic request
		 * 
		 * @param http  manage instance for the latter submission
		 * @param method HTTP method
		 * @param uri target URI
		 */
		public RequestBuilder(HttpManager http, String method, String uri)
		{
			this.http = http;
			this.method = method;
			this.uri = uri;
			this.headers = new Hashtable();
		}

		/**
		 * Sets a Basic Authentication header.
		 * 
		 * @param username
		 * @param password
		 * @return
		 */
		public RequestBuilder auth(String username, String password)
		{
			this.username = username;
			this.password = password;
			
			return this;
		}

		/**
		 * Sets a HTTP header.
		 * 
		 * @param field
		 * @param value
		 * @return
		 */
		public RequestBuilder header(String field, String value)
		{
			headers.put(field, value);
			
			return this;
		}

		/**
		 * Sets the HTTP request entity (only valid for POST requests).
		 * 
		 * @param entity
		 * @return
		 */
		public RequestBuilder entity(byte[] entity)
		{
			if(method.equals(Http.POST))
			{
				this.entity = entity;
			}
			
			return this;
		}

		/**
		 * Registers the provided {@link HttpResponseListener} as callback and
		 * sends the actual request.
		 * 
		 * @param listener
		 */
		public void send(HttpResponseListener listener)
		{
			if(username != null && password != null)
			{
				http.setBasicAuthenticationHeader(headers, username, password);
			}
			
			http.execute(method, uri, headers, entity, listener);
		}
	}
}
