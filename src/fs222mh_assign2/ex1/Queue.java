package fs222mh_assign2.ex1;

/**
 * This is an interface for a queue. The common methods used to manipulate a queue are within
 * this interface.
 */

import java.util.Iterator;

public interface Queue {
	/**
	 * Current queue size
	 * @return <code>int</code> of the size
	 */
	public int size();                     
	/**
	 * True if queue is empty
	 * @return <code>boolean</code> <code>true</code> if queue is empty
	 */
	public boolean isEmpty();              
	/**
	 * Add element at end of queue
	 * @param <code>element</code>
	 */
	public void enqueue(Object element);   
	/**
	 * Return and remove first element
	 * @return
	 */
	public Object dequeue();               
	/**
	 * Return without removing first element
	 * @return <code>object</code> 
	 */
	public Object first();                 
	/**
	 * Return without removing last element
	 * @return <code>object</code>
	 */
	public Object last();                  
	/**
	 * Return a string representation of the queue
	 * @return <code>String</code>
	 */
	public String toString();              
	/**
	 * Returns an iterator for the queue
	 * @return <code><i>new</i>Iterator</code>
	 */
	@SuppressWarnings("rawtypes")
	public Iterator iterator();            

}
