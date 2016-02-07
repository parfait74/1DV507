package fs222mh_assign1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Doesn't seem like my idea with Vbox in a vbox is good idea. Works anyway.
 * @author fredrik
 *
 */

public class OneTwoThree extends Application {
	
	public void start (Stage stage) {
		
		// Three Vboxes containing the word with some styling to it
		
		VBox vbox1 = new VBox(10);
		vbox1.setMinHeight(30);
		Text title1 = new Text("One");
		vbox1.getChildren().add(title1);
		vbox1.setAlignment(Pos.TOP_LEFT);
		vbox1.setStyle("-fx-background-color: #0000FF"); // Tried using awt.color but didn't get it to work
				
		VBox vbox2 = new VBox(10);
		vbox2.setMinHeight(30);
		Text title2 = new Text("Two");
		vbox2.getChildren().add(title2);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.setStyle("-fx-background-color: #FFFF00");
		
		VBox vbox3 = new VBox(10);
		vbox3.setMinHeight(30);
		Text title3 = new Text("Three");
		vbox3.getChildren().add(title3);
		vbox3.setAlignment(Pos.BOTTOM_RIGHT);
		vbox3.setStyle("-fx-background-color: #0000FF");
		
		// Root of a Vbox to gather the other as children. Added padding
		
		VBox root = new VBox(1);
		root.setMinWidth(200);
		root.setPadding(new Insets(20,20,20,20));
		root.getChildren().addAll(vbox1, vbox2, vbox3);
        Scene scene = new Scene(root);

        stage.setTitle("One Two Three");
        stage.setScene(scene);
        stage.show();
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
