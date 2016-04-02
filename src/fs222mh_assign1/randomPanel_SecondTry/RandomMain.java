package fs222mh_assign1.randomPanel_SecondTry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RandomMain extends Application {
	
	public void start(Stage stage)
    {
        RandomPanel randPanel = new RandomPanel();

        Scene scene = new Scene(randPanel, 300, 60);

        stage.setTitle("RandomPanel");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args)
    {
        launch(args);
    }

}
