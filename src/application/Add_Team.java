package application;

import java.io.Serializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
/**
 * 
 * @author Michael
 *Tab for adding and removing team
 */
public class Add_Team extends Tab implements Serializable{
	private controller c=new controller();
	private Label Team;
	private TextField team;
	private Button add;
	private Button remove;
	
	public Add_Team() {
		 setText("Team");
		
		Text text1=new Text("Add or remove Team");
		text1.setStyle("-fx-font-weight: bold");
	    text1.setTextAlignment(TextAlignment.CENTER);
	    
		Team=new Label("Team:");
		team= new TextField();
		
		remove=new Button("remove");
		add= new Button("Add");
		
		
		HBox h1= new HBox();
		h1.getChildren().addAll(Team,team);
		
		HBox h2= new HBox();
		h2.getChildren().addAll(add,remove);
		
		
		VBox v1= new VBox(40);
		v1.getChildren().addAll(text1, h1,h2);
		
		  add.setOnAction(e ->c.addTeam(team.getText()));
		  remove.setOnAction(e ->c.removeTeam(team.getText()));
		 
		
		 Pane pane = new Pane();
		  pane.getChildren().addAll(v1);
		  setContent(pane);
	}
}
