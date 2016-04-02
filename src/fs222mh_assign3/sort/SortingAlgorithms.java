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
	 * http://javahungry.blogspot.com/2013/06/java-sorting-program-code-merge-sort.html. 
	 * Using function merge to return the arrays merged back together
	 * @param in
	 * @return
	 */
	public int[] mergeSort(int in[]) {
		
		// Base case
				if(in.length == 1) {
					return in;
				}
				
				int[] left, right;
				
				left = new int[in.length / 2];
				System.arraycopy(in, 0, left, 0, in.length / 2);
				
				// Even number of elements
				if(in.length % 2 == 0) {
					right = new int[(in.length / 2)];
					System.arraycopy(in, in.length / 2, right, 0, in.length / 2);			
				}
				
				// Odd number of elements
				else {
					right = new int[(in.length / 2) + 1];
					System.arraycopy(in, in.length / 2, right, 0, in.length / 2 + 1);
				}
				
				left = mergeSort(left);
				right = mergeSort(right);
				
				return merge(left, right);
				
	}
	
	/**
	 * Merge to arrays
	 * @param left
	 * @param right
	 * @return
	 */
	public int[] merge(int[] left, int[] right) {
		
		int[] result = new int[left.length + right.length];
		
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		
		/*
		 * Add current integer from the left array if it is lower than
		 * the current integer from the right array, or the other way around.
		 */
		while(leftIndex < left.length && rightIndex < right.length) {
			
			if(left[leftIndex] <= right[rightIndex]) {
				result[resultIndex++] = left[leftIndex++];
			}
			
			else {
				result[resultIndex++] = right[rightIndex++];
			}
		}
		
		/*
		 * Add anything that is left.
		 */
		for(int k = leftIndex; k < left.length; k++) {
			result[resultIndex++] = left[k];
		}
		
		for(int k = rightIndex; k < right.length; k++) {
			result[resultIndex++] = right[k];
		}
		
		return result;
		
	}
	
	/**
	 * insertionSort with strings.
	 * inspiration found at http://en.wikipedia.org/wiki/Insertion_sort and http://stackoverflow.com/questions/17432738/insertion-sort-using-string-compareto
	 * @param in
	 * @return
	 */
	public String[] insertionSort(String[] in) {
		String[] out = new String[in.length]; // create a copy so I can reuse the array, not sure that's necessary with the junit test but I'll keep it
		System.arraycopy(in, 0, out, 0, in.length);
		
		for (int i = 1; i < out.length; i += 1){
			String temp = out[i];
			int j = i;
			
			//swap strings like the int insertionSort
			while(j > 0 && out[j - 1].compareTo(temp) > 0) {
				out[j] = out[j - 1];
				j = j - 1;
			}
			out[j] = temp;
		}
		return out;
	}
	
	/**
	 * MergeSort with Strings. Using same kind of logic as for int.
	 * Inspiration at http://en.wikipedia.org/wiki/Merge_sort and http://www.coderanch.com/t/571571/java/java/mergesort-sort-list-names-alphabetically
	 * @param in
	 * @return
	 */
	public String[] mergeSort(String in[]){
		// if nothing to sort, return the string
		if (in.length == 1) {
			return in;
		}
		
		String[] left = new String[in.length / 2];
		System.arraycopy(in, 0, left, 0, in.length / 2);
		String[] right;
		
		// Even number
		if (in.length % 2 == 0) {
			right = new String[in.length / 2];
			System.arraycopy(in, in.length / 2, right, 0, in.length / 2);
		}
		// Odd number
		else {
			right = new String[(in.length / 2) + 1];
			System.arraycopy(in, in.length / 2, right, 0, in.length / 2 + 1);
		}
		left = mergeSort(left);			// Using recursion to split into new arrays
		right = mergeSort(right);
		
		return merge(left, right);		// Using merge function to merge the arrays into a new sorted one
	}
	
	/**
	 * Merging the sorted String arrays together. Using same logics as in the Int merge function
	 * @param left
	 * @param right
	 * @return
	 */
	private String[] merge(String[] left, String[] right) {
		String[] result = new String[left.length + right.length];
		
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		
		/*
		 * Add current string from the left array if it is alphabetically before
		 * the current string from the right array, or the other way around.
		 */
		while(leftIndex < left.length && rightIndex < right.length) {
			
			if(left[leftIndex].compareTo(right[rightIndex]) <= 0) {
				result[resultIndex++] = left[leftIndex++];
			}
			
			else {
				result[resultIndex++] = right[rightIndex++];
			}
		}
		
		/*
		 * Add anything that is left.
		 */
		for(int k = leftIndex; k < left.length; k++) {
			result[resultIndex++] = left[k];
		}
		
		for(int k = rightIndex; k < right.length; k++) {
			result[resultIndex++] = right[k];
		}
		
		return result;
	}

}

/**
 * I do create a copy of the array used as input. Not sure I need to since I use jUnit for testing.
 * Still need to learn more about jUnit testing :)
 */ 
