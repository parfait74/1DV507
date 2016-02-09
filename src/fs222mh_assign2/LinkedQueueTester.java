package fs222mh_assign2;

import static org.junit.Assert.*;

import org.junit.Test;

import fs222mh_assign2.ex1.LinkedQueue;

public class LinkedQueueTester {
	
	LinkedQueue testQ = new LinkedQueue();
	
	@Test
	public void testIsEmptyWhenEmpty() {
		assertTrue(testQ.isEmpty());		
	}
	
	@Test
	public void testIsEmptyWhenNotEmpty() {
		testQ.enqueue(4);
		assertTrue(!testQ.isEmpty());
	}
	
	@Test
	public void testOneEnqueu() {
		testQ.enqueue(10);
	}
	
	@Test
	public void testOneDequeue() {
		testQ.enqueue(4);
		testQ.dequeue();
	}
	
	@Test (expected=IndexOutOfBoundsException.class)
	public void testOnDequeueWhenEmpty() {
		testQ.dequeue();
	}
	
	@Test
	public void testEmptyAfterDequeue() {
		testQ.enqueue(5);
		testQ.dequeue();
		assertTrue(testQ.isEmpty());
	}
	
	@Test
	public void testOrdering() {
		testQ.enqueue(1);
		testQ.enqueue(2);
		testQ.enqueue(3);
		assertEquals(1,testQ.dequeue());
		assertEquals(2,testQ.dequeue());
		assertEquals(3,testQ.dequeue());
	}
	
	

}
