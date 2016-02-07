/**
 * Histogram from previous assignment, somewhat rewritten to suit this assignment.
 * Need to tweak the error handling. 
 */
package fs222mh_assign2.ex7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Histogram {
	
	private int[] counter;
	
	// Constructor
	public Histogram() {
		counter = new int[10];
		
	}
	
	/**
	 * Counts the occurrences of numbers 1-100 and adds them in the correct slot in the counter
	 * @param input
	 */
	public void scan(File input) {
		Scanner file = null;
		
		try {
			file = new Scanner(input);
		}
		catch (FileNotFoundException e) {
			return;
			
		}
		while (file.hasNextInt()) {
			try {
				counter[(file.nextInt() - 1) / 10] ++; // -1 means 0 becomes -1 and out of range, 100 becomes 99 and is fine. Allowed span 1-100.
			}
			catch (ArrayIndexOutOfBoundsException e) {
				
			}
			
		}
		file.close();
	}
	
	/**
	 * Gets the scanned data
	 * @return
	 */
	public int[] getData() {
		return counter;
	}

}
