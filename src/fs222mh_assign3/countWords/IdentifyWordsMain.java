package fs222mh_assign3.countWords;

/**
 * This class reads a file an removes all non-letters and writes to a new file called words.txt.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class IdentifyWordsMain {

	public static void main(String[] args) throws IOException {
		
		Scanner scan = null;
		
		try {
			//scan = new Scanner(new File("testFile.txt"));
			URL url = new URL("http://homepage.lnu.se/staff/jlnmsi/java2/HistoryOfProgramming.txt"); // read directly from source
			scan = new Scanner(url.openStream());
		}
		catch(FileNotFoundException e) {
			
		}
		StringBuilder sb = new StringBuilder();					// initialize stringbuilder to hold the words to be printed
		while(scan.hasNext()) {
			String word = scan.next();							// initialize the string to hold the scanned words
			
			for (int i = 0; i < word.length(); i += 1) {
				if(Character.isAlphabetic(word.charAt(i))) {	// Check if char is a letter within the scanned word
					sb.append(word.charAt(i));
				}
			}
			sb.append(" ");										// add a " " between the words
		}
		scan.close();
		
		try {
			PrintWriter write = new PrintWriter(new File("words.txt"));		// Initialize printer for new file
			write.write(sb.toString());										// write to file from stringbuilder
			write.close();
		}
		catch(FileNotFoundException e) {
			
		}

	}

}
