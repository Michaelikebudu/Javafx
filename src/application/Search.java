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
 * Tab to get Player goal and Manager of that player which is the Manager of the team the player plays for. 
 *
 */
public class Search extends Tab {
	private Button search;
	private Button memory;
	private controller c=new controller();
	private TextField f;
	private TextField l;
	private Label first;
	private Label last;
	public Search() {
		
		setText("Search");
		TextArea textarea=new TextArea();
		search= new Button("Search");
		memory= new Button("memory");
		l=new TextField();
		f= new TextField();
		first= new Label("firstname");
		last = new Label("Lastname");
		HBox h1= new HBox();
		h1.getChildren().addAll(first,f);
		HBox h2 = new HBox();
		h2.getChildren().addAll(last,l);
		HBox h3 = new HBox();
		h3.getChildren().addAll(search,memory);
	  VBox v1= new VBox();
	  v1.getChildren().addAll(h1,h2,textarea,h3);
	  
	   
	    Pane pane = new Pane();
	    pane.getChildren().addAll(v1);
	    setContent(pane);
	    search.setOnAction(new EventHandler<ActionEvent>() {
//		    @Override
	    public void handle(ActionEvent event) {
		String n = c.search(f.getText(), l.getText());
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
	   // search.setOnAction(e ->c.search(f.getText(), l.getText()));
	}

}
