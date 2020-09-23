package application;

import javafx.geometry.Pos;
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
 * Tab for adding, removing and updating player details
 */
public class Add extends Tab {
	
	private Label Firstname;
	private Label Middlename;
	private Label lastname;
	private Label team;
	private Label email;
	private Label phone;
	private Label age;
	private Label goal;
	private Label goalie;
	
	private Label firstname;
	private Label Lastname;
	private Label Team;
	
	private TextField f;
	private TextField m;
	private TextField l;
	private TextField t;
	private TextField em;
	private TextField p;
	private TextField a;
	private TextField g;
	private TextField go;
	
	private TextField fi;
	private TextField la;
	private TextField Te;
	
	private Button add;
	private Button remove;
	private Button update;
	
	private controller c=new controller();
	
	public Add() {
		setText("Players");
		
		Firstname= new Label("Firstname:");
		f= new TextField();
		lastname= new Label("lastname:");
		l= new TextField();
		Middlename= new Label("Middlename:");
		m= new TextField();
		

		
		em= new TextField();
		email=new Label("E-mail:");
		a= new TextField();
		age=new Label("AGE:");
		p= new TextField();
		phone=new Label("Phone number:");
		g= new TextField();
		goal=new Label("Goals:");
		go= new TextField();
		goalie=new Label("Goalie:");
		t= new TextField();
	    team=new Label("Team:");
		
		add= new Button("Add");
		
		update= new Button("update");
		
		firstname= new Label("Firstname:");
		fi= new TextField();
		Lastname= new Label("lastname:");
		la= new TextField();
		Team= new Label("Team:");
		Te= new TextField();
		remove= new Button("remove");
		
		
		
		Text text1=new Text("Add Player");
		text1.setStyle("-fx-font-weight: bold");
	    text1.setTextAlignment(TextAlignment.CENTER);
	    
	    
	    
		
	    HBox h0= new HBox(10);
		h0.getChildren().addAll(text1);
		
		HBox h1= new HBox(10);
	    h1.getChildren().addAll(Firstname,f);
	    
		HBox h2= new HBox(10);
	    h2.getChildren().addAll(Middlename,m);
	    
		HBox h3= new HBox(10);
	    h3.getChildren().addAll(lastname,l);
	    
	    HBox h4= new HBox(10);
	    h4.getChildren().addAll(phone,p);
	    HBox h5= new HBox(10);
	    h5.getChildren().addAll(email,em);
	    HBox h6= new HBox(10);
	    h6.getChildren().addAll(age,a);
	    HBox h7= new HBox(10);
	    h7.getChildren().addAll(goal,g);
	    
        HBox h8= new HBox(10);
	    h8.getChildren().addAll(goalie,go);    
	    HBox h9 = new HBox(10);
	    h9.getChildren().addAll(team,t);
	    
		HBox h10= new HBox(20);
	    h10.getChildren().addAll(add, update);
	    
	    VBox v1=new VBox(10);
	    v1.getChildren().addAll(h0,h1,h2,h3,h4,h5,h6,h7,h8,h9,h10);
	    
	    Text text2=new Text("Remove player");
		text2.setStyle("-fx-font-weight: bold");
	    text2.setTextAlignment(TextAlignment.CENTER);
	    
	    HBox h11= new HBox(10);
		h11.getChildren().addAll(text2);
		HBox h12= new HBox(10);
		h12.getChildren().addAll(firstname,fi);
		HBox h13= new HBox(10);
		h13.getChildren().addAll(Lastname,la);
		HBox h14= new HBox(10);
		h14.getChildren().addAll(Team,Te);

		 VBox v2=new VBox(10);
		  v2.getChildren().addAll(h11,h12,h13,h14,remove);
		  
		  VBox v3=new VBox(30);
		  v3.getChildren().addAll(v1,v2);
	   
	    
	    add.setOnAction(e -> c.addplayer(f.getText(), m.getText(),l.getText(), p.getText(),em.getText(),Integer.parseInt(a.getText()),Integer.parseInt(g.getText()), 
	    		Boolean.parseBoolean(go.getText()), t.getText()));
	    
	    remove.setOnAction(e -> c.removeplayer(fi.getText(), la.getText(), Te.getText()));
	 
	    
	    update.setOnAction(e -> c.update_Playerdetails(f.getText(), m.getText(),l.getText(), p.getText(),em.getText(),Integer.parseInt(a.getText()),Integer.parseInt(g.getText()), 
	    		Boolean.parseBoolean(go.getText()), t.getText()));
	    
	    Pane pane = new Pane();
	    pane.getChildren().addAll(v3);
	    setContent(pane);
	}
	

}
