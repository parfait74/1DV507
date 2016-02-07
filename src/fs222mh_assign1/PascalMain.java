package fs222mh_assign1;

import java.util.Scanner;

public class PascalMain {
	
	public static void main(String[] args) {
	       Scanner input = new Scanner(System.in);
	       System.out.print("Enter the row number upto which Pascal's triangle has to be printed: ");
	       int rows = input.nextInt();
	       
	       int[] result = PascalRow(rows);
			for (int row : result) {							// Iterate through the array and print
				System.out.print(row + " ");
			}
	       
	       input.close();
	   }
	
	// Methods
	
	public static int[] PascalRow(int rows) {					// recursive function, calls on itself and then calculates the pascalrows from the beginning
		
		if (rows == 0) {										// first row has no previous row
			int[] result = {1};
			return result;
		}
		
		else {
			int previousRow[] = PascalRow(rows - 1);			// previousrow is rows-1, using recursion to get through all rows
			int nextRow[] = calculateRow(previousRow);			// nextrow is calculated from the numbers in the previous row
			return nextRow;
		}
		
	}
	
	public static int[] calculateRow(int[] previousRow) {		// Calculate the pascalrow using previousrow array
		
		int[] next = new int[previousRow.length + 1];
		next[0] = 1;											// first and last are always 1
		next[previousRow.length] = 1;							// -""-
		
		for (int i = 1; i < previousRow.length; i += 1) {
			next[i] = previousRow[i - 1] + previousRow[i];
		}
		return next;
	}
	
}
