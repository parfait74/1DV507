package fs222mh_assign4.ex3;

public class appendingSingleChar {

	public static void main(String[] args) {
		int nbrOfRuns = 10;
		int totalTime = 0;
		
		for (int i = 0; i < nbrOfRuns; i += 1) {
			long before = System.nanoTime();
			long after = System.nanoTime();
			int estimatedTime = (int) (after-before);
			int times = 0;
			do {
				StringBuffer sb = new StringBuffer();
				sb.append("a");
				@SuppressWarnings("unused")
				String string = sb.toString();
				after = System.nanoTime();
				estimatedTime = (int) (after-before);
				times += 1;
			} while (estimatedTime < 1000000000);
			
			System.out.println("test"+i +": " + times);
			totalTime += times;

									
		}
		System.out.println("Genomsnitt: " + totalTime / nbrOfRuns);
		System.out.println("Length of string is the same as number of concatenations");


	}

}
