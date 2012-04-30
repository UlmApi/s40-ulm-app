package de.ulmapi.mobile.s40.bus.view;

import java.util.Vector;

import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.TextField;

import de.ioexception.me.util.ExchangeQueue;
import de.ulmapi.mobile.s40.Main;
import de.ulmapi.mobile.s40.bus.data.BusStation;
import de.ulmapi.mobile.s40.bus.data.BusStationProvider;
import de.ulmapi.mobile.s40.bus.data.StationAutoCompletionWorker;

/**
 * @author Tobias Schlecht
 * @author Michael Mueller
 */
public final class StationListView extends Form implements CommandListener, ItemStateListener, ItemCommandListener, BusStationProvider
{
	private final Main midlet;

//	private final Command screenCommand;
	private final Command itemCommand;
	private final Command backCommand;
	private final Command choiceGrpClick;

	private final TextField searchField;
	private final ExchangeQueue exchangeQueue;
	private final ChoiceGroup choiceGrp;

	private final Thread[] pool;
	private static final int WORKER_THREADS = 1;

	private Vector autocompletionResults = null;

	public StationListView(Main midlet)
	{
		super(Main.STATION_LIST_VIEW_TITLE);

		this.midlet = midlet;

		backCommand = new Command("Zurück", Command.BACK, 1);
		itemCommand = new Command("OK", Command.ITEM, 1);
//		exitCommand = new Command("Ende", Command.EXIT, 1);
		choiceGrpClick = new Command("OK", Command.SCREEN, 1);

//		addCommand(screenCommand);
		addCommand(itemCommand);
		addCommand(backCommand);
		setCommandListener(this);

		setItemStateListener(this);
		searchField = new TextField("Ihre Eingabe:", "", 64, TextField.ANY);
		searchField.setItemCommandListener(this);
		append(searchField);

		choiceGrp = new ChoiceGroup("Vorschläge", Choice.EXCLUSIVE, new String[] {}, null);
		choiceGrp.setItemCommandListener(this);
		choiceGrp.addCommand(choiceGrpClick);
		append(choiceGrp);

		// asynchronous auto-completion
		
		exchangeQueue = new ExchangeQueue();
		pool = new Thread[WORKER_THREADS];

		for(int i = 0; i < pool.length; i++)
		{
			pool[i] = new Thread(new StationAutoCompletionWorker(exchangeQueue, this));
			pool[i].start();
		}
	}

	public void start()
	{

	}

	public void commandAction(Command c, Displayable d)
	{
		if(c == backCommand)
		{
			midlet.setView(Main.HOME_VIEW);
		}
		else if(c == itemCommand)
		{
			gotoStationList();
		}
//		else if(c == exitCommand)
//		{
//			midlet.destroyApp(false);
//			midlet.notifyDestroyed();
//		}
	}

	private void gotoStationList()
	{
		if(autocompletionResults.size() > 0)
		{
			midlet.setView(Main.STATION_DETAILS_VIEW);
		}
	}

	/**
	 * Display the auto-completion results in the choice group.
	 * 
	 * @param results
	 */
	public void fill(Vector results)
	{
		BusStation station;
		String title;
		autocompletionResults = results;

		choiceGrp.deleteAll();
		
		for(int i = 0; i < results.size(); i++)
		{
			station = (BusStation) results.elementAt(i);
			title = station.getName();

			choiceGrp.append(title + " (" + station.getPlace() + ")", null);
			choiceGrp.setFont(i, Font.getFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
		}
	}

	public void itemStateChanged(Item c)
	{
		if(c == choiceGrp)
		{
			gotoStationList();
		}
		else
		{
			try
			{
				if(searchField.getString().equals(""))
				{
					choiceGrp.deleteAll();
				}

				if(searchField.getString().length() >= 1)
				{
					exchangeQueue.put(searchField.getString());
				}
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public BusStation getSelectedStation()
	{
		return (BusStation) autocompletionResults.elementAt(choiceGrp.getSelectedIndex());
	}

	public void commandAction(Command arg0, Item arg1)
	{

	}
}
