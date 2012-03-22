package de.ulmapi.mobile.s40.bus.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

import com.nokia.maps.common.GeoCoordinate;
import com.nokia.maps.map.MapCanvas;
import com.nokia.maps.map.MapShapeType;
import com.nokia.maps.map.MapStandardMarker;

import de.ulmapi.mobile.s40.Main;
import de.ulmapi.mobile.s40.bus.data.BusStation;

public class StationMapView extends MapCanvas implements CommandListener{

	private MapStandardMarker marker = null;
	
	private final Command backCommand;
	
	private final Main midlet;
	
	public StationMapView(Main midlet) {
		super(Display.getDisplay(midlet));
		
		this.midlet = midlet;
		// TODO Auto-generated constructor stub
		backCommand = new Command("Zurück", Command.ITEM, 1);
		addCommand(backCommand);
		setCommandListener(this);
	}

	public void commandAction(Command c, Displayable d)
	{
//		System.out.println(c);
		if(c == backCommand)
		{
			midlet.setView(Main.STATION_DETAILS_VIEW);
		}
	}
	
	public void updateStation(BusStation station){
		if(marker != null){
			map.removeMapObject(marker);
		}
		marker = mapFactory.createStandardMarker(new GeoCoordinate(station.getPosition().getLatitude(), station.getPosition().getLongitude(), 0), 12, station.getName(), MapShapeType.rectangle);
		map.addMapObject(marker);
		map.setCenter(new GeoCoordinate(station.getPosition().getLatitude(), station.getPosition().getLongitude(), 0));
		map.setZoomLevel(15,0,0);
	}
	
}
