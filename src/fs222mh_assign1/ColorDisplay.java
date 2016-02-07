package fs222mh_assign1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class ColorDisplay extends Application{
	
	/**
	 * Three fields that reads the red, green and blue (RGB) value of a color and shows that after pressing the button.
	 * I tried to use panes in panes, seems to work. i.e tile and hbox inside a borderpane. 
	 * 
	 * TO DO, add errorhandling for the textfields. Might add a VBox inside the HBox for the textfields as well so I can get a text above each.
	 */
	
	public void start(Stage stage) {
		BorderPane bp = new BorderPane();
		bp.setPadding(new Insets(20,20,20,20));
		
		HBox bpBox = new HBox();
		bpBox.setPadding(new Insets(10,10,10,10));
		bpBox.setMinHeight(80);		
		
		TilePane bpTile = new TilePane();
		bpTile.setPadding(new Insets(10, 10, 10, 10));
		bpTile.setPrefColumns(1);
		//bpTile.setStyle("-fx-background-color: #808080;");
		HBox hbox = new HBox(10); 
		TextField one = new TextField();
		one.setText("Red");
		TextField two = new TextField();
		two.setText("Green");
		TextField three = new TextField();
		three.setText("Blue");
		hbox.getChildren().addAll(one, two, three);
		bpTile.getChildren().add(hbox);
		BorderPane.setAlignment(bpTile, Pos.CENTER);
		
		Button bpButton = new Button("Display Color");
		bpButton.setPadding(new Insets(10, 10, 10, 10));
		BorderPane.setAlignment(bpButton, Pos.CENTER);
		
		bp.setTop(bpBox);
		bp.setBottom(bpButton);
		bp.setCenter(bpTile);
		
		bpButton.setOnAction((ActionEvent e) -> {
			String red = one.getText();										// Get the value inside the textfields
			String green = two.getText();
			String blue = three.getText();
			String newColor = red + green + blue;							// new variable to hold the integers for the new color
			bpBox.setStyle("-fx-background-color: #"+newColor +";");		//change the background color of btBox using the RGB from the textfields
		});

		Scene scene = new Scene(bp);

        stage.setTitle("ColorDisplay");
        stage.setScene(scene);
        stage.show();
				
	}
	
		public static void main(String[] args) {
		launch(args);

	}
	

}
