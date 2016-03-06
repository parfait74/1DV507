package fs222mh_assign1.ex10;

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
