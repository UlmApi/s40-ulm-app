package de.ulmapi.mobile.s40.bus.query;

import java.util.Vector;

/**
 * Callback interface for schedule results.
 * 
 * @author Benjamin Erb
 */
public interface BusScheduleCallback
{
	/**
	 * Handle the result list of {@link BusScheduleResult}s.
	 * 
	 * @param results
	 */
	public void handleSchedule(Vector results);
}
