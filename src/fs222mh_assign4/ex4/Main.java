package fs222mh_assign4.ex4;

import java.util.ArrayList;
import java.util.Random;

/**
 * This Main is creating new arrays and testing the measuring the sortingalgorithms.
 * 
 * @author fredrik
 *
 */
public class Main {

	public static void main(String[] args) {
		int arraySize = 8000;
		System.out.println("InsertionSort Integer: " + insertionInt(arraySize));
		System.out.println("MergeSort Integer: " + mergeInt(arraySize));
		System.out.println("InsertionSort String: " + insertionString(arraySize));
		System.out.println("MergeSort String: " + mergeString(arraySize));


	}
	
	/**
	 * 
	 * @return
	 */
	private static int insertionInt(int arraySize) {
		int nbrOfTimes = 10;
		int time = 0;
		SortingAlgorithms sort = new SortingAlgorithms();
		int size = arraySize; 	// size of array
		int max = size * 2;	// size of random integers
		int[] array = new int[size];
		Random rand = new Random();

		// Fill array with random integers
		for (int i = 0; i < size; i += 1) {
			array[i] = rand.nextInt(max);
		}
		
		// Run the sortingalgorithm
		for (int i = 0; i < nbrOfTimes; i += 1) {
			long before = System.nanoTime();
			
			sort.insertionSort(array);
			
			long after = System.nanoTime();
			int estimatedTime = (int) (after-before);
			time += estimatedTime;			
		}					
		return time/nbrOfTimes;
	}
	
	/**
	 * 
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private static int mergeInt(int arraySize) throws ArrayIndexOutOfBoundsException {
		int nbrOfTimes = 10;
		int time = 0;
		SortingAlgorithms sort = new SortingAlgorithms();
		int size = arraySize; 	// size of array
		int max = size * 2;	// size of random integers
		int[] array = new int[size];
		Random rand = new Random();

		// Fill array with random integers
		for (int i = 0; i < size; i += 1) {
			array[i] = rand.nextInt(max);
		}
		
		// Run the sortingalgorithm
		for (int i = 0; i < nbrOfTimes; i += 1) {
			long before = System.nanoTime();
			
			sort.mergeSort(array);
			
			long after = System.nanoTime();
			int estimatedTime = (int) (after-before);
			time += estimatedTime;			
		}		
		return time/nbrOfTimes;		
	}
	
	/**
	 * 
	 * @return
	 */
	private static int insertionString(int arraySize) {
		int nbrOfTimes = 10;
		int time = 0;
		SortingAlgorithms sort = new SortingAlgorithms();
		int size = arraySize; 	// size of array
		ArrayList<String> arrayList = new ArrayList<String>();
		Random rand = new Random();

		// Fill array with random words 10 chars long, http://stackoverflow.com/questions/5683327/how-to-generate-a-random-string-of-20-characters
		for (int i = 0; i < size; i += 1) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 10; j += 1) {
				char c = (char)(rand.nextInt((int)(Character.MAX_VALUE)));
				sb.append(c);
			}
			arrayList.add(sb.toString());
		}
		// Convert the arraylist to array so the sorting works
		String[] array = new String[arrayList.size()];
		array = arrayList.toArray(array);
		
		// Run the sortingalgorithm
		for (int i = 0; i < nbrOfTimes; i += 1) {
			long before = System.nanoTime();
			
			sort.insertionSort(array);
			
			long after = System.nanoTime();
			int estimatedTime = (int) (after-before);
			time += estimatedTime;			
		}					
		return time/nbrOfTimes;
	}
	
	/**
	 * 
	 * @return
	 */
	private static int mergeString(int arraySize) {
		int nbrOfTimes = 10;
		int time = 0;
		SortingAlgorithms sort = new SortingAlgorithms();
		int size = arraySize; 	// size of array
		ArrayList<String> arrayList = new ArrayList<String>();
		Random rand = new Random();

		// Fill array with random words 10 chars long, http://stackoverflow.com/questions/5683327/how-to-generate-a-random-string-of-20-characters
		for (int i = 0; i < size; i += 1) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 10; j += 1) {
				char c = (char)(rand.nextInt((int)(Character.MAX_VALUE)));
				sb.append(c);
			}
			arrayList.add(sb.toString());
		}
		// Convert the arraylist to array so the sorting works
		String[] array = new String[arrayList.size()];
		array = arrayList.toArray(array);
		
		// Run the sortingalgorithm
		for (int i = 0; i < nbrOfTimes; i += 1) {
			long before = System.nanoTime();
			
			sort.mergeSort(array);
			
			long after = System.nanoTime();
			int estimatedTime = (int) (after-before);
			time += estimatedTime;			
		}					
		return time/nbrOfTimes;
	}

}
