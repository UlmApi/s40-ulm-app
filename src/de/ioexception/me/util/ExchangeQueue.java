package de.ioexception.me.util;

/**
 * @author Benjamin Erb
 */
public class ExchangeQueue extends VectorBlockingQueue
{
	private final int capacity = 1;

	public synchronized void put(Object obj) throws InterruptedException
	{
		// before putting ensure that size == 0
		
		this.internalQueue.removeAllElements();

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
}
