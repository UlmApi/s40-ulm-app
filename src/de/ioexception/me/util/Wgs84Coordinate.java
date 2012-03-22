package de.ioexception.me.util;

import de.ioexception.me.util.MathUtils;

/**
 * Class for WGS84-encoded positions. Latitude and longitude are stored as
 * decimal float values using the {@link Double} type.
 * 
 * @author Benjamin Erb
 * @author Michael Mueller
 */
public class Wgs84Coordinate
{
	private final double latitude;
	private final double longitude;

	public static final double EQUATOR = 6378137.0d;

	public Wgs84Coordinate(double latitude, double longitude)
	{
		super();

		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Calculates the distance between two coordinates. The algorithm has been
	 * chosen due to its efficiency although producing slightly inaccurate
	 * results.
	 * 
	 * @param other
	 * @return
	 */
	public double getDistance(Wgs84Coordinate other)
	{
		double lon1 = this.longitude;
		double lon2 = other.longitude;
		double lat1 = this.latitude;
		double lat2 = other.latitude;
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * MathUtils.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		return c * EQUATOR;
	}

	/**
	 * Returns the latitude.
	 * 
	 * @return
	 */
	public double getLatitude()
	{
		return latitude;
	}

	/**
	 * Returns the longitude.
	 * 
	 * @return
	 */
	public double getLongitude()
	{
		return longitude;
	}

	/**
	 * Checks whether a the current {@link Wgs84Coordinate} is inside a box,
	 * drawn by the to given {@link Wgs84Coordinate}s.
	 * 
	 * @param pos1
	 * @param pos2
	 * @return
	 */
	public boolean within(Wgs84Coordinate pos1, Wgs84Coordinate pos2)
	{
		double minLong = Math.min(pos1.getLongitude(), pos2.getLongitude());
		double minLat = Math.min(pos1.getLatitude(), pos2.getLatitude());

		double maxLong = Math.max(pos1.getLongitude(), pos2.getLongitude());
		double maxLat = Math.max(pos1.getLatitude(), pos2.getLatitude());

		if(getLongitude() <= maxLong && getLongitude() >= minLong && getLatitude() <= maxLat && getLatitude() >= minLat)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
