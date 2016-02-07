package fs222mh_assign1.languageTool;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;

public class SpellCheckMain {
	/**
	 * Started using proper commenting on the methods
	 * Main method.
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		
		JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
		String filePath = getFilePath();
		System.out.println("FilePath: " + filePath);
		String fileToCheck = readFile(filePath);
		List<RuleMatch> matches = langTool.check(fileToCheck);
		
		for (RuleMatch match : matches) {
			  System.out.println("Potential error at line " +
			      match.getLine() + ", column " +
			      match.getColumn() + ": " + match.getMessage());
			  System.out.println("Suggested correction: " +
			      match.getSuggestedReplacements());
			}

	}
	
	/**
	 * Method to get the path for the file to be corrected		
	 * @return - String with the path
	 */
	public static String getFilePath() {
		
		System.out.println("Write the path to the file to check: ");
		Scanner input = new Scanner(System.in);
		String path = input.nextLine();
		input.close();

		return path;				
		}
	
	/**
	 * Making a mess here just trying to get the file into a string so I can fiddle with it using languageTool
	 * Method to read the content from the file given
	 * @param path - String with the path for the file to be read into new parameter
	 * @return - String with the content of the file
	 * @throws IOException
	 */
	private static String readFile(String path) throws IOException {
		
		String line = null;
		String fileName = path;
			
		try {
			StringBuilder fileContents = new StringBuilder();
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                fileContents.append(line);
		}
			bufferedReader.close();
			return fileContents.toString();	    
	}
		catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" + fileName + "'");     
            
        }
		return null;
		
	}

}


/*
 * Loads of different tries in this one. Just trying to get this working with correct methods.
 * later divide into different classes if needed.
 * 
 */
