package de.ioexception.me.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;

import de.ioexception.me.util.BlockingQueue;

/**
 * A worker that processes enqueued requests through a shared
 * {@link BlockingQueue}.
 * 
 * @author Benjamin Erb
 */
class HttpRequestWorker implements Runnable
{
	private final BlockingQueue requestQueue;
	private boolean running = true;

	public HttpRequestWorker(BlockingQueue requestQueue)
	{
		this.requestQueue = requestQueue;
	}

	public void run()
	{
		HttpRequest request;
		
		try
		{
			while(running && (request = ((HttpRequest) requestQueue.take())) != null)
			{
				if(running)
				{
					handle(request);
				}
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void cancel()
	{
		running = false;
	}

	public HttpResponse handle(final HttpRequest request)
	{
		HttpConnection connection = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		byte[] responseEntity = null;
		HttpResponse response = null;

		try
		{
			connection = (HttpConnection) Connector.open(request.getRequestUri());
			connection.setRequestMethod(request.getMethod());

			// Set headers
			
			Hashtable headers = request.getHeaders();
			
			if(headers != null)
			{
				for(Enumeration e = headers.keys(); e.hasMoreElements();)
				{
					String key = (String) e.nextElement();
					String value = (String) headers.get(key);
					connection.setRequestProperty(key, value);
				}
			}

			// Send request entity for POST (if available)
			
			if(request.getMethod().equals(Http.POST) && request.getEntity() != null && request.getEntity().length > 0)
			{
				connection.setRequestProperty(Http.CONTENT_LENGTH, "" + request.getEntity().length);
				
				if(!headers.containsKey(Http.CONTENT_TYPE))
				{
					connection.setRequestProperty(Http.CONTENT_TYPE, Http.APPLICATION_OCTET_STREAM);
				}
				
				outputStream = connection.openOutputStream();
				outputStream.write(request.getEntity());
				outputStream.flush();
			}

			// Check for cancellation before going over-the-wire
			
			if(!running)
			{
				return null;
			}

			// Execute request
			
			int statusCode = connection.getResponseCode();

			// Extract headers
			
			Hashtable responseHeaders = new Hashtable();
			int i = 0;
			String headerKey = null;
			
			while((headerKey = connection.getHeaderFieldKey(i)) != null)
			{
				responseHeaders.put(headerKey, connection.getHeaderField(i));
				i++;
			}

			// Extract response entity
			
			inputStream = connection.openInputStream();
			int length = (int) connection.getLength();
			
			if(length != -1)
			{
				responseEntity = new byte[length];
				inputStream.read(responseEntity);
			}
			else
			{
				ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
				int ch;
				
				while((ch = inputStream.read()) != -1)
				{
					bytestream.write(ch);
				}
				
				responseEntity = bytestream.toByteArray();
				bytestream.close();
			}

			response = new HttpResponseImpl(statusCode, responseHeaders, responseEntity);
			
			if(request.getRequestListener() != null)
			{
				request.getRequestListener().responseReceived(response);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(inputStream != null)
			{
				try
				{
					inputStream.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			if(outputStream != null)
			{
				try
				{
					outputStream.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
			if(connection != null)
			{
				try
				{
					connection.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		return response;
	}
}
