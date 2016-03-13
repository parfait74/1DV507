package fs222mh_assign4.ex6;

/**
 * This one helped a lot http://www.algolist.net/Data_structures/Binary_heap
 * @author fredrik
 *
 */

public class BinaryIntHeap {
	private int size;
	private int[] heapData;	// need an array to start with
	
	//constructor
	public BinaryIntHeap() {
		heapData = new int[100];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size < 1;
	}
	
	public void insert(int n) {
		if (size == heapData.length) {
			
		} else {
			size += 1;
			heapData[size - 1] = n;
			percolateUp(size -1);			
		}					
	}
	
	/**
	 * Information from http://www.algolist.net/Data_structures/Binary_heap/Remove_minimum
	 * @return
	 */
	public int pullHighest() {
		int root = heapData[0];
		heapData[0] = heapData[size - 1];
		size -= 1;
		if (size > 0) {
			percolateDown(0);
		}
		return root;
	}
	
	/**
	 * Got information from http://stackoverflow.com/questions/18241192/implement-heap-using-a-binary-tree
	 * @param index
	 */
	private void percolateUp(int index) {
		if (index != 0) {
			int parent = index / 2;
			if (heapData[parent] > heapData[index]) {
				int tmp = heapData[parent];
				heapData[parent] = heapData[index];
				heapData[index] = tmp;
				percolateUp(parent);
			}		
		}
	}
	
	/**
	 * Information from http://www.algolist.net/Data_structures/Binary_heap/Remove_minimum
	 * @param index
	 */
	private void percolateDown(int index) {
		int leftChild = index * 2;
		int rightChild = leftChild + 1;
		int minIndex;
		if (rightChild >= size) {
			if (leftChild >= size) {
				return;
			} else {
				minIndex = leftChild;
			}
		} else {
			if (heapData[leftChild] <= heapData[rightChild]) {
				minIndex = leftChild;
			} else {
				minIndex = rightChild;
			}
		}
		
		if (heapData[index] >= heapData[minIndex]) {
			int tmp = heapData[minIndex];
			heapData[minIndex] = heapData[index];
			heapData[index] = tmp;
			percolateDown(minIndex);
		}
		
		
	}

	

}
