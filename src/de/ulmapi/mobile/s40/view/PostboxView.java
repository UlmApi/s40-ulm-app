package de.ulmapi.mobile.s40.view;

import java.util.Random;
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
import de.ulmapi.mobile.s40.bus.gui.HeadingItem;
import de.ulmapi.mobile.s40.bus.gui.LineItem;
import de.ulmapi.mobile.s40.bus.gui.LoadItem;
import de.ulmapi.mobile.s40.bus.gui.PostkastenItem;
import de.ulmapi.mobile.s40.bus.gui.StationMapItem;
import de.ulmapi.mobile.s40.postbox.data.*;
import de.ulmapi.mobile.s40.Main;
import de.ulmapi.mobile.s40.view.gui.Refreshable;


public final class PostboxView extends MapCanvas implements CommandListener, Refreshable {

	private final Main midlet;

	private final Command backCommand;
//	private final Command okCommand;
//	private final Command exitCommand;
//	private final Command deleteCommand;
//	private final Command choiceGrpClick;
	
	private Vector postboxes;
	private Wgs84Coordinate location;
	
	public PostboxView(Main midlet) {
		super(Display.getDisplay(midlet));

		this.midlet = midlet;

		backCommand = new Command("Zurück", Command.SCREEN, 1);
//		okCommand = new Command("OK", Command.ITEM, 1);
//		exitCommand = new Command("Ende", Command.EXIT, 1);
//		deleteCommand = new Command("Löschen", Command.EXIT, 1);
//		choiceGrpClick = new Command("OK", Command.SCREEN, 1);
		
	
		

		addCommand(backCommand);
//		addCommand(okCommand);
//		addCommand(exitCommand);
		setCommandListener(this);
	}
		


	public void commandAction(Command c, Displayable d)
	{
		if(c == backCommand)
		{
			midlet.setView(Main.HOME_VIEW);
		}
//		else if(c == okCommand)
//		{
//			HttpManager http = HttpManager.getInstance();
//			http.get("http://daten.ulmapi.de/plz/89231", new HttpResponseListener() {
//				
//				public void responseReceived(HttpResponse response) {
//					if(response.getStatusCode() == 200){
//						
//						JSONObject json;
//						try {
//							json = new JSONObject(new String(response.getEntity()));
//							String s = json.get("_id").toString();
//							stringItem.setLabel(s);
//							stringItem.setText(s);
//							System.out.println(json.toString());
//						} catch (JSONException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						
//					}
//					
//				}
//			});
//			gotoStationList();
//		}
//		else if(c == deleteCommand)
//		{
////			removeFavorite(getSelectedStation());
//		}
//		else if(c == exitCommand)
//		{
//			midlet.destroyApp(false);
//			midlet.notifyDestroyed();
//		}
	}
	
	public void updatePostboxes(){
		/*
		//Aktueller Standort oder Standardkoordinaten
		location = new Wgs84Coordinate(48.398494d, 9.994687d);
		
		//Datenbankabfrage, Postbox erstellen, in Vector adden
		postboxes = new Vector();
		postboxes.addElement(new Postbox("Am Rathaus", new Wgs84Coordinate(48.397494d, 9.994687d)));
		postboxes.addElement(new Postbox("Hafengasse", new Wgs84Coordinate(48.398193d, 9.995957d)));
		postboxes.addElement(new Postbox("Steinerne Bruecke", new Wgs84Coordinate(48.397186d, 9.987659d)));
		System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + postboxes.size() + " + " + postboxes.capacity());
		*/
	}
	
	public void showPostboxes(){
		/*
		Postbox postbox = (Postbox) postboxes.firstElement();
		System.err.println("after postbox");
		 
		MapStandardMarker marker2 = mapFactory.createStandardMarker(new GeoCoordinate(postbox.getPosition().getLatitude(), postbox.getPosition().getLongitude(), 0), 12, postbox.getName(), MapShapeType.star);
		map.addMapObject(marker2);
		
//		postbox = (Postbox) postboxes.lastElement();
//		marker2 = mapFactory.createStandardMarker(new GeoCoordinate(postbox.getPosition().getLatitude(), postbox.getPosition().getLongitude(), 0), 12, postbox.getName(), MapShapeType.car);
//		map.addMapObject(marker2);
		
//		for (int i = 0; i < postboxes.size(); i++){
////			postbox = (Postbox) postboxes.elementAt(i);
////			MapStandardMarker marker = mapFactory.createStandardMarker(new GeoCoordinate(postbox.getPosition().getLatitude(), postbox.getPosition().getLongitude(), 0), 12, postbox.getName(), MapShapeType.star);
////			map.addMapObject(marker);
//		}
		map.setCenter(new GeoCoordinate(location.getLatitude(), location.getLongitude(),0));
		map.setZoomLevel(15,0,0);
		*/
	}
	
	
	protected static final int MAX_RESULTS = 10;

	private StationMapItem stationMapItem = null;
	private Vector postboxItems = new Vector();

	private LineItem noResultItem = null;
	private HeadingItem headingItem = null;

	private MapStandardMarker marker = null;
	public void refresh() {
		//append(new LoadItem());

		String url = "http://daten.ulmapi.de/postkaesten/_all_docs?include_docs=true";
		HttpManager http = HttpManager.getInstance();
		http.get(url, new HttpResponseListener() {
			
		public void responseReceived(HttpResponse response) {
			if(response.getStatusCode() == 200){
				final Vector resultList = postboxItems;
					JSONObject json;
					try {
						json = new JSONObject(new String(response.getEntity()));
						JSONArray foo = (JSONArray) json.get("rows");
						//System.out.println("length: " + foo.length());
						
						for (int i = 0; i < MAX_RESULTS; i++) {
						//for (int i = 0; i < foo.length(); i++) {
							JSONObject bar = (JSONObject) foo.get(i);
							JSONObject foobar = (JSONObject) bar.get("doc");
							String name = "";
							
							if (foobar.has("name"))
								name += (String) foobar.getString("name") + "\n" ;

							if (foobar.has("description"))
								name += (String) foobar.getString("description") + "\n" ;

							if (foobar.has("ref"))
								name += (String) foobar.getString("ref") + "\n" ;

							postboxItems.addElement(new PostkastenItem(name));
							
							location = new Wgs84Coordinate(Double.parseDouble(foobar.getString("lat")), Double.parseDouble(foobar.getString("lon"))) ;
							marker = mapFactory.createStandardMarker(new GeoCoordinate(location.getLatitude(), location.getLongitude(), 0), 12, "", MapShapeType.rectangle);
							//marker = mapFactory.createStandardMarker(new GeoCoordinate(location.getLatitude(), location.getLongitude(), 0), 12, "Postbox", MapShapeType.rectangle);
							map.addMapObject(marker);
							System.out.println("added " + location.getLatitude() + ", " + location.getLongitude());
									//(String) address.get("street"), (String) address.get("plz"), www, tel ));
						}
						//showResults();
						
						
						//String s = json.get("_id").toString();
						//stringItem.setLabel(s);
						//stringItem.setText(s);
						//System.out.println(json.toString());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		
		
		/*
		
		marker = mapFactory.createStandardMarker(new GeoCoordinate(location.getLatitude(), location.getLongitude(), 0), 12, "Postbox", MapShapeType.rectangle);
		map.addMapObject(marker);
		
		location = new Wgs84Coordinate(48.343074899999998d, 10.0352812d);
		marker = mapFactory.createStandardMarker(new GeoCoordinate(location.getLatitude(), location.getLongitude(), 0), 12, "Postbox", MapShapeType.rectangle);
		map.addMapObject(marker);
		*/
		location = new Wgs84Coordinate(48.3949985d, 10.001052100000001d);
		map.setCenter(new GeoCoordinate(location.getLatitude(), location.getLongitude(),0));
		map.setZoomLevel(15,0,0);	
	}
	
}
