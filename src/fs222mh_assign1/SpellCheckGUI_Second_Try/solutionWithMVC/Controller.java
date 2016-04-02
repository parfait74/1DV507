package fs222mh_assign1.SpellCheckGUI_Second_Try.solutionWithMVC;

import java.io.IOException;

import fs222mh_assign1.languageTool.SpellChecker;

/**
 * Controller Class
 * @author fredrik
 *
 */
public class Controller {
	
	public String check(String text) throws IOException {
		
		SpellChecker check = new SpellChecker();
		return check.check(text);
	}

	

}
