package de.ulmapi.mobile.s40.bus.query;

import de.ioexception.me.http.Http;
import de.ioexception.me.http.HttpManager;
import de.ulmapi.mobile.s40.bus.data.BusStation;

public class FSETBusScheduleProvider implements BusScheduleProvider{

	public static String URI = "http://h.fs-et.de/api.php";
	
	private final HttpManager http;

	public FSETBusScheduleProvider()
	{
		this.http = HttpManager.getInstance();
	}


	public void getSchedule(BusStation station, BusScheduleCallback callback)
	{
		System.out.println(station.getId());
		System.out.println(station.getShortId());
		String queryString = "?id="+station.getShortId()+"&limit=21&platform=";

		http.request(Http.GET, URI+queryString).header(Http.PRAGMA, "no-cache").header(Http.CACHE_CONTROL, "no-cache").send(new FSETBusScheduleResponseListener(callback));
	}

}
