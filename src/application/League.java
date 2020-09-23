package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class League {
	/**
	 * Arraylist that stores teams in the league.
	 *  The application was developed for a single league
	 */
	 private ArrayList<Team> team=new ArrayList<Team>();  
	 
	 /**
	  * 
	  * @param t takes a team object
	  * function adds the team object to the arraylist of team in league
	  */
	 public void add(Team t) {
		 team.add(t);
	 }
	 
	 /**
	  * 
	  * @param t takes a team object
	  * function removes team object from the arraylist of team in league
	  */
	 public void remove(Team t) {
		 for(int i=0;i<team.size(); i++) {
			 if(team.get(i).equals(t)) {
				 team.remove(i);
			 }
		 }
	 }
	 
	 /**
	  * 
	  * @param c takes the color of the team which is unique
	  * function removes the team from the arraylist of team in the league using the color of the team
	  */
	 public void remove(String c) {
		 for(int i=0;i<team.size(); i++) {
			 if(team.get(i).getColour().equals(c)) {
				 team.remove(i);
			 }
		 }
	 }
	 
	 /**
	  * 
	  * @return the size of the team arraylist
	  */
	 public int getSize() {
		 return team.size();
	 }
	 
	 /**
	  * 
	  * @param c takes the unique color of a team
	  * @return the team object of a team using their color
	  */
	 public Team getTeam(String c) {
		 Team t = null;
		
		 for(int i=0;i<team.size();i++) {
			 if(team.get(i).getColour().equals(c)) {
			 
				t=team.get(i);
			 }
			
			
		 }
		
		return t;
		
	 }
	 
	 
	 /**
	  * function prints the team in the arraylist of team in the league
	  */
	 public void display() {
		 for(int i=0; i<team.size();i++) {
			 System.out.println(team.get(i));
		 }
	 }
	 
	 /**
	  * The function prints all the players in the league by accessing the player in each team.
	  * uses the display function in team{@link:Team.java}.
	  * 
	  */
	 public void displayplayers() {
		 for(int i=0; i<team.size();i++) {
			team.get(i).display();
			
		 }
	 }
	 
	 /**
	  * function prints our the manager of each team in the league thereby printing all Managers
	  */
	 public void displaymanagers() {
		 for(int i=0; i<team.size();i++) {
			System.out.println(team.get(i).getaManager());
		 }
	 }
	 
	 /**
	  * functions prints each team in the league and their manager
	  */
	 public void teammanagers() {
		 for(int i=0; i<team.size();i++) {
			 System.out.print(team.get(i));
			System.out.println(team.get(i).getaManager());
		 }
	 }
	 
//	 public void write() {
//			
//			try {
//				FileOutputStream fos = new FileOutputStream("TeamData",true);
//				ObjectOutputStream oos = new ObjectOutputStream(fos);
//				oos.writeObject(team);
//				oos.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	 
//	 public void read() {
//			try
//	        {
//	            FileInputStream fis = new FileInputStream("TeamData");
//	            ObjectInputStream ois = new ObjectInputStream(fis);
//	            team = (ArrayList) ois.readObject();
//	            ois.close();
//	           
//	        }
//			  catch (IOException ioe) 
//	        {
//	            ioe.printStackTrace();
//	            return;
//	        } 
//	        catch (ClassNotFoundException c) 
//	        {
//	            System.out.println("Class not found");
//	            c.printStackTrace();
//	            return;
//	        }
//	  }
}
