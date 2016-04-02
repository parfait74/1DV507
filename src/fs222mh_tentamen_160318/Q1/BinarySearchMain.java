package fs222mh_tentamen_160318.Q1;

import java.util.Scanner;

/**
 * 
 * @author fredrik
 *
 */
public class BinarySearchMain {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9,10};
		
		Scanner input = new Scanner(System.in);
	       System.out.print("Enter what number to search for (array is 1-10): ");
	       int N = input.nextInt();
	       
	       if (binarySearch(a, N, 0, a.length-1)) {
	    	   System.out.println("Element found");
	       } else {
	    	   System.out.println("Element not found");
	       }    	   
	    	   
	       input.close();	  
		

	}
	
	/**
	 * Binary search method to search for elements in a sorted array.
	 * @param arr
	 * @param n
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean binarySearch(int[] arr, int n, int min, int max) {
		if (max < min) {
			return false;								// Not found
		}
		int mid = (min + max) / 2;						// position in the middle
		int mid_value = arr[mid];						// value of mid position
		
		if (n == mid_value) {							// number found!
			return true;
		} else if (n < mid_value) {
			return binarySearch(arr, n, min, mid - 1);	// recursive search with lower number, left side of array
		} else {
			return binarySearch(arr, n, mid + 1, max);	// recursive search for higher number, right side of array
		}
		
	}

}
