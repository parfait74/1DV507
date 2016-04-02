package Keepers.copy;

import java.io.IOException;

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
