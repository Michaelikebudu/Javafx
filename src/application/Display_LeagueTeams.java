package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Display_LeagueTeams extends Tab {
	private Button Display;
	private controller c= new controller();
	
	/**
	 * Tab to Display Teams in the League
	 */
	public Display_LeagueTeams() {
		setText("Display_LeagueTeam");
		TextArea textarea= new TextArea();
		Display= new Button("Display");
		VBox v1= new VBox();
		v1.getChildren().addAll(textarea,Display);
		
		 Pane pane = new Pane();
		 pane.getChildren().addAll(v1);
		  setContent(pane);
			
		    Display.setOnAction(new EventHandler<ActionEvent>() {
//			    @Override
		    public void handle(ActionEvent event) {
			String n = c.display_Teams();
			textarea.setText(n);
			}
		        });

	}

}
