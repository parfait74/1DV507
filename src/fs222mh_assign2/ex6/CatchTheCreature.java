package fs222mh_assign2.ex6;

import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CatchTheCreature extends Application {
	/*public static void main(String[] args) {
		launch(args);
	}*/
	
	private int creatureCatched = 0;
	
	
	@Override
	public void start(Stage theStage) {
		theStage.setTitle("Catch the Creature");
		Random rand = new Random();
		
		Group root = new Group();
		Scene theScene = new Scene(root, 500, 500);
		theStage.setScene(theScene);
		
		//Image creature = new Image(getClass().getResourceAsStream("cat.png")); //Didn't work, complained about the source
		//ImageView theCreature = new ImageView(creature);

		Image creature = new Image("cat.png");
		ImageView theCreature = new ImageView();
		theCreature.setImage(creature);
		//theCreature.setLayoutX(200);
		//theCreature.setLayoutY(200);
		root.getChildren().add(theCreature);
		
		Text text = new Text(10,25, "Points: ");
		text.setFont(Font.font("SansSerif", 20));
		root.getChildren().add(text);
		
		Text points = new Text(100, 25, " ");					// lack of inspiration on how to show the value better. Maybe a vbox should have been the way forward
		points.setFont(Font.font("SansSerif", 25));
		root.getChildren().add(points);
		
		theCreature.setOnMousePressed(e -> {					// First take was to move the image after clicking on it
			//theCreature.setLayoutX(rand.nextInt(375)); 		// Take into account the picture is 128x128 so it won't show outside the scene.
			//theCreature.setLayoutY(rand.nextInt(325)+50);
			creatureCatched += 1;
			points.setText(Integer.toString(creatureCatched));	
		});
		
		/**
		 * Function to add a timer to show picture randomly
		 * Used timer after trying animationTimer but could't get that one to slow down since that goes on framerate.
		 */
		Timer timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent e) {
				theCreature.setLayoutX(rand.nextInt(375));
				theCreature.setLayoutY(rand.nextInt(325)+50);				
			}
			
		});
		timer.start();
		
		
		theStage.show();
	}
	
	
	/**
	 * Launches the GUI
	 */
	public void fire() {
		launch();
	}

}

/*
 * Still need to put creature in it's own class
 * For some reason I just can't get the value of creatureCatched to be shown in a better way.
 * At least I know what I'm doing :)
 */ 
