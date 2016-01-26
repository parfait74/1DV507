package fs222mh_assign1;

import java.util.Scanner;

public class SumMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
	       System.out.print("Enter the number you wish to be summed up to: ");
	       int nbr = input.nextInt();
	       
	       System.out.println("The sum will be: " + Sum(0, nbr));			// sending 0 as variable since we're summarizing from 0
		
	       input.close();
	}
	
	// This should be done by splitting the number, if summarizing upto 10 it will be (0 to 5) + (6 to 10)
	// how to handle odd numbers?
	// easier doing the normal way, that works from scratch ( nbr + Sum(nbr-1).
	public static int Sum(int from, int nbr) {			// Using 2 variables to enable splitting the calculation, to(nbr) and from
		
		if (from == nbr) {								// if 0 then return 0
			return nbr;
		}
		else {
			return Sum (from,((from+nbr)/2)) + Sum((((from+nbr)/2) + 1), nbr);		//nbr + Sum(nbr-1);	== (0, nbr) == (0, (nbr/2)) + (((nbr/2) + 1), nbr) ==  Sum (0,((0+nbr)/2)) + Sum((((0+nbr)/2) + 1), nbr);
		}
		
	}
	
	

}
