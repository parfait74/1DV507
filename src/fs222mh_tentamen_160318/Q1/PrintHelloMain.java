package fs222mh_tentamen_160318.Q1;

import java.util.Scanner;

/**
 * 
 * @author fredrik
 *
 */
public class PrintHelloMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	       System.out.print("Enter how many times you wish Hello to be printed: ");
	       int times = input.nextInt();
	       printHello(times);	       
	       input.close();	       

	}

	private static void printHello(int N) {
		if (N > 0) {								// verify that N is > 0 otherwise I need to stop.
			System.out.print ("Hello ");
			printHello(N-1);						// here I use recursion
		}
		
	}

}
