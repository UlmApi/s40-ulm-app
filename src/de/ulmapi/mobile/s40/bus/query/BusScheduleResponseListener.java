package de.ulmapi.mobile.s40.bus.query;

import de.ioexception.me.http.HttpResponse;
import de.ioexception.me.http.HttpResponseListener;

interface BusScheduleResponseListener extends HttpResponseListener{

	public abstract void responseReceived(HttpResponse response);

}