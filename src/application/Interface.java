package application;

import java.io.FileNotFoundException;
import java.text.ParseException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interface extends Application{


	public static void main(String[] args) {
		launch(args);
	}
	@Override 
	
	public void start(Stage primaryStage) throws FileNotFoundException {
		
		TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Add or remove", new Label("Add or remove"));
        Tab tab2 = new Tab("Edit detail", new Label("Edit details"));
        Tab tab3 = new Tab("List and sort" , new Label("List and sort"));

         
		tabPane.getTabs().add(new Add());
		tabPane.getTabs().add(new Add_Team());
		tabPane.getTabs().add(new Add_manager());
        tabPane.getTabs().add(new Edit());
        tabPane.getTabs().add(new List());
        tabPane.getTabs().add(new Search());
        tabPane.getTabs().add(new DisplayPlayer());
        VBox vBox = new VBox(tabPane);
        
        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX App");

        primaryStage.show();
        
        
	}
}
