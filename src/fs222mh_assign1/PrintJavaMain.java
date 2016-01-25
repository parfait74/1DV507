package fs222mh_assign1;

import java.io.File;
import java.util.Scanner;

public class PrintJavaMain {

	public static void main(String[] args) {
		
		System.out.print("Write the path to the directory: ");
		Scanner input = new Scanner(System.in);
		String path = input.nextLine();

		printAllJavaFiles(path);

		input.close();

	}
	
	public static void printAllJavaFiles(String path) {
		File directory = new File(path);
		File[] fileList = directory.listFiles();
		
		for (File f: fileList) {						// Iterate through
			if (f.isFile()) {							// if file
				if (f.getName().endsWith(".java")) {	// check filename if .java then print
					System.out.println(f.getName());
				}
			} else {									// else directory
				printAllJavaFiles(f.getAbsolutePath()); // recursion, call on method with the patch to the directory
			}
		}
	}

}
