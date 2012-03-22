package de.ulmapi.mobile.s40.postbox.data;

import com.nokia.maps.common.GeoCoordinate;

import de.ioexception.me.util.Wgs84Coordinate;

public class Postbox {
	private final String name;
	private final Wgs84Coordinate position;
	
	public Postbox (String name, Wgs84Coordinate position){
		this.name = name;
		this.position = position;
	}

	public Wgs84Coordinate getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
