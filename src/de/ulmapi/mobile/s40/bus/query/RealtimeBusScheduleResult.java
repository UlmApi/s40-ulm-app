package de.ulmapi.mobile.s40.bus.query;

public class RealtimeBusScheduleResult extends BusScheduleResult {

	private final boolean isRealtime;
	
	public RealtimeBusScheduleResult(String destination, String line, int departure, boolean isRealtime) {
		super(destination, line, departure);
		this.isRealtime = isRealtime;
	}
	
	public boolean isRealtime(){
		return isRealtime;
	}

}
