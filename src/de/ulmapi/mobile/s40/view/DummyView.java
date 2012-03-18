package de.ulmapi.mobile.s40.view;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;

import org.json.me.JSONException;
import org.json.me.JSONObject;

import com.nokia.maps.common.GeoCoordinate;
import com.nokia.maps.map.MapCanvas;
import com.nokia.maps.map.MapShapeType;

import de.ioexception.me.http.HttpManager;
import de.ioexception.me.http.HttpResponse;
import de.ioexception.me.http.HttpResponseListener;
import de.ulmapi.mobile.s40.Main;


public final class DummyView extends Form implements CommandListener, ItemCommandListener, ItemStateListener{

	private final Main midlet;

	private final Command backCommand;
	private final Command okCommand;
	private final Command exitCommand;
	private final Command deleteCommand;
	private final Command choiceGrpClick;
	
	private final StringItem stringItem = new StringItem("", "");;
	
	public DummyView(Main midlet) {
		super(Main.DUMMY_VIEW_TITLE);

		this.midlet = midlet;

		backCommand = new Command("Zurück", Command.SCREEN, 1);
		okCommand = new Command("OK", Command.ITEM, 1);
		exitCommand = new Command("Ende", Command.EXIT, 1);
		deleteCommand = new Command("Löschen", Command.EXIT, 1);
		choiceGrpClick = new Command("OK", Command.SCREEN, 1);
		
	
		

		addCommand(backCommand);
		addCommand(okCommand);
		addCommand(exitCommand);
		setCommandListener(this);
		setItemStateListener(this);
		
		append(stringItem);
		
//		zr
//		String[] strings = {"a","b"};
//		
//		List list = new List("foo", List.IMPLICIT, strings, imgs);
//		
		
		try{
			String[] items = new String[]{"Item 1", "Item 2", "Item 3"};
			Image[] imgs = {Image.createImage("/stationListView.png"),Image.createImage("/stationListView.png"),Image.createImage("/stationListView.png")};
//			CanvasList myCanvas = new CanvasList("Test canvas", items, imgs);
			List list = new List("foo", List.IMPLICIT, items, imgs);
//			Display.getDisplay(midlet).setCurrent(list);	
			
			Display display = Display.getDisplay(midlet);
	        MapCanvas mapCanvas = new MapCanvas( display  );
	        display.setCurrent(mapCanvas);
	        
	        mapCanvas.getMapDisplay().addMapObject(mapCanvas.getMapFactory().createStandardMarker(new GeoCoordinate(49, 10, 0), 10, "test", MapShapeType.baloon));
			
			GeoCoordinate coord = new GeoCoordinate( 10, 10, 0 ); 
			
			Display.getDisplay(midlet).setCurrent(mapCanvas);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
//		append(new StationItem("asd", "asfdasd", 21));
//		append(new StationItem("asd", "asfdasd", 21));

	}

	public void itemStateChanged(Item item) {
		// TODO Auto-generated method stub
		
	}

	public void commandAction(Command c, Item item) {
		// TODO Auto-generated method stub
		
	}



	public void commandAction(Command c, Displayable d)
	{
		if(c == backCommand)
		{
			midlet.goBack();
		}
		else if(c == okCommand)
		{
			HttpManager http = HttpManager.getInstance();
			http.get("http://daten.ulmapi.de/plz/89231", new HttpResponseListener() {
				
				public void responseReceived(HttpResponse response) {
					if(response.getStatusCode() == 200){
						
						JSONObject json;
						try {
							json = new JSONObject(new String(response.getEntity()));
							String s = json.get("_id").toString();
							stringItem.setLabel(s);
							stringItem.setText(s);
							System.out.println(json.toString());
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
			});
//			gotoStationList();
		}
		else if(c == deleteCommand)
		{
//			removeFavorite(getSelectedStation());
		}
		else if(c == exitCommand)
		{
			midlet.destroyApp(false);
			midlet.notifyDestroyed();
		}
	}
	
}
