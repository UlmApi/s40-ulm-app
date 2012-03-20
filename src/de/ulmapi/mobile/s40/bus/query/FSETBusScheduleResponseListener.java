package de.ulmapi.mobile.s40.bus.query;

import java.util.Stack;
import java.util.Vector;

import org.json.me.JSONArray;
import org.json.me.JSONException;
import org.json.me.JSONObject;

import de.ioexception.me.http.HttpResponse;

public class FSETBusScheduleResponseListener implements BusScheduleResponseListener {

	private final BusScheduleCallback callback;
	private final Vector results;

	private final Stack currentElement = new Stack();

	public FSETBusScheduleResponseListener(BusScheduleCallback callback)
	{
		this.callback = callback;
		
		results = new Vector();
	}
	
	public void responseReceived(HttpResponse response){
		
		if(response.getStatusCode() == 200){
			try {
				JSONObject jsonObj = new JSONObject(new String(response.getEntity()));
				System.out.println(jsonObj.toString());
				JSONArray departures =  jsonObj.getJSONArray("departures");
				for(int i = 0;i<departures.length();i++){
					JSONObject departure = departures.getJSONObject(i);
					String line = departure.optString("line","?");
					String direction = departure.optString("direction","unbekannt");
					int countdown = Integer.parseInt(departure.optString("countdown","-1"));
					boolean realtime = (departure.optString("realtime","0").equals("1"));
					
					results.addElement(new RealtimeBusScheduleResult(direction,line,countdown,realtime));					
				}
					
			} catch (JSONException e) {
				//ignore parse errors, will lead to empty result set.
			}
		}

		callback.handleSchedule(results);

	}
}
