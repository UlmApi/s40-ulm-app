package de.ulmapi.mobile.s40.bus.data;


/**
 * An interface for view components that provide a choice of a
 * {@link BusStation}. It defines a method that should be called in order to
 * retrieve the selected {@link BusStation}.
 * 
 * @author Benjamin Erb
 */
public interface BusStationProvider
{
	/**
	 * Return the selected {@link BusStation}. This method will be called by the
	 * next view in order to get the selection.
	 * 
	 * @return
	 */
	public BusStation getSelectedStation();
}
