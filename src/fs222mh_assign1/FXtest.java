package fs222mh_assign1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Just playing around and getting the hang of JavaFX
 * @author fredrik
 *
 */

public class FXtest extends Application {
	
	public void start(Stage stage) {
        Circle circ = new Circle(40, 40, 30);
        Group root = new Group(circ);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("Test of JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }
	
	public static void main(String[] args) {
		launch(args);
	}

}
