package de.ioexception.me.http;

/**
 * Class for general HTTP-related constants.
 * 
 * @author Benjamin Erb
 */
public final class Http
{
	// Methods
	
	public static final String GET = "GET";
	public static final String POST = "POST";
	public static final String HEAD = "HEAD";

	// Literals
	
	public static final String CRLF = "\r\n";
	public static final String HTTP = "HTTP";
	public static final String PROTOCOL_DELIMITER = "/";

	// Header fields
	
	public static final String ACCEPT_RANGES = "Accept-Ranges";
	public static final String AGE = "Age";
	public static final String ALLOW = "Allow";
	public static final String CACHE_CONTROL = "Cache-Control";
	public static final String CONTENT_ENCODING = "Content-Encoding";
	public static final String CONTENT_LANGUAGE = "Content-Language";
	public static final String CONTENT_LENGTH = "Content-Length";
	public static final String CONTENT_LOCATION = "Content-Location";
	public static final String CONTENT_DISPOSITION = "Content-Disposition";
	public static final String CONTENT_MD5 = "Content-MD5";
	public static final String CONTENT_RANGE = "Content-Range";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String DATE = "Date";
	public static final String ETAG = "ETag";
	public static final String EXPIRES = "Expires";
	public static final String LAST_MODIFIED = "Last-Modified";
	public static final String LOCATION = "Location";
	public static final String PRAGMA = "Pragma";
	public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
	public static final String REFRESH = "Refresh";
	public static final String RETRY_AFTER = "Retry-After";
	public static final String SERVER = "Server";
	public static final String SET_COOKIE = "Set-Cookie";
	public static final String TRAILER = "Trailer";
	public static final String TRANSFER_ENCODING = "Transfer-Encoding";
	public static final String VARY = "Vary";
	public static final String VIA = "Via";
	public static final String WARNING = "Warning";
	public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
	public static final String ACCEPT = "Accept";
	public static final String ACCEPT_CHARSET = "Accept-Charset";
	public static final String ACCEPT_ENCODING = "Accept-Encoding";
	public static final String ACCEPT_LANGUAGE = "Accept-Language";
	public static final String AUTHORIZATION = "Authorization";
	public static final String CONNECTION = "Connection";
	public static final String COOKIE = "Cookie";
	public static final String EXPECT = "Expect";
	public static final String FROM = "From";
	public static final String HOST = "Host";
	public static final String IF_MATCH = "If-Match";
	public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
	public static final String IF_NONE_MATCH = "If-None-Match";
	public static final String IF_RANGE = "If-Range";
	public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
	public static final String MAX_FORWARDS = "Max-Forwards";
	public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
	public static final String RANGE = "Range";
	public static final String REFERER = "Referer";
	public static final String TE = "TE";
	public static final String UPGRADE = "Upgrade";
	public static final String USER_AGENT = "User-Agent";

	// MIME types
	
	public static final String APPLICATION_JSON = "application/json";
	public static final String APPLICATION_OCTET_STREAM = "application/octet-stream";
	public static final String APPLICATION_X_WWW_FORM_URLENCODED = "application/x-www-form-urlencoded";

	private Http()
	{
		// no instances
	}
}
