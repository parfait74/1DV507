package fs222mh_assign4.ex6;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {

	@Test
	public void testIsEmpty() {
		BinaryIntHeap heap = new BinaryIntHeap();
		assertTrue(heap.isEmpty());
		heap.insert(1);
		assertFalse(heap.isEmpty());
	}
	
	
	@Test
	public void testSize() {
		BinaryIntHeap heap = new BinaryIntHeap();
		heap.insert(1);
		heap.insert(3);
		heap.insert(6);
		heap.insert(5);
		heap.insert(6);
		heap.insert(8);
		assertEquals(6, heap.size());
		heap.insert(9);
		assertEquals(7, heap.size());
	}
	
	@Test
	public void testPullHighest() {
		BinaryIntHeap heap = new BinaryIntHeap();
		heap.insert(1);
		heap.insert(3);
		heap.insert(6);
		heap.insert(5);
		heap.insert(6);
		heap.insert(8);
		assertEquals(1, heap.pullHighest());
		assertEquals(3, heap.pullHighest());
		heap.insert(2);
		assertEquals(2, heap.pullHighest());

	} 

}

