package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * 
 * @author Michael
 * Tab to sort Manager by firstname, rating
 * Tab to sort Player by firstname
 *
 */
public class List extends Tab{
	private Button sortManager;
	private Button sortPlayer;
	private Button sortManagerrating;
	private Button memory;
	private controller c= new controller();
 public List() {
	 setText("Sort");
	 sortManager=new Button("sortManger");
	 sortPlayer= new Button("sortPlayer");
	 memory=new Button("Memory");
	 sortManagerrating= new Button("sortManagerrating");
	 TextArea textarea= new TextArea();
	 
	 HBox h1= new HBox(10);
	 h1.getChildren().addAll(sortManager,sortPlayer, sortManagerrating, memory);
	 
	 VBox v1= new VBox(10);
	 v1.getChildren().addAll(textarea,h1);
	 
	 Pane pane = new Pane();
	 pane.getChildren().addAll(v1);
	  setContent(pane);
		
	    sortManager.setOnAction(new EventHandler<ActionEvent>() {
//		    @Override
	    public void handle(ActionEvent event) {
		
		String n = c.sortManager();
		textarea.setText(n);
    	 
		
	    }
	    });
	    
	    sortPlayer.setOnAction(new EventHandler<ActionEvent>() {
//		    @Override
	    public void handle(ActionEvent event) {
		
		String n = c.sortPlayer();
		textarea.setText(n);
    	 
		
	    }
	    });
	    
	    sortManagerrating.setOnAction(new EventHandler<ActionEvent>() {
//		    @Override
	    public void handle(ActionEvent event) {
		
		String n = c.sortManagerrate();
		textarea.setText(n);
    	 
		
	    }
	    });
	   memory.setOnAction(new EventHandler<ActionEvent>() {
//		    @Override
	    public void handle(ActionEvent event) {
		
		String n = c.memory();
		textarea.setText(n);
    	 
		
	    }
	    });
 }
}
