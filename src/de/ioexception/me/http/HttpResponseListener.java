package de.ioexception.me.http;

/**
 * A listener interface for handling HTTP requests. Allows to dispatch HTTP
 * requests asynchronously and handle the response by a callback function.
 * 
 * @author Benjamin Erb
 */
public interface HttpResponseListener
{
	/**
	 * Invoked when the response has been received.
	 */
	public void responseReceived(final HttpResponse response);
}
