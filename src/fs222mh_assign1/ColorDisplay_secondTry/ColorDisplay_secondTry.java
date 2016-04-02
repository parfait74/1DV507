package fs222mh_assign1.ColorDisplay_secondTry;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Gave it shot to look like the picture in the assignment. Actually got some pointers from a friend how to easy do the verification on the values in the boxes and
 *  to use the Color.rgb. Made it all easier comparing my old solution, which in hindsight is not that pretty :)
 *  All in all, assignments are easier after the course and when I have started my software project, can take quite a lot from there.
 * 
 * @author fredrik
 *
 */
public class ColorDisplay_secondTry extends VBox
{
    private VBox display;
    private HBox input;
    private VBox button;
    private TextField[] rgbText = new TextField[3];
    private Text error;
    private Rectangle colorBox;

  
    // Constructor
    public ColorDisplay_secondTry()
    {
        createDisplayPane();
        createInputPane();
        createButtonPane();

        getChildren().addAll(display, input, button);
    }

  
    // create the pane to display the color
    private void createDisplayPane()
    {
        display = new VBox();
        colorBox = new Rectangle(180, 50);
        colorBox.setFill(Color.rgb(255, 255, 255));
        error = new Text();
        error.setFill(Color.RED);
        display.getChildren().addAll(colorBox, error);
    }

  
    // create the boxes which to write the RGB values into
    private void createInputPane()
    {
        input = new HBox();
        for(int i = 0; i < 3; i++)
        {
            Text text = new Text();
            rgbText[i] = new TextField();

            if(i == 0)
                text.setText("Red");
            else if(i == 1)
                text.setText("Green");
            else
                text.setText("Blue");

            VBox rgbBox = new VBox();
            rgbBox.setPrefSize(60, 30);
            rgbBox.setPadding(new Insets(10, 10, 10, 10));
            rgbBox.getChildren().addAll(text, rgbText[i]);

            input.getChildren().add(rgbBox);
        }
    }
    
    // Button to generate the color and some error handling, changes the color to red if error
    private void createButtonPane()
    {
        button = new VBox();
        Button btn = new Button();
        btn.setText("Display Color");
        btn.setOnAction(event ->
        {
            //loop through the input boxes and check/verify the values
        	int[] rgbValues = new int[3];
            boolean validRGB = true;
            
            for(int i = 0; i < 3; i++)
            {
               int value = 0;		// initialize 

                if(rgbText[i].getText().equals(""))
                {
                    error.setText("You need to put in a number");
                    colorBox.setFill(Color.rgb(255, 1, 1));
                    validRGB = false;
                }
                else
                {
                    value = Integer.parseInt(rgbText[i].getText());
                    if(value < 1 || value > 255)
                    {
                        error.setText(value + " is not a valid RGB value.");
                        colorBox.setFill(Color.rgb(255, 1, 1));
                        validRGB = false;
                    }
                    else
                    {
                        rgbValues[i] = value;
                    }
                }
            }
            if(validRGB)
            {
                error.setText(""); //reset error text if it has any value
                // Display the color from the values in the boxes
                colorBox.setFill(Color.rgb(rgbValues[0], rgbValues[1], rgbValues[2]));
            }
        });
        button.getChildren().add(btn);
    }

 
    
}
