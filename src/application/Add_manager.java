package application;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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
 * Tab for adding and removing Manager from db
 *
 */
public class Add_manager extends Tab {
	private controller c=new controller();
	private Label Firstname;
	private Label Middlename;
	private Label lastname;
	private Label team;
	private Label email;
	private Label phone;
	private Label date;
	private Label rate;
	
	private Label Team;
	
	private TextField fi;
	private TextField mi;
	private TextField la;
	private TextField te;
	private TextField em;
	private TextField p;
	private TextField d;
	private TextField r;
	
	private TextField Tea;
	
	private Button add;
	private Button remove;
	
	
	public Add_manager()  {
		
		setText("Manager");
		Firstname=new Label("Firstname:");
		Middlename=new Label("Middlename:");
		lastname=new Label("lastname:");
		team=new Label("Team:");
		email=new Label("E-mail:");
		phone=new Label("Phone:");
		date=new Label("Date:");
		rate=new Label("Rate:");
		
		Team= new Label("Team:");
		
		fi=new TextField();
		mi=new TextField();
		la=new TextField();
		te=new TextField();
		em=new TextField();
		p=new TextField();
		d=new TextField();
		r=new TextField();
		
		Tea= new TextField();
		
		
		remove=new Button("remove");
		add= new Button("Add");
	
		
		Text text1=new Text("Add Manager");
		text1.setStyle("-fx-font-weight: bold");
	    text1.setTextAlignment(TextAlignment.CENTER);
		
		HBox h1= new HBox();
		h1.getChildren().addAll(Firstname,fi);
		HBox h2= new HBox();
		h2.getChildren().addAll(Middlename,mi);
		HBox h3= new HBox();
		h3.getChildren().addAll(lastname,la);
		HBox h4= new HBox();
		h4.getChildren().addAll(team,te);
		HBox h5= new HBox();
		h5.getChildren().addAll(email,em);
		HBox h6= new HBox();
		h6.getChildren().addAll(phone,p);
		HBox h7= new HBox();
		h7.getChildren().addAll(date,d);
		HBox h8= new HBox();
		h8.getChildren().addAll(rate,r);
		
		HBox h9= new HBox();
		h9.getChildren().addAll(add);
		
		VBox v1= new VBox();
		v1.getChildren().addAll(text1,h1,h2,h3,h4,h5,h6,h7,h8,h9);
		
		
		Text text2=new Text("Remove Manager");
		text2.setStyle("-fx-font-weight: bold");
	    text2.setTextAlignment(TextAlignment.CENTER);
		HBox h10= new HBox();
		h10.getChildren().addAll(Team,Tea);
		HBox h11= new HBox();
		h11.getChildren().addAll(remove);

		VBox v2= new VBox();
		v2.getChildren().addAll(text2,h10,h11);
		
		VBox v3= new VBox(30);
		v3.getChildren().addAll(v1,v2);
		
		
		 Pane pane = new Pane();
		  pane.getChildren().addAll(v3);
		  setContent(pane);
		  
		//  SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
		 // java.util.Date date1;
		 // try {
		//	date1 = formatter1.parse(d.getText());
			add.setOnAction(e ->c.addManager(fi.getText(), mi.getText(), la.getText(), p.getText(), em.getText(), d.getText(), Integer.parseInt(r.getText()), te.getText()));
		//} catch (ParseException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
	//	}
		  
		  remove.setOnAction(e ->c.removeManager(Tea.getText()));
		  
	}

}
