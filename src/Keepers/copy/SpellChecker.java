/**
 * Redone from ex6 since I got the feedback to wrap the JLanguateTool in it's own class.
 * 
 */
package Keepers.copy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;

/**
 * SpellChecker Class implementing JLanguageTool
 * @author fredrik
 *
 */

public class SpellChecker {
	
	JLanguageTool jLang;
	
	/**
	 * Constructor
	 */
	public SpellChecker() {
		jLang = new JLanguageTool(new BritishEnglish());
		
	}
	
	public String check(String text) throws IOException {
		List<String> lines = new ArrayList<>();
		
		Scanner scan = new Scanner(text);
		while (scan.hasNextLine()) {
			lines.add(scan.nextLine());
		}
		scan.close();
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < lines.size(); i += 1) {
			int lineNumber = i + 1;						// tip from friend to use human way of reading lines (starting at 1)
			List<RuleMatch> matches = jLang.check(lines.get(i));
			
			// Get matches for the current line
			for (RuleMatch match:matches) {
				String matchWord = lines.get(i).substring(match.getColumn() - 1, match.getEndColumn() - 1); // Get the word out of the line
				String suggestions = match.getSuggestedReplacements().toString().substring(1, match.getSuggestedReplacements().toString().length() - 1); // only get suggestion, skip the []
				
				String message = match.getMessage();
				message = message.replace("<suggestions>", "");	// trim message
				message = message.replace("</suggestion>", "");	// trim message
				
				// remove . from message
				if (message.charAt(message.length() - 1) == '.') {
					message = message.substring(0, message.length() - 2);					
				}
				
				// adding stuff to stringbuilder
				sb.append("Line " + lineNumber + ": " + message + " at column " + match.getColumn() + ".\n"); 
				
				if (matchWord.trim().length() > 0 && suggestions.trim().length() > 0) {
					sb.append(">>> " + matchWord + " --> " + suggestions + "\n\n");
				}
				else {
					sb.append("\n");
				}
			}
		}
		return sb.toString();
	}

}
