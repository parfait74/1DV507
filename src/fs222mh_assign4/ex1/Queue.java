package fs222mh_assign4.ex1;

import java.util.Iterator;

public interface Queue<T> {
	public int size();						// current queue size
	public boolean isEmpty();				// true if queue is empty
	public void enqueue(Object element);	// add element at end of queue
	public Object dequeue();				// return and remove first element
	public Object first();					// return (without removing) first element
	public Object last();					// return (withour removing) last element
	public String toString();				// return a string representation of the queue content
	@SuppressWarnings("rawtypes")
	public Iterator iterator();				// element iterator

}
