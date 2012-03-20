package de.ulmapi.mobile.s40.bus.data;

import de.ioexception.me.util.Strings;
import de.ioexception.me.util.Wgs84Coordinate;

/**
 * This class represents a bus station that has a unique id, a name, place and a
 * position.
 * 
 * @author Benjamin Erb
 * @author Michael Mueller
 */
public class BusStation
{
	private final int id;
	private final String name;
	private final String place;
	private final String ajaxString;
	private final Wgs84Coordinate position;

	/**
	 * Creates a new station object based on the ID, name, place an position.
	 * 
	 * @param id
	 * @param name
	 * @param place
	 * @param ajaxString
	 * @param position
	 */
	BusStation(int id, String name, String place, String ajaxString, Wgs84Coordinate position)
	{
		super();
		
		this.id = id;
		this.name = name;
		this.place = place;
		this.ajaxString = ajaxString;
		this.position = position;
	}

	/**
	 * Returns the ID of the station.
	 * 
	 * @return
	 */
	public int getId()
	{
		return id;
	}
	
	public String getShortId(){
		return (""+id).substring(3, 7);
	}

	/**
	 * Returns the name of the station.
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Returns the place name of the station.
	 * 
	 * @return
	 */
	public String getPlace()
	{
		return place;
	}

	/**
	 * Returns the string used as parameter for AJAX requests for this station.
	 * 
	 * @return
	 */
	public String getAjaxString()
	{
		return ajaxString;
	}

	/**
	 * Returns the coordinate of this station.
	 * 
	 * @return
	 */
	public Wgs84Coordinate getPosition()
	{
		return position;
	}

	/**
	 * Is the search term contained in place or name?
	 * 
	 * @return
	 */
	public boolean contains(String term)
	{
		String searchName = name.toLowerCase();
		String searchPlace = place.toLowerCase();
		term = term.toLowerCase();

		if(searchName.startsWith(term) || searchPlace.startsWith(term))
		{
			return true;
		}

		// split name by spaces
		
		String[] splits = Strings.split(searchName.toLowerCase(), " ");
		
		for(int i = 0; i < splits.length; i++)
		{
			if(splits[i].startsWith(term))
			{
				return true;
			}
		}

		splits = Strings.split(searchPlace.toLowerCase(), " ");
		
		for(int i = 0; i < splits.length; i++)
		{
			if(splits[i].startsWith(term))
			{
				return true;
			}
		}

		return false;
	}
}
