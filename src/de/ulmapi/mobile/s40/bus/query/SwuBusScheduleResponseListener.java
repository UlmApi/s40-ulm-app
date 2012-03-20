package de.ulmapi.mobile.s40.bus.query;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Stack;
import java.util.Vector;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import de.ioexception.me.http.HttpResponse;
import de.ioexception.me.util.HtmlEntities;

/**
 * An adapter class for handling the HTTP request and parsing the AJAX/HTML
 * response page, passing it to a {@link BusScheduleCallback}.
 * 
 * @author Benjamin Erb
 */
class SwuBusScheduleResponseListener extends DefaultHandler implements BusScheduleResponseListener
{
	private final BusScheduleCallback callback;
	private final Vector results;

	private final Stack currentElement = new Stack();

	public SwuBusScheduleResponseListener(BusScheduleCallback callback)
	{
		this.callback = callback;
		
		results = new Vector();
	}

	/* (non-Javadoc)
	 * @see de.ulmapi.mobile.s40.bus.query.BusScheduleResponseListener#responseReceived(de.ioexception.me.http.HttpResponse)
	 */
	public void responseReceived(HttpResponse response)
	{
		if(response.getStatusCode() == 200)
		{
			InputStream inputStream = null;
			
			try
			{
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser = factory.newSAXParser();

				inputStream = new ByteArrayInputStream(response.getEntity());
				InputSource inputSource = new InputSource(inputStream);
				saxParser.parse(inputSource, this);
			}
			catch(Exception e)
			{
				// ignore
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
					catch(IOException e)
					{
						// ignore
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
	{
		currentElement.push(qName);
	}

	public void endElement(String arg0, String arg1, String arg2)
	{
		currentElement.pop();
	}

	public void characters(char[] ch, int start, int length) throws SAXException
	{
		String cdata = new String(ch, start, length);

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser;
		InputStream htmlInputStream = null;
		
		try
		{
			saxParser = factory.newSAXParser();
			htmlInputStream = new ByteArrayInputStream(cdata.getBytes());
			InputSource inputSource = new InputSource(htmlInputStream);
			inputSource.setEncoding("utf8");
			saxParser.parse(inputSource, new HtmlAjaxResponseHandler(results));
		}
		catch(ParserConfigurationException e1)
		{
			// ignore
			e1.printStackTrace();
		}
		catch(IOException e)
		{
			// ignore
			e.printStackTrace();
		}
		finally
		{
			if(htmlInputStream != null)
			{
				try
				{
					htmlInputStream.close();
				}
				catch(IOException e)
				{
					// ignore
					e.printStackTrace();
				}
			}
		}
	}

	public void endDocument() throws SAXException
	{
		if(callback != null)
		{
			callback.handleSchedule(results);
		}
	}

	private static class HtmlAjaxResponseHandler extends DefaultHandler
	{
		private final Stack htmlCurrentElement = new Stack();

		private final Vector results;

		private final static String LINE = "z7_departure_monitor_line";
		private final static String TARGET = "z7_departure_monitor_target";
		private final static String IMAGE = "z7_departure_monitor_departure_image";
		private final static String TIME = "z7_departure_monitor_departure_time";

		private final static int START_MODE = 0;
		private final static int LINE_MODE = 1;
		private final static int TARGET_MODE = 2;
		private final static int DEPTARTURE_MODE = 3;

		private int mode = START_MODE;

		private StringBuffer accumulator = new StringBuffer();

		private String line = "";
		private String target = "";
		private int dept = 0;

		public HtmlAjaxResponseHandler(Vector results)
		{
			this.results = results;
		}

		void setLine(String line)
		{
			this.line = line;
		}

		void setDeparture(int departure)
		{
			this.dept = departure;
			
			submit();
		}

		void setTarget(String target)
		{
			this.target = target;
		}

		private void submit()
		{
			if(line.length() > 0 && target.length() > 0 && dept > -2)
			{
				results.addElement(new BusScheduleResult(target, line, dept));
			}
			
			this.line = "";
			this.target = "";
			this.dept = -1;
		}

		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
			if(qName.equals("div") && attributes.getValue("class") != null)
			{
				String divClass = attributes.getValue("class");
				
				if(divClass.equals(LINE))
				{
					mode = LINE_MODE;
				}
				else if(divClass.equals(TARGET))
				{
					mode = TARGET_MODE;
				}
				else if(divClass.equals(TIME))
				{
					mode = DEPTARTURE_MODE;
				}
				else if(divClass.equals(IMAGE))
				{
					mode = DEPTARTURE_MODE;
				}
			}

			if(qName.equals("img") && mode == DEPTARTURE_MODE)
			{
				setDeparture(0);
			}
			
			htmlCurrentElement.push(qName);
			accumulator.setLength(0);
		}

		public void characters(char[] ch, int start, int length) throws SAXException
		{
			accumulator.append(ch, start, length);
		}

		public void skippedEntity(String name) throws SAXException
		{
			if(!name.equals("nbsp"))
			{
				accumulator.append(HtmlEntities.decodeSaxEntity(name));
			}
		}

		public void endElement(String uri, String localName, String qName)
		{
			if(qName.equals("nobr"))
			{
				switch(mode)
				{
					case LINE_MODE: 		setLine(accumulator.toString().trim());
											break;

					case TARGET_MODE: 		setTarget(accumulator.toString().trim());
											break;

					case DEPTARTURE_MODE: 	setDeparture(Integer.parseInt(accumulator.toString().trim()));
											break;

					default: 				break;
				}
			}

			htmlCurrentElement.pop();
		}
	}
}
