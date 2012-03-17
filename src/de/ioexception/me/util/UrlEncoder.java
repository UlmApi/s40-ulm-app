package de.ioexception.me.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Simple URL encoding class
 * 
 * @author Benjamin Erb
 */
public class UrlEncoder
{
	private static final String URL_UNRESERVED = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789-_.~";
	private static final char[] HEX = "0123456789ABCDEF".toCharArray();

	public static String encode(String str)
	{
		StringBuffer stringBuffer = new StringBuffer();
		byte[] bytes = null;
		
		try
		{
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
			dataOutputStream.writeUTF(str);
			bytes = byteArrayOutputStream.toByteArray();
		}
		catch(IOException e)
		{
			// ignore
			e.printStackTrace();
		}
		
		for(int i = 2; i < bytes.length; i++)
		{
			byte b = bytes[i];
			
			if(URL_UNRESERVED.indexOf(b) >= 0)
			{
				stringBuffer.append((char) b);
			}
			else
			{
				stringBuffer.append('%').append(HEX[(b >> 4) & 0x0f]).append(HEX[b & 0x0f]);
			}
		}
		
		return stringBuffer.toString();
	}
}
