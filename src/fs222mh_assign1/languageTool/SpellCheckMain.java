package fs222mh_assign1.languageTool;

import java.io.IOException;

public class SpellCheckMain {
	public static void main(String[] args) throws IOException
    {
        SpellChecker checker = new SpellChecker();

        String test = checker.check(args[0]);

        System.out.println(test);
    }

}


