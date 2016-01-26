package fs222mh_assign1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class PrintJavaMain {

	public static void main(String[] args) throws IOException {
		
		System.out.print("Write the path to the directory: ");
		Scanner input = new Scanner(System.in);
		String path = input.nextLine();

		printAllJavaFiles(path);

		input.close();

	}
	
	public static void printAllJavaFiles(String path) throws IOException {
		
		File directory = new File(path);
		File[] fileList = directory.listFiles();
		
		for (File f: fileList) {						// Iterate through
			if (f.isFile()) {							// if file
				if (f.getName().endsWith(".java")) {	// check filename if .java then print
					System.out.println(f.getName() + "\t" + countRows(f.getAbsoluteFile()));
				}
			} else {									// else directory
				printAllJavaFiles(f.getAbsolutePath()); // recursion, call on method with the patch to the directory
			}
		}
		
	}
	
	public static int countRows(File aFile) throws IOException { // got inspiration from http://kodejava.org/how-do-i-use-linenumberreader-class-to-read-file/
	    LineNumberReader input = null;						// set to null
	    try {
	        input = new LineNumberReader(new FileReader(aFile)); // create a new reader
	        while ((input.readLine()) != null);
	        return input.getLineNumber();
	    } catch (Exception ex) {
	        return -1;
	    } finally { 									// reset input and close reader
	        if(input != null) 
	            input.close();
	    }
	}
	

}
