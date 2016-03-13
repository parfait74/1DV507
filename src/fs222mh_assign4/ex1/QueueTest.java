package fs222mh_assign4.ex1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for LinkedQueue
 * @author fredrik
 *
 */
public class QueueTest {
	
	// String queue
	@Test
	public void testString() {
		LinkedQueue<String> stringTest = new LinkedQueue<String>();
		assertTrue(stringTest.isEmpty());		
	}
	
	@Test
	public void testStringEnqueue() {
		LinkedQueue<String> stringTest = new LinkedQueue<String>();
		stringTest.enqueue("hej");
		assertFalse(stringTest.isEmpty());
	}
	
	@Test
	public void testStringFirst() {
		LinkedQueue<String> stringTest = new LinkedQueue<String>();
		stringTest.enqueue("hej");
		stringTest.enqueue("hejsan");
		assertEquals("hej", stringTest.first());
	}
	
	@Test
	public void testStringLast() {
		LinkedQueue<String> stringTest = new LinkedQueue<String>();
		stringTest.enqueue("hej");
		stringTest.enqueue("hejsan");
		assertEquals("hejsan", stringTest.last());
	}
	
	@Test
	public void testStringDequeue() {
		LinkedQueue<String> stringTest = new LinkedQueue<String>();
		stringTest.enqueue("hej");
		stringTest.enqueue("hejsan");
		assertEquals("hejsan", stringTest.last());
		stringTest.dequeue();
		stringTest.dequeue();
		assertTrue(stringTest.isEmpty());			
	}
	
	@Test
	public void testStringSize() {
		LinkedQueue<String> StringTest = new LinkedQueue<String>();
		for (int i = 0; i < 20; i += 1) {
			String s = Integer.toString(i);
			StringTest.enqueue(s);
		}
		assertEquals(20, StringTest.size());
	}

	
	// Integer queue
	@Test
	public void testInt() {
		LinkedQueue<Integer> intTest = new LinkedQueue<Integer>();
		assertTrue(intTest.isEmpty());		
	}
	
	@Test
	public void testIntEnqueue() {
		LinkedQueue<Integer> intTest = new LinkedQueue<Integer>();
		intTest.enqueue(1);
		assertFalse(intTest.isEmpty());
	}
	
	@Test
	public void testIntFirst() {
		LinkedQueue<Integer> intTest = new LinkedQueue<Integer>();
		intTest.enqueue(1);
		intTest.enqueue(2);
		assertEquals(Integer.valueOf(1), intTest.first());		// to get assertEqueals to work on integer I got this from http://stackoverflow.com/questions/17468364/can-assertequalslong-integer-succeed
	}
	
	@Test
	public void testIntLast() {
		LinkedQueue<Integer> intTest = new LinkedQueue<Integer>();
		intTest.enqueue(1);
		intTest.enqueue(2);
		assertEquals(Integer.valueOf(2), intTest.last());
	}
	
	@Test
	public void testIntDequeue() {
		LinkedQueue<Integer> intTest = new LinkedQueue<Integer>();
		intTest.enqueue(1);
		intTest.enqueue(2);
		assertEquals(Integer.valueOf(2), intTest.last());
		intTest.dequeue();
		intTest.dequeue();
		assertTrue(intTest.isEmpty());			
	}
	
	@Test
	public void testIntSize() {
		LinkedQueue<Integer> intTest = new LinkedQueue<Integer>();
		for (int i = 0; i < 20; i += 1) {
			intTest.enqueue(i);
		}
		assertEquals(20, intTest.size());


		
	}

}
