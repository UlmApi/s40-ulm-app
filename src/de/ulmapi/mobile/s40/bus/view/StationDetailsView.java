package de.ulmapi.mobile.s40.bus.view;

import java.util.Vector;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;

import de.ioexception.me.util.Barrier;
import de.ulmapi.mobile.s40.Main;
import de.ulmapi.mobile.s40.bus.data.BusStation;
import de.ulmapi.mobile.s40.bus.data.BusStations;
import de.ulmapi.mobile.s40.bus.gui.HeadingItem;
import de.ulmapi.mobile.s40.bus.gui.LineItem;
import de.ulmapi.mobile.s40.bus.gui.LoadItem;
import de.ulmapi.mobile.s40.bus.gui.StationItem;
import de.ulmapi.mobile.s40.bus.gui.StationMapItem;
import de.ulmapi.mobile.s40.bus.query.BusScheduleCallback;
import de.ulmapi.mobile.s40.bus.query.BusScheduleProvider;
import de.ulmapi.mobile.s40.bus.query.FSETBusScheduleProvider;
import de.ulmapi.mobile.s40.bus.query.SwuBusScheduleProvider;
import de.ulmapi.mobile.s40.bus.query.BusScheduleResult;
import de.ulmapi.mobile.s40.view.gui.Refreshable;

/**
 * @author Tobias Schlecht
 * @author Michael Mueller
 */
public final class StationDetailsView extends Form implements CommandListener, Refreshable, ItemStateListener
{
	protected static final int MAX_RESULTS = 10;

	private final Main midlet;

	private final Command screenCommand;
	private final Command showMapCommand;
//	private final Command removeFavoriteCommand;
	private final Command exitCommand;
	private final Command refreshCommand;

	private BusStation currentStation;

	private StationMapItem stationMapItem = null;
	private final Vector stationItems = new Vector();

	private LineItem noResultItem = null;
	private HeadingItem headingItem = null;

	private final BusScheduleProvider busScheduleProvider;
//	private final MappingService mappingService;

	public StationDetailsView(Main midlet)
	{
		super(Main.STATION_DETAILS_VIEW_TITLE);

		this.midlet = midlet;

		screenCommand = new Command("Zurück", Command.ITEM, 1);
//		removeFavoriteCommand = new Command("Favorit entfernen", Command.HELP, 1);
		showMapCommand = new Command("Auf Karte zeigen", Command.HELP, 1);
		refreshCommand = new Command("Aktualisieren", Command.HELP, 1);
		exitCommand = new Command("Ende", Command.EXIT, 1);

		addCommand(screenCommand);
		addCommand(showMapCommand);
		addCommand(refreshCommand);
		addCommand(exitCommand);
		setCommandListener(this);
		setItemStateListener(this);

		busScheduleProvider = new FSETBusScheduleProvider();
//		busScheduleProvider = new SwuBusScheduleProvider();

		//		mappingService = new BingMapsProvider();
	}

	public void commandAction(Command c, Displayable d)
	{
		if(c == screenCommand)
		{
			midlet.goBack();
		}
		else if(c == refreshCommand)
		{
			refresh(false);
		}
		else if(c == showMapCommand)
		{
			StationMapView stationMapView = (StationMapView) midlet.getView(Main.STATION_MAP_VIEW);
			stationMapView.updateStation(currentStation);
			midlet.setView(Main.STATION_MAP_VIEW);
		}
		else if(c == exitCommand)
		{
			midlet.destroyApp(false);
			midlet.notifyDestroyed();
		}
	}



	private void showResults()
	{
		final Vector resultList = stationItems;
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

	public void refresh()
	{
		refresh(true);
	}

	public void refresh(boolean updateStation)
	{
		if(updateStation || currentStation == null)
		{
			StationListView stationListView = (StationListView)midlet.getView(Main.STATION_LIST_VIEW);
			currentStation = stationListView.getSelectedStation();
		}

		deleteAll();

		append(new LoadItem());

		stationItems.removeAllElements();
		stationMapItem = null;

		final Vector resultList = stationItems;

//		if(midlet.getFavoriteList().isFavorite(currentStation.getId()))
//		{
//			showFavoriteCommand(removeFavoriteCommand);
//		}
//		else
//		{
//			showFavoriteCommand(addFavoriteCommand);
//		}

		headingItem = new HeadingItem(currentStation.getName(), currentStation.getPlace());
		noResultItem = new LineItem("Keine Treffer!");

		final Barrier b = new Barrier(1, new Runnable()
		{
			public void run()
			{
				showResults();
			}
		});

		busScheduleProvider.getSchedule(currentStation, new BusScheduleCallback()
		{
			public void handleSchedule(Vector results)
			{
				if(results.size() > 1)
				{
					for(int i = 0; i < results.size(); i++)
					{
						BusScheduleResult result = (BusScheduleResult) results.elementAt(i);
						resultList.addElement(new StationItem(result.getLine(), result.getDestination(), result.getDeparture()));
					}
				}
				
				b.submit();
			}
		});

//		mappingService.getMap(currentStation.getPosition().getLatitude(), currentStation.getPosition().getLongitude(), 15, 225, 94, new MapsCallback()
//		{
//			public void handleMap(Image mapImage)
//			{
//				stationMapItem = new StationMapItem(mapImage);
//				
//				b.submit();
//			}
//		});
	}

	public void itemStateChanged(Item arg0)
	{
		
	}
}
