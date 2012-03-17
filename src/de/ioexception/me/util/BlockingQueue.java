package de.ioexception.me.util;

/**
 * A generic blocking queue interface. A blocking queue allows consumer/producer
 * management through a shared queue. Producers can only add to the queue unless
 * it is not full, otherwise they have to wait. Consumers will be paused while
 * taking from the queue until there are new items available.
 * 
 * @author Benjamin Erb
 */
public interface BlockingQueue
{
	/**
	 * Put a new item into the queue, or wait (block) if the queue is full.
	 * 
	 * @param obj
	 */
	public void put(Object obj) throws InterruptedException;

	/**
	 * Take (and remove) an item from the queue, wait (block) until there is a
	 * new item available.
	 * 
	 * @return
	 */
	public Object take() throws InterruptedException;

	/**
	 * Remove all items from the queue.
	 */
	public void clear() throws InterruptedException;
}
