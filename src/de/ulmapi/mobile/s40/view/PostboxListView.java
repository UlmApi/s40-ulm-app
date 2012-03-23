package de.ulmapi.mobile.s40.view;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;
import java.util.Vector;
 
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

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

import com.nokia.maps.common.GeoCoordinate;
import com.nokia.maps.map.MapCanvas;
import com.nokia.maps.map.MapShapeType;

import de.ioexception.me.http.HttpManager;
import de.ioexception.me.http.HttpResponse;
import de.ioexception.me.http.HttpResponseListener;
import de.ulmapi.mobile.s40.Main;
import de.ulmapi.mobile.s40.bus.gui.HeadingItem;
import de.ulmapi.mobile.s40.bus.gui.LineItem;
import de.ulmapi.mobile.s40.bus.gui.LoadItem;
import de.ulmapi.mobile.s40.bus.gui.OpentimesItem;
import de.ulmapi.mobile.s40.bus.gui.PostkastenItem;
import de.ulmapi.mobile.s40.bus.gui.StationItem;
import de.ulmapi.mobile.s40.bus.gui.StationMapItem;
import de.ulmapi.mobile.s40.view.gui.Refreshable;


public final class PostboxListView extends Form implements CommandListener, ItemCommandListener, ItemStateListener, Refreshable {

	private final Main midlet;

	private final Command backCommand;
	private final Command okCommand;
	private final Command exitCommand;
	private final Command deleteCommand;
	private final Command choiceGrpClick;
	
	private final StringItem stringItem = new StringItem("", "");
	
	public PostboxListView(Main midlet) {
		super(Main.POSTBOX_VIEW_TITLE);

		this.midlet = midlet;

		backCommand = new Command("Zurück", Command.SCREEN, 1);
		okCommand = new Command("OK", Command.ITEM, 1);
		exitCommand = new Command("Ende", Command.EXIT, 1);
		deleteCommand = new Command("Löschen", Command.EXIT, 1);
		choiceGrpClick = new Command("OK", Command.SCREEN, 1);
		
		

		addCommand(backCommand);
		//addCommand(okCommand);
		addCommand(exitCommand);
		setCommandListener(this);
		setItemStateListener(this);
		
		append(stringItem);
		
		//getCurrentWeekday();
		
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
//			
////			Display display = Display.getDisplay(midlet);
////	        MapCanvas mapCanvas = new MapCanvas( display  );
////	        display.setCurrent(mapCanvas);
//	        
//	        Random r = new Random();
//	        for(int i = 0;i<10;i++){
//	        	
//		        mapCanvas.getMapDisplay().addMapObject(mapCanvas.getMapFactory().createStandardMarker(new GeoCoordinate(49f+(r.nextFloat()*0.1), 10f+r.nextFloat()*0.1, 0), 10, "test"+i, MapShapeType.star));
//	        }
//	        
//	        mapCanvas.getMapDisplay().setCenter(new GeoCoordinate(48.7f, 9.7f, 0));
//	        mapCanvas.getMapDisplay().setZoomLevel(10,0,0);
//			
//			GeoCoordinate coord = new GeoCoordinate( 10, 10, 0 ); 
//			
////			Display.getDisplay(midlet).setCurrent(mapCanvas);
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


	public void refresh() {
		append(new LoadItem());
		
		// all postboxes
		String url = "http://daten.ulmapi.de/postkaesten/_all_docs?include_docs=true";
		//System.out.println(url);	
		
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
									//(String) address.get("street"), (String) address.get("plz"), www, tel ));
						}
						showResults();
						
						
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
	}
	
	private String replace(String needle, String replacement, String haystack) {
	    String result = "";
	    int index = haystack.indexOf(needle);
	    if(index==0) {
	        result = replacement+haystack.substring(needle.length());
	        return replace(needle, replacement, result);
	    }else if(index>0) {
	        result = haystack.substring(0,index)+ replacement +haystack.substring(index+needle.length());
	        return replace(needle, replacement, result);
	    }else {
	        return haystack;
	    }
	}
	
	protected static final int MAX_RESULTS = 10;

	private StationMapItem stationMapItem = null;
	private Vector postboxItems = new Vector();

	private LineItem noResultItem = null;
	private HeadingItem headingItem = null;

	private void showResults()
	{
		final Vector resultList = postboxItems;
		final HeadingItem header = headingItem;
		final Form that = this;
		final LineItem noResults = noResultItem;
		final StationMapItem mapItem = stationMapItem;

		Display d = Display.getDisplay(midlet);
		
		d.callSerially(new Runnable()
		{
			public void run()
			{
				that.deleteAll();
				
				if(header != null)
				{
					that.append(header);
				}

				if(mapItem != null)
				{
					that.append(mapItem);
				}

				if(resultList != null && resultList.size() > 0)
				{
					int maxSize = resultList.size();
					
					if(maxSize > MAX_RESULTS)
					{
						maxSize = MAX_RESULTS;
					}

					for(int i = 0; i < maxSize; i++)
					{
						that.append((Item) resultList.elementAt(i));
					}
				}
				else
				{
					that.append(noResults);
				}
			}
		});
	}

	
	public void commandAction(Command c, Displayable d)
	{
		if(c == backCommand)
		{
			midlet.setView(Main.HOME_VIEW);
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