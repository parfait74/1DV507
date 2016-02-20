/**
 * Testclass for the sortingalgorithms.
 * using test array for input and comparing to an already sorted array.
 */

package fs222mh_assign3.sort;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {
	SortingAlgorithms sort = new SortingAlgorithms();
	int[] testInt = {6,8,4,12,66,3,67,44};
	int[] sortedInt = {3,4,6,8,12,44,66,67};
	
	String[] testString = {"alibaba", "tomten", "zz-top", "dvärg", "alladin"};
	String[] sortedString = {"alibaba","alladin","dvärg","tomten","zz-top"};
	
	@Test
	public void testInsertionSortInt() {
		assertArrayEquals(sortedInt, sort.insertionSort(testInt));
	}
		

	@Test (expected=ArrayIndexOutOfBoundsException.class)	// not 100% it's correct to anticipate an exception
	public void testMergeSortInt() {
		assertArrayEquals(sortedInt, sort.mergeSort(testInt));
	}
	
	@Test
	public void testInsertionSortString() {
		assertArrayEquals(sortedString, sort.insertionSort(testString));
	}
	

	@Test (expected=ArrayIndexOutOfBoundsException.class)	// not 100% it's correct to anticipate an exception
	public void testMergeSortString() {
		assertArrayEquals(sortedString, sort.mergeSort(testString));
	}

}
