package de.ulmapi.mobile.s40.bus.query;

/**
 * An entry of a schedule result list. Contains destination, line and departure
 * data.
 * 
 * @author Benjamin Erb
 */
public class BusScheduleResult
{
	private final String destination;
	private final String line;
	private final int departure;

	BusScheduleResult(String destination, String line, int departure)
	{
		super();
		
		this.destination = destination;
		this.line = line;
		this.departure = departure;
	}

	/**
	 * Returns transport destination.
	 * 
	 * @return
	 */
	public String getDestination()
	{
		return destination;
	}

	/**
	 * Returns transport line name.
	 * 
	 * @return
	 */
	public String getLine()
	{
		return line;
	}

	/**
	 * Returns estimated departure time in minutes. "0" represents pending
	 * departure.
	 * 
	 * @return
	 */
	public int getDeparture()
	{
		return departure;
	}
}
