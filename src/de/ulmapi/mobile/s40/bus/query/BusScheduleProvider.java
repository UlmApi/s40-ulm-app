package de.ulmapi.mobile.s40.bus.query;

import de.ulmapi.mobile.s40.bus.data.BusStation;

public interface BusScheduleProvider {

	/**
	 * Dispatches a request against the SWU website fetching the Ajax response.
	 * 
	 * @param station
	 * @param callback
	 */
	public abstract void getSchedule(BusStation station,
			BusScheduleCallback callback);

}