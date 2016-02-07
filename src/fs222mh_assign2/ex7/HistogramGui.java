package fs222mh_assign2.ex7;

import java.io.File;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class HistogramGui extends Application {
	
	private File file;
	private ObservableList<PieChart.Data> chartData;
	
	// Constructor
	public HistogramGui() {
		
		// Using PieChart since I know how to :)
		chartData = FXCollections.observableArrayList(
		new PieChart.Data("1-10", 0),
		new PieChart.Data("11-20", 0),
		new PieChart.Data("21-30", 0),
		new PieChart.Data("31-40", 0),
		new PieChart.Data("41-50", 0),
		new PieChart.Data("51-60", 0),
		new PieChart.Data("61-70", 0),
		new PieChart.Data("71-80", 0),
		new PieChart.Data("81-90", 0),
		new PieChart.Data("91-100", 0));
	}
	
	@Override
	public void start(Stage stage) {
		 BorderPane bp = new BorderPane();
		 
		 // Choose file
		 FileChooser choose = new FileChooser();
		 choose.getExtensionFilters().add(new ExtensionFilter("Plain text file", "*.txt"));
		 
		 // Fiddling with menu
		 MenuItem open = new MenuItem("Open");
		 open.setOnAction((ActionEvent) -> {
			file = choose.showOpenDialog(stage);
			doStuff();
		 });
		 
		 MenuItem quit = new MenuItem("Quit");
		 quit.setOnAction((ActionEvent) -> {
			 System.exit(0);
		 });
		 
		 Menu file = new Menu("File");
		 file.getItems().addAll(open, quit);
		 
		 MenuBar bar = new MenuBar();
		 bar.getMenus().addAll(file);
		 bp.setTop(bar); 
		
		 
		 //Chart
		 PieChart chart = new PieChart(chartData);
		 bp.setCenter(chart);
		 
		 Scene scene = new Scene(bp);
		 stage.setScene(scene);
		 stage.setTitle("Histogram");
		 stage.show();
		 		 
	}
	
	/**
	 * Using histogram to create nice charts
	 */
	public void doStuff() {
		Histogram hg = new Histogram();
		
		hg.scan(file);
		int[] data = hg.getData();
		
		for (int i = 0; i < data.length; i += 1) {
			chartData.get(i).setPieValue((double)data[i]);
		}
	}
	
	/**
	 * Launches the GUI
	 */
	public void fire() {
		launch();
	}

	
}
