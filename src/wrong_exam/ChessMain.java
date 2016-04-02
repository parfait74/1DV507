package wrong_exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author fredrik
 *
 */
public class ChessMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	       System.out.print("Which sqaure do you want to test for black: ");
	       int square = input.nextInt();
	       	       
		   System.out.println();
	       input.close();		
	}
	
	public boolean isEmpty() {
		return false ;
	}

}
