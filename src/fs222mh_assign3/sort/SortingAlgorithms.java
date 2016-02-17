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
			
			// Swap the integers as long the left is bigger then right, and that there is a left
			while(j > 0 && out[j - 1] > temp) {
				out[j] = out[j - 1];
				j = j - 1;
			}
			out[j] = temp;
		}
		return out;
	}

}
