package fs222mh_assign1;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RandomPanel extends Application {
	
	public void start(Stage stage) {
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(20,20,20,20));
		Button bpButton = new Button("New Random");
		bp.setTop(bpButton);
		BorderPane.setAlignment(bpButton, Pos.CENTER);
		
		final Text text = new Text();
		text.setFont(Font.font("Verdana", 50));
		bp.setCenter(text);
		
		bpButton.setOnAction(e -> text.setText(handleButtonAction(e)));	// When clicked a random number is to be shown
		
		Scene scene = new Scene(bp, 250, 150);

        stage.setTitle("RandomPanel");
        stage.setScene(scene);
        stage.show();
	}
	
	private String handleButtonAction(ActionEvent event) {
		
		Random randomGenerator = new Random();
		int randomNbr = randomGenerator.nextInt(100);
		System.out.println(randomNbr);
		return Integer.toString(randomNbr);
	}

	public static void main(String[] args) {
		launch(args);

	}

}
