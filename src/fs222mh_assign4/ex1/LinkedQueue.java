package fs222mh_assign4.ex1;
/**
 * Copied LinkedQueue from assignment 2. Refined it with the comments given by teachers.
 * Changed it to use <T>
 * Used the downcast to <T> and suppressed the warnings, not sure that's right
 */

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T>{
	
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
	public void enqueue(T element) {
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
	@SuppressWarnings("unchecked")
	@Override
	public T dequeue() throws IndexOutOfBoundsException {
		if (size < 1) {
			throw new IndexOutOfBoundsException();
		}
		Object returnObject = head.data;
		head = head.next;
		size -= 1;
		return (T) returnObject;
	}

	/**
	 * Returns the first object without removing it.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T first() throws IndexOutOfBoundsException{
		if (size > 0) {
			return (T) head.data;
		}
		
		throw new IndexOutOfBoundsException("The queue is empty");
	}

	/**
	 * Return the last object without removing it
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T last() throws IndexOutOfBoundsException {
		if (size > 0) {
			return (T) tail.data;
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
