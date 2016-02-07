/**
 * This is an implementation of the Queue Interface. It holds all the common methods
 * to manipulate a queue.
 * The class is a linked queue.
 */

package fs222mh_assign2.ex1;

import java.util.Iterator;

public class LinkedQueue implements Queue{
	
	private int size = 0;
	private Node head = null;
	private Node tail = null;
	
	/**
	 * Class for the nodes keeping one object each.
	 */
	private class Node {
		public Object data;
		public Node next = null;
		
		public Node(Object o) {
			data = o;
		}
	}
	
	/**
	 * Returns current queue size
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Checks if the queue is empty. Returns <code>boolean</code><i>true</i> if empty.
	 */
	@Override
	public boolean isEmpty() {
		return size < 1;
	}

	/**
	 * Adds an element of the type <code>object</code> at the end of the queue.
	 */
	@Override
	public void enqueue(Object element) {
		if(head == null) {
			head = new Node(element);
			tail = head;
		}
		else {
			tail.next = new Node(element);
			tail = tail.next;
		}
		size += 1;		
	}

	/**
	 * Returns and removes the first element.
	 */
	@Override
	public Object dequeue() throws IndexOutOfBoundsException {
		if (size < 1) {
			throw new IndexOutOfBoundsException();
		}
		Object returnObject = head.data;
		head = head.next;
		size -= 1;
		return returnObject;
	}

	/**
	 * Returns the first object without removing it.
	 */
	@Override
	public Object first() throws IndexOutOfBoundsException{
		if (size > 0) {
			return head.data;
		}
		
		throw new IndexOutOfBoundsException("The queue is empty");
	}

	/**
	 * Return the last object without removing it
	 */
	@Override
	public Object last() throws IndexOutOfBoundsException {
		if (size > 0) {
			return tail.data;
		}
		throw new IndexOutOfBoundsException("The queue is empty");
	}

	/**
	 * Returns a string representing the queue.
	 */
	public String toString() {
		String queueString = "[ ";
		Node node = head;
		
		while (node.next != null) {
			queueString += node.data + " | ";
			node = node.next;
		}
		
		queueString += node.data + " ]";
		return queueString;
	}
	
	
	/**
	 * Class for the Iterator
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iterator() {
		Iterator it = new Iterator() {
			
        private Node node = head;   
            
           public boolean hasNext() {
                return node != null;		
       	    }
            
            public Object next() {
            	Object value = node.data;
            	node = node.next;
            	return value;
            }
            
        };
        return it;
	}

}
