package fs222mh_assign1.ColorDisplay_secondTry;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ColorDisplayMain_secondTry extends Application{
	
	public void start(Stage stage)
    {
        ColorDisplay_secondTry root = new ColorDisplay_secondTry();

        root.setPrefSize(500, 500);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setSpacing(10);

        stage.setScene(new Scene(root, 200, 200));
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
