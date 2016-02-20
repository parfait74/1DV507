package fs222mh_assign3.sort;

public class SortingAlgorithms {

	public static void main(String[] args) {

	}
	
	/**
	 * Insertion sort with integers.
	 * Solution based on http://mathbits.com/MathBits/Java/arrays/InsertionSort.htm for inspiration (this was how ever descending order), 
	 * and http://en.wikipedia.org/wiki/Insertion_sort.
	 * @param in
	 * @return
	 */
	public int[] insertionSort(int[] in) {
		
		int[] out = new int[in.length]; 			// make a copy of the array so it can be reused for all methods
		System.arraycopy(in, 0, out, 0, in.length);
		
		for(int i = 1; i < out.length; i += 1) {
			int temp = out[i];
			int j = i;
			
			// Swap the integers as long the left is bigger then right, as long there is a left from scratch
			while(j > 0 && out[j - 1] > temp) {
				out[j] = out[j - 1];
				j = j - 1;
			}
			out[j] = temp;
		}
		return out;
	}
	
	/**
	 * Looked at http://en.wikipedia.org/wiki/Merge_sort and
	 * 
	 * @param in
	 * @return
	 */
	public int[] mergeSort(int in[]) {
		
		if (in.length == 1) {
			return in;
		}
		
		int[] left = new int[in.length / 2];
		System.arraycopy(in, 0, left, 0, in.length / 2);  // cut array and place first part in left
		int[] right;
		
		// Even number
		if (in.length % 2 == 0) {
			right = new int[in.length / 2] ;
			System.arraycopy(in, in.length / 2, right, 0, in.length / 2); // 
		}
		// Odd number
		else {
			right = new int[(in.length / 2) + 1];
			System.arraycopy(in, in.length / 2, right, 0, in.length / 2 + 1);
		}
		
		left = mergeSort(left); // Use recursion and split the left array
		right = mergeSort(right); // recursion on right array
		
		return merge(left, right);		// use the merge function to set the arrays together again and return the result
				
	}
	
	/**
	 * Merge to arrays
	 * @param left
	 * @param right
	 * @return
	 */
	public int[] merge(int[] left, int[] right) {
		
		int[] result = new int[left.length + right.length]; // Create new array to hold the two merging
		
		// Index to keep track of locations while merging
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		
		// Add from left array it it's lower the current index in right array, otherwise add the right index to result
		while(leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex]) {
				result[resultIndex += 1] = left[leftIndex += 1];
			}
			else {
				result[resultIndex += 1] = right[rightIndex += 1];
			}
		}
		
		// add what is left, if any. Check left and right array. The arrays are already sorted internally so adding will be correct
		for (int i = leftIndex; i < left.length; i += 1) {
			result[resultIndex += 1] = left[i];
		}
		for ( int i = rightIndex; i < right.length; i += 1) {
			result[resultIndex += 1] = right[i];
		}
		
		return result;
		
	}

}
