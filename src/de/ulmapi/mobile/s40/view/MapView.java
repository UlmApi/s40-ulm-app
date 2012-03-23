package de.ulmapi.mobile.s40.view;

import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

import com.nokia.maps.common.GeoCoordinate;
import com.nokia.maps.map.MapCanvas;
import com.nokia.maps.map.MapShapeType;
import com.nokia.maps.map.MapStandardMarker;

import de.ioexception.me.http.HttpManager;
import de.ioexception.me.http.HttpResponse;
import de.ioexception.me.http.HttpResponseListener;
import de.ioexception.me.util.Wgs84Coordinate;
import de.ulmapi.mobile.s40.Main;
import de.ulmapi.mobile.s40.bus.data.BusStation;
import de.ulmapi.mobile.s40.bus.gui.PostkastenItem;

public class MapView extends MapCanvas implements CommandListener{
	
	private int mapMode = Main.HOME_VIEW;
	private Wgs84Coordinate mapCenter;
	
	protected static final int POSTBOXES_MAX_RESULTS = 20;
	private Vector postboxVector;

	private final Command backCommand;
	
	private final Main midlet;
	
	public MapView(Main midlet) {
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
			//TODO je nach Map Mode anderes back
			if (mapMode == Main.STATION_MAP_VIEW){
				midlet.setView(Main.STATION_DETAILS_VIEW);
			}
			else if (mapMode == Main.POSTBOX_VIEW){
				midlet.setView(Main.HOME_VIEW);
			}
			else {
				midlet.setView(Main.HOME_VIEW);
			}
		}
	}
	
	public void setMapMode(int mapMode){
		this.mapMode = mapMode;
		map.removeAllMapObjects();
		
//		if (mapMode == Main.STATION_MAP_VIEW){
//		}
//		else if (mapMode == Main.POSTBOX_VIEW){
//		}
//		else {
//		}
	}
	
	public void updateStation(BusStation station){
//		if(marker != null){
//			map.removeMapObject(marker);
//		}
		MapStandardMarker marker = mapFactory.createStandardMarker(new GeoCoordinate(station.getPosition().getLatitude(), station.getPosition().getLongitude(), 0), 12, station.getName(), MapShapeType.rectangle);
		map.addMapObject(marker);
		map.setCenter(new GeoCoordinate(station.getPosition().getLatitude(), station.getPosition().getLongitude(), 0));
		map.setZoomLevel(15,0,0);
	}
	
	public void updatePostboxes(){
		String url = "http://daten.ulmapi.de/postkaesten/_all_docs?include_docs=true";
		HttpManager http = HttpManager.getInstance();
		
		http.get(url, new HttpResponseListener() {
			public void responseReceived(HttpResponse response) {
				if(response.getStatusCode() == 200){
						JSONObject json;
						Wgs84Coordinate postboxCoordinate;
						MapStandardMarker marker;
						
						try {
							json = new JSONObject(new String(response.getEntity()));
							JSONArray jsonPostboxArray = (JSONArray) json.get("rows");
							
							for (int i = 0; i < POSTBOXES_MAX_RESULTS; i++) {
								JSONObject jsonObject = (JSONObject) jsonPostboxArray.get(i);
								JSONObject jsonPostbox = (JSONObject) jsonObject.get("doc");
								String name = "";
								
								if (jsonPostbox.has("name"))
									name += (String) jsonPostbox.getString("name") + "\n" ;
	
								if (jsonPostbox.has("description"))
									name += (String) jsonPostbox.getString("description") + "\n" ;
	
								if (jsonPostbox.has("ref"))
									name += (String) jsonPostbox.getString("ref") + "\n" ;
	
								postboxVector.addElement(new PostkastenItem(name));
								
								postboxCoordinate = new Wgs84Coordinate(Double.parseDouble(jsonPostbox.getString("lat")), Double.parseDouble(jsonPostbox.getString("lon"))) ;
								marker = mapFactory.createStandardMarker(new GeoCoordinate(postboxCoordinate.getLatitude(), postboxCoordinate.getLongitude(), 0), 12, "", MapShapeType.rectangle);
								map.addMapObject(marker);
								System.out.println("added " + postboxCoordinate.getLatitude() + ", " + postboxCoordinate.getLongitude());
										//(String) address.get("street"), (String) address.get("plz"), www, tel ));
							}

						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
		});
		
		mapCenter = new Wgs84Coordinate(48.3949985d, 10.001052100000001d);
		map.setCenter(new GeoCoordinate(mapCenter.getLatitude(), mapCenter.getLongitude(),0));
		map.setZoomLevel(15,0,0);
	}
	
}
