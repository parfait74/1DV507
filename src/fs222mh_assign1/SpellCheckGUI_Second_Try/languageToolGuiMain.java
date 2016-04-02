package fs222mh_assign1.SpellCheckGUI_Second_Try;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import fs222mh_assign1.languageTool.SpellChecker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * Did a new one since I realized I haven't used FX which it said in the assignment.
 * @author fredrik
 *
 */

public class languageToolGuiMain extends Application{
	
	public void start(Stage stage) throws IOException
    {
		//http://www.programcreek.com/java-api-examples/index.php?class=javafx.stage.FileChooser&method=setSelectedExtensionFilter
        File file;
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose a file");
        fc.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("Text Files", ".txt")); 

        try
        {
            file = fc.showOpenDialog(stage);

            SpellChecker spellCheck = new SpellChecker();
            String errors = spellCheck.check(file.toString());

            HBox root = new HBox();
            TextArea textArea = new TextArea();
            TextArea errorArea = new TextArea();

            errorArea.setText(errors);
            errorArea.setMinWidth(500);
            errorArea.setMaxWidth(800);
            errorArea.setEditable(false);

            String originalText = readText(file.toString());
            textArea.setText(originalText);		
            textArea.setPrefSize(1280, 800);

            root.getChildren().addAll(textArea, errorArea);
            stage.setTitle("SpellCheck");
            stage.setScene(new Scene(root, 1640, 800));
            stage.show();
        }
        catch (RuntimeException e)
        {
            e.printStackTrace();
            return;
        }
    }
	
	public String readText(String text) throws IOException {
		StringBuilder sb = new StringBuilder();

		Scanner scan = new Scanner(text);
		while (scan.hasNextLine()) {
			sb.append(scan.nextLine());
		}
		scan.close();
		
		
		
		return sb.toString();
	}
	
	

    public static void main(String[] args)
    {
        launch(args);
    }
	
	

}
