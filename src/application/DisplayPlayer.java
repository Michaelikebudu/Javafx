package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
/**
 * 
 * @author Michael
 * Tab to display Players in a team
 *
 */
public class DisplayPlayer extends Tab {
	private TextField t;
	private Label team;
	private controller c= new controller();
	private Button Display;
	
	public DisplayPlayer() {
		setText("DisplayPlayer");
		team= new Label("Team");
		t=new TextField();
		Display= new Button("Display & Memory usage");
		HBox h1= new HBox(10);
		h1.getChildren().addAll(team,t);
		
	    TextArea textarea= new TextArea();
	    
	    VBox v1= new VBox(10);
	    v1.getChildren().addAll(h1,textarea,Display);
	    
	    Pane pane = new Pane();
	    pane.getChildren().addAll(v1);
	    setContent(pane);
		
	    Display.setOnAction(new EventHandler<ActionEvent>() {
//		    @Override
	    public void handle(ActionEvent event) {
		String n = c.display_player(t.getText())+"\n"+"Memory used"+c.memory();
		textarea.setText(n);
		}
	        });
		
	}

}
