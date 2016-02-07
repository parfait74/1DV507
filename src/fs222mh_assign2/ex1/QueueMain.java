package fs222mh_assign2.ex1;

import java.util.Iterator;

public class QueueMain {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		LinkedQueue lQ = new LinkedQueue();
		
		System.out.println("Adding...\n");
		lQ.enqueue(1);
		lQ.enqueue(2);
		lQ.enqueue(3);
		lQ.enqueue(4);
		lQ.enqueue(5);
		
		System.out.println("Size: " + lQ.size());
		
		System.out.println("Creating Iterator..\n");
		Iterator iterator = lQ.iterator();
		
		System.out.println("\nReturning first element...");
		System.out.println(lQ.first());
		
		System.out.println("\nReturning last element...");
		System.out.println(lQ.last());
		
		System.out.println("\nReturning toString method...");
		System.out.println(lQ.toString());
		
		System.out.println("\nIterating...");
		while(iterator.hasNext())
			System.out.println(iterator.next());
		
		System.out.println("\nDequeueing...\n");
		System.out.println(lQ.dequeue());
		System.out.println(lQ.dequeue());
		System.out.println(lQ.dequeue());
		System.out.println(lQ.dequeue());
		System.out.println(lQ.dequeue());
		
		
		//Not entirely sure I'm supposed to catch the errors here or just use the exception in the code, but unchecked exception it says
		try {
			lQ.dequeue();
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println("No objects in queue.");
		}
		
		try {
			lQ.first();
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println("No objects in queue.");
		}
		
		try {
			lQ.last();
		}
		catch(IndexOutOfBoundsException e) {
			System.err.println("No objects in queue.");
		}

	}

}
