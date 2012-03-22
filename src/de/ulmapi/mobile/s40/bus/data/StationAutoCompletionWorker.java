package de.ulmapi.mobile.s40.bus.data;

import java.util.Vector;

import de.ioexception.me.util.BlockingQueue;
import de.ulmapi.mobile.s40.bus.view.StationListView;
import de.ioexception.me.autocomplete.AutoCompletionHandler;

/**
 * A worker that processes enqueued requests through a shared
 * {@link BlockingQueue}.
 * 
 * @author Michael Mueller
 */
public class StationAutoCompletionWorker implements AutoCompletionHandler
{

	private final BlockingQueue requestQueue;
	private boolean running = true;
	private StationListView stationSelection;

	public StationAutoCompletionWorker(BlockingQueue requestQueue, StationListView stationSelection)
	{
		this.requestQueue = requestQueue;
		this.stationSelection = stationSelection;
	}

	public void run()
	{
		String request;
		try
		{
			while(running && (request = ((String) requestQueue.take())) != null)
			{
				handle(request);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public void cancel()
	{
		running = false;
	}

	public String handle(String term)
	{
		Vector results = BusStations.getStationsByPrefix(term, 10);
		stationSelection.fill(results);

		return null;
	}
}
