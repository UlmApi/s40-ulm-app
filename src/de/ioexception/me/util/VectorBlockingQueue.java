package de.ioexception.me.util;

import java.util.Vector;

/**
 * A thread-safe bounded blocking queue that is backed by a {@link Vector}.
 * 
 * @author Benjamin Erb
 */
public class VectorBlockingQueue implements BlockingQueue
{
	protected final Vector internalQueue;
	private final int capacity;
	private final static int MAXIMUM_DEFAULT_CAPACITY = 256;

	/**
	 * Creates a Vector-backed {@link BlockingQueue} with the default capacity.
	 */
	public VectorBlockingQueue()
	{
		this(MAXIMUM_DEFAULT_CAPACITY);
	}

	/**
	 * Creates a Vector-backed {@link BlockingQueue} with a custom capacity.
	 * 
	 * @throws IllegalArgumentException Non-positive capacity value
	 */
	public VectorBlockingQueue(int capacity) throws IllegalArgumentException
	{
		if(capacity > 0)
		{
			this.capacity = capacity;
		}
		else
		{
			throw new IllegalArgumentException("invalid capacity!");
		}
		
		internalQueue = new Vector();
	}

	public synchronized void put(Object obj) throws InterruptedException
	{
		while(this.internalQueue.size() == this.capacity)
		{
			wait();
		}
		
		if(this.internalQueue.size() == 0)
		{
			notifyAll();
		}
		
		this.internalQueue.addElement(obj);
	}

	public synchronized Object take() throws InterruptedException
	{
		while(this.internalQueue.size() == 0)
		{
			wait();
		}
		
		if(this.internalQueue.size() == this.capacity)
		{
			notifyAll();
		}
		
		Object e = this.internalQueue.firstElement();
		this.internalQueue.removeElementAt(0);
		
		return e;
	}

	public synchronized void clear() throws InterruptedException
	{
		throw new RuntimeException("not yet implemented");
	}
}
