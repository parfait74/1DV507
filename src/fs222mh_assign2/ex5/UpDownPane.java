package fs222mh_assign2.ex5;

/**
 * This is showing a gridpane 7x7 with an icon you can move with the arrow keys
 * using a class(IntValue) to keep track of the value where the icon is located since lambda can't manipulate parameters.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class UpDownPane extends Application {
	
	public void start(Stage theStage) {
		theStage.setTitle("UpDownPane");
		BorderPane root = new BorderPane();
		Scene theScene = new Scene(root, 860, 860);
		theStage.setScene(theScene);
		
		int maxRow = 7;		//Max size 
		int maxColumn = 7;	//Max size
		//int iconRow = 4;	//Start position for icon and then location
		//int iconColumn = 3;	//Start position for icon, starts at 0 so 3=4 
		IntValue iconRow = new IntValue(4);
		IntValue iconColumn = new IntValue(3);
		
		
		GridPane gp = new GridPane();
		gp.setGridLinesVisible(true);
		root.setCenter(gp);
		
		//Create grids 7x7
	    for(int row = maxRow; row > 0; row--)
	        for(int col = 0; col < maxColumn; col++) {
	        	Label label = new Label(" ");
	            gp.add(label, col, row);
	        } 
		
	    //Set image on centergrid
	    Image icon = new Image("wizard.png");
		ImageView theIcon = new ImageView(icon);
		Label iconLabel = new Label();
		iconLabel.setGraphic(theIcon);
		gp.add(iconLabel, 3, 4); 			//set icon in middle
		
		// Check for key event
		theScene.setOnKeyPressed(e -> {
			
			if(e.getCode() == KeyCode.UP) {
			System.out.println("arrrow up");
			gp.getChildren().remove(iconLabel);
			if (iconRow.value != 1) {
			iconRow.value -= 1;
			} else {
				iconRow.value = 7;
			}
			gp.add(iconLabel, iconColumn.value, iconRow.value);
			}
			else if (e.getCode() == KeyCode.DOWN) {
				System.out.println("arrow down");
				gp.getChildren().remove(iconLabel);
				if (iconRow.value != 7 ) {
				iconRow.value += 1;
				} else {
					iconRow.value = 1;
				}
				gp.add(iconLabel, iconColumn.value, iconRow.value);
			}
			else if (e.getCode() == KeyCode.LEFT) {
				System.out.println("arrow left");
				gp.getChildren().remove(iconLabel);
				if (iconColumn.value != 0) {
				iconColumn.value -= 1;
				} else {
					iconColumn.value = 6;
				}
				gp.add(iconLabel, iconColumn.value, iconRow.value);
			}
			else if (e.getCode() == KeyCode.RIGHT) {
				System.out.println("arrow right");
				gp.getChildren().remove(iconLabel);
				if (iconColumn.value != 6) {
				iconColumn.value += 1;
				} else {
					iconColumn.value = 0;
				}
				gp.add(iconLabel, iconColumn.value, iconRow.value);
			}

			
		});
		
		
				
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
 * Got the grid to represent 7x7. Need to make it pretty
 * Can't figure out why it's not centered since I'm using borderpane
 * To little time to troubleshoot, got the arrow key working so I'm happy :)
 * 
 * YES! lade till en ny class (IntValue) som håller int värdet, det kan jag manipulera som jag vill :) Den lösningen kommer jag återanvända.
 */ 
