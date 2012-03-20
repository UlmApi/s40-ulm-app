package de.ulmapi.mobile.s40;

import java.util.Stack;

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
import de.ulmapi.mobile.s40.view.SplashView;
import de.ulmapi.mobile.s40.view.gui.Refreshable;

public final class Main extends MIDlet
{
	public static final int HOME_VIEW = 10;
	public static final int INFO_VIEW = 11;

	public static final int DUMMY_VIEW = 99;

	public static final int STATION_DETAILS_VIEW = 20;
	public static final int STATION_LIST_VIEW = 21;
	public static final int STATION_MAP_VIEW = 22;
	
	public static final String HOME_VIEW_TITLE = "OpenUlmApp";
	public static final String INFO_VIEW_TITLE = "Informationen";
	public static final String DUMMY_VIEW_TITLE = "Abfahrtszeiten";
	
	public static final String STATION_LIST_VIEW_TITLE = "Haltestellen";
	public static final String STATION_DETAILS_VIEW_TITLE = "Abfahrtszeiten";
	

	private SplashView splashView;
	private HomeView homeView;
	private DummyView dummyView;
	
	private StationListView stationListView;
	private StationDetailsView stationDetailsView;
	private StationMapView stationMapView; 
	
	private InfoView infoView;

	private Stack viewHistory;

	public Main()
	{
		viewHistory = new Stack();
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
			stationMapView = new StationMapView(this);
		
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
//		System.out.println(viewCode);
		switch(viewCode)
		{
			case HOME_VIEW: 				return homeView;
			
			case DUMMY_VIEW: 				return dummyView;
			
			case INFO_VIEW: 				return infoView;
	
			case STATION_LIST_VIEW: 		return stationListView;
			case STATION_DETAILS_VIEW: 		return stationDetailsView;
			case STATION_MAP_VIEW:			return stationMapView;
			
			default: 						return homeView;
		}
	}

	public void setView(int viewCode)
	{
		addToViewHistory(viewCode);

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

	public int getPreviousView()
	{
		if(viewHistory.size() > 1)
		{
			return ((Integer) viewHistory.elementAt(viewHistory.size() - 2)).intValue();
		}
		else
		{
			return HOME_VIEW;
		}
	}

	public void goBack()
	{
		if(viewHistory.size() == 1)
		{
			setView(Main.HOME_VIEW);
		}
		else if(viewHistory.size() == 2)
		{
			setView(((Integer) viewHistory.elementAt(0)).intValue());
		}
		else if(viewHistory.size() == 3)
		{
			setView(((Integer) viewHistory.elementAt(1)).intValue());
		}
	}

	private void addToViewHistory(int viewCode)
	{
		if(viewCode >= 1 && viewCode <= 4)
		{
			viewHistory.removeAllElements();
			viewHistory.push(new Integer(viewCode));
		}
		else if(viewCode == 5)
		{
			if(viewHistory.size() == 1)
			{
				viewHistory.push(new Integer(viewCode));
			}
			else if(viewHistory.size() == 3)
			{
				viewHistory.pop();
			}
		}
		else if(viewCode == 6)
		{
			viewHistory.push(new Integer(viewCode));
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
