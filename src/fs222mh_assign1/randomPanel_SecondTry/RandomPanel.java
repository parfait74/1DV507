package fs222mh_assign1.randomPanel_SecondTry;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RandomPanel extends BorderPane{
	
	private Pane randomPane;
	private Pane buttonPane;
	private Text text;
	
	public RandomPanel() {
		createRandomPane();
		createButtonPane();
	}
	
	

	public void createRandomPane(){
		randomPane = new Pane();		
		text = new Text(100, 50, "Random");
        text.setFont(new Font(50));
        randomPane.getChildren().add(text);
        setRight(randomPane);
		
	}
	
	public void createButtonPane(){
		buttonPane = new Pane();
		Button btn = new Button();
		btn.setText("New Random");
		
		btn.setOnAction(e -> text.setText(handleButtonAction(e)));	// When clicked a random number is to be shown


        buttonPane.getChildren().add(btn);
        setLeft(buttonPane);
	}
	
	
	private String handleButtonAction(ActionEvent event) {
		
		Random randomGenerator = new Random();
		int randomNbr = randomGenerator.nextInt(100);
		System.out.println(randomNbr);
		return Integer.toString(randomNbr);
	}

}
