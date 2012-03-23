package de.ulmapi.mobile.s40;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import de.ulmapi.mobile.s40.bus.view.StationDetailsView;
import de.ulmapi.mobile.s40.bus.view.StationListView;
import de.ulmapi.mobile.s40.bus.view.StationMapView;
import de.ulmapi.mobile.s40.view.DummyView;
import de.ulmapi.mobile.s40.view.HomeView;
import de.ulmapi.mobile.s40.view.InfoView;
import de.ulmapi.mobile.s40.view.MapView;
import de.ulmapi.mobile.s40.view.OpentimesView;
import de.ulmapi.mobile.s40.view.PostboxView;
import de.ulmapi.mobile.s40.view.PostboxListView;
import de.ulmapi.mobile.s40.view.SplashView;
import de.ulmapi.mobile.s40.view.gui.Refreshable;

public final class Main extends MIDlet
{
	public static final int HOME_VIEW = 1;
	public static final int INFO_VIEW = 2;

	public static final int DUMMY_VIEW = 90;
	public static final int OPENTIMES_VIEW = 70;

	public static final int STATION_LIST_VIEW = 20;
	public static final int STATION_DETAILS_VIEW = 21;
	public static final int STATION_MAP_VIEW = 22;
	
	public static final int POSTBOX_VIEW = 30;
	public static final int MAP_VIEW = 40;
	
	public static final String HOME_VIEW_TITLE = "OpenUlmApp";
	public static final String INFO_VIEW_TITLE = "Informationen";
	public static final String DUMMY_VIEW_TITLE = "Abfahrtszeiten";
	public static final String OPENTIMES_VIEW_TITLE = "Was hat offen?";
	public static final String POSTBOX_VIEW_TITLE = "Postkästen";
//	public static final String MAP_VIEW_TITLE = "Postkästen";
	
	public static final String STATION_LIST_VIEW_TITLE = "Haltestellen";
	public static final String STATION_DETAILS_VIEW_TITLE = "Abfahrtszeiten";
	

	private SplashView splashView;
	private HomeView homeView;
	private DummyView dummyView;
	
	private StationListView stationListView;
	private StationDetailsView stationDetailsView;
	private StationMapView stationMapView; 
	
	private InfoView infoView;
	
	private PostboxView postboxView;
	//private PostkastenView postboxView;
	private MapView mapView;
	
	private OpentimesView opentimesView;


	public Main()
	{

		splashView = new SplashView(this);
		

	}

	public void startApp() throws MIDletStateChangeException
	{
		Displayable current = Display.getDisplay(this).getCurrent();

		if(current == null)
		{
			Display.getDisplay(this).setCurrent(splashView);

			homeView = new HomeView(this);
			infoView = new InfoView(this);
			dummyView = new DummyView(this);

			stationListView = new StationListView(this);
			stationDetailsView = new StationDetailsView(this);
			//stationMapView = new StationMapView(this);
			
			postboxView = new PostboxView(this);
			//postboxView = new PostkastenView(this);
			mapView = new MapView(this);
			
			opentimesView = new OpentimesView(this);
		}
	}

	public void pauseApp()
	{

	}

	public void destroyApp(boolean unconditional)
	{

	}


	public Displayable getView(int viewCode)
	{

//		switch(viewCode)
//		{
//			case HOME_VIEW: 				return homeView;
//			
//			case DUMMY_VIEW: 				return dummyView;
//			
//			case INFO_VIEW: 				return infoView;
//	
//			case STATION_LIST_VIEW: 		return stationListView;
//			case STATION_DETAILS_VIEW: 		return stationDetailsView;
//			case STATION_MAP_VIEW:			return stationMapView;
//			
//			case POSTBOX_VIEW:				return postboxView;
//			
//			case MAP_VIEW:					return mapView;
//			
//			case OPENTIMES_VIEW:			return opentimesView;
//			
//			default: 						return homeView;
//		}
		switch(viewCode)
		{
			case HOME_VIEW: 				return new HomeView(this);

			case INFO_VIEW: 				return new InfoView(this);
	
			case STATION_LIST_VIEW: 		return new StationListView(this);
			case STATION_DETAILS_VIEW: 		return new StationDetailsView(this);
			case STATION_MAP_VIEW:			return new StationMapView(this);
			
			//case POSTBOX_VIEW:				return postboxView;
			
			case MAP_VIEW:					return new MapView(this);
			
			case OPENTIMES_VIEW:			return new OpentimesView(this);
			
			default: 						return new HomeView(this);
		}
	}

	public void setView(int viewCode)
	{


		Displayable view = getView(viewCode);

		getDisplay().setCurrent(view);

		if(view instanceof Refreshable)
		{
			try
			{
				((Refreshable) view).refresh();
			}
			catch(RuntimeException e)
			{
				e.printStackTrace();
			}
		}
	}


	public Display getDisplay()
	{
		return Display.getDisplay(this);
	}

	public HomeView getHome()
	{
		return homeView;
	}


}
