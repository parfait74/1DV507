package wrong_exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author fredrik
 *
 */
public class PascalMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	       System.out.print("Enter the row you wish to be printed: ");
	       int rows = input.nextInt();
	       
	       int[] row = pascalRow(rows);
		   System.out.println(Arrays.toString(row));
	       
	       input.close();
	   }
	
	// Methods
	
	public static int[] pascalRow(int n) {						// recursive function, calls on itself and then calculates the pascalrows from the beginning
		
		if (n == 0) {											// first row has no previous row
			int[] result = {1};
			return result;
		}
		
		else {
			int previousRow[] = pascalRow(n - 1);				// previousrow is rows-1, using recursion to get through all rows
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




