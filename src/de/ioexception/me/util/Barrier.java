package de.ioexception.me.util;

/**
 * A simple barrier point implementation. Allows multiple threads to wait for a
 * common state. Each party must submit() to the barrier, and the final thread
 * than executes the provided {@link Runnable}
 * 
 * @author Benjamin Erb
 */
public class Barrier
{
	private final int parties;
	private final Runnable runnable;
	private int done = 0;

	public Barrier(int parties, Runnable runnable)
	{
		this.parties = parties;
		this.runnable = runnable;
	}

	public synchronized void submit()
	{
		if(++done == parties)
		{
			runnable.run();
		}
	}
}
