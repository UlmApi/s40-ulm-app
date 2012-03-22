package de.ulmapi.mobile.s40.view.gui;

/**
 * An interface for forms that need to be refreshed when opened. These are
 * especially forms that need to access data from previous forms.
 * 
 * @author Benjamin Erb
 */
public interface Refreshable
{
	/**
	 * Prepare form interface. Access data from previous forms, if necessary.
	 */
	public void refresh();
}
