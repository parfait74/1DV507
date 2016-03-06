package fs222mh_assign1.ex10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


/**
 * View Class
 * @author fredrik
 *
 */
public class View extends Application {

	private TextArea leftText;
	private TextArea rightText;
	private Alert alert;
	private Controller controller;
	
	/**
	 * Constructor.
	 */
	public View() {
		controller = new Controller();
	}
	
	/**
	 * Overridden from the Application class.
	 */
	@Override
	public void start(Stage stage) throws Exception {
		
		BorderPane root = new BorderPane();
		
		/*
		 * Menu Bar
		 */
		MenuBar bar = new MenuBar();
		Menu actions = new Menu("File");
		bar.getMenus().addAll(actions);
		root.setTop(bar);
		
		MenuItem openFile = new MenuItem("Open File");
		openFile.setOnAction((ActionEvent) -> {
			openFile(stage);
		});
		
		MenuItem check = new MenuItem("Check");		
		check.setOnAction((ActionEvent) -> {
			if(leftText.getText().equals("")) {
				alert.setContentText("There is no text to check.");
			}
			else {
				check(leftText.getText());
			}
		});
		
		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction((ActionEvent) -> {
			System.exit(0);
		});
		
		actions.getItems().addAll(openFile, check, exit);
		
		// Center
		GridPane centerPane = new GridPane();
		ColumnConstraints twoColumns = new ColumnConstraints();
		twoColumns.setPercentWidth(50);
		centerPane.getColumnConstraints().addAll(twoColumns, twoColumns);
		
		RowConstraints autoHeight = new RowConstraints();
		autoHeight.setVgrow(Priority.ALWAYS);
		centerPane.getRowConstraints().addAll(autoHeight);
		
		root.setCenter(centerPane);
		
		leftText = new TextArea();
		leftText.setWrapText(false);
		centerPane.add(leftText, 0, 0);
				
		rightText = new TextArea();
		rightText.setWrapText(false);
		centerPane.add(rightText, 1, 0);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Spellchecker");
		stage.show();
	}

	/**
	 * Launches the view.
	 */
	public void go() {
		launch();
	}
	
	/*
	 * Call for check method in class controller
	 */
	private void check(String text) {
		
		String check = "";
		
		try {
			check = controller.check(text);
		}
		catch(IOException e) {
			
			alert.setContentText("Ooops!");
		}
		
		if(check.equals("")) {
			rightText.setText("No errors found.");
		}
		else {
			rightText.setText(check);
		}
	}
	
	/*
	 * Choose file to open, scan and write in left screen
	 */
	private void openFile(Stage stage) {
		FileChooser chooser = new FileChooser();
		chooser.getExtensionFilters().add(new ExtensionFilter("Text File", "*.txt"));
		
		File file = chooser.showOpenDialog(stage);
		
		if(file == null) {
			return;
		}
		
		try {
			Scanner scan = new Scanner(file);
			StringBuilder sb = new StringBuilder();
			
			while(scan.hasNextLine()) {
				sb.append(scan.nextLine() + "\n");
			}
			
			scan.close();
			
			leftText.setText(sb.toString());
		}
		catch(FileNotFoundException e) {			
			
		}
	}
	
}

/* Still need to sort out the error when nothing is written, need to catch that
 * 
 */
