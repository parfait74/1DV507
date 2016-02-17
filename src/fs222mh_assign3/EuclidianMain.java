package fs222mh_assign3;

/**
 * This class takes to integers and runs an euclidian algorithm, i.e checks the greatest common divisor (largest
 * number that divides both of them without leaving a reminder)
 * @author fredrik
 *
 */

public class EuclidianMain {

	public static void main(String[] args) {
		
		System.out.println(GCD(18, 12));
		System.out.println(GCD(42, 56));
		System.out.println(GCD(9, 28));

		

	}

	private static int GCD(int m, int n) {
		
		if (n == 0) {
			return m;
		}
		else {
			return GCD(n, m % n);		// recursion here
		}
	}

}
