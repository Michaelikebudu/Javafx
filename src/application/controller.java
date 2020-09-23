package application;
import org.junit.Before;
import org.junit.Test;

/**
 *  Methods in controller call on{@link Service.java} to performm action then passes
 *  result to view
 * @author Michael
 * Controller class
 */
public class controller {
	

private Service service= new Service();

public controller() {
	
}

/**
 * 
 * @param firstname player firstname
 * @param middlename player middlename
 * @param lastname player lastname
 * @param p player phone number
 * @param e player email
 * @param a player age
 * @param g player goals
 * @param go goalie or not
 * @param t player team
 * function calls on the add player method in {@link Service.java} to add player to database
 */
@Test
public void addplayer(String firstname, String middlename, String lastname,String p, String e, int a, int g, boolean go, String t) {
	
	service.addplayer(firstname, middlename, lastname, p,  e,  a,  g,  go, t);
	
	
}

/**
 * 
 * @param firstname player firstname
 * @param lastname player lastname
 * @param t player team
 * Calls on the remove player in the {@link Service.java} to remove player from database
 */

public void removeplayer(String firstname,String lastname ,String t) {
	service.removeplayer( firstname, lastname ,t) ;
}

/**
 * 
 * @param firstname player firstname
 * @param lastname player lastname
 * @return calls on {@link Service.java} search method to return player goals and Manager of player
 */
public String search(String firstname,String lastname ) {
	return service.search(firstname, lastname);
}

/**
 * 
 * @param t team color
 * @return calls on {@link Service.java} dispaly_player method to get all the players 
 * in a team then passes the value to view
 */
public String display_player(String t) {
	return service.display_player(t);
}

/**
 * 
 * @return call on the service class method to get all the player in the league
 * then passes the return value to the view
 */
public String display_Teams() {
	return service.display_Teams();
}

/** 
 * 
 * @return return manager sorted by firstname
 * Calls on model/service class sortManager method to sort Manager according to firstname
 * then returns the sorted to view
 */
public String sortManager() {
	return service.sortManager();
}

/**
 * 
 * @return sorted Manager by rating
 */
public String sortManagerrate() {
	return service.sortManagerrate();
}

/**
 * 
 * @return sorted players by firstname
 */
public String sortPlayer() {
	return service.sortPlayer();
}

/**
 * 
 * @param c
 * add team to the database
 */
public void addTeam(String c) {
	 service.addTeam(c);
}

/**
 * 
 * @param c
 * remove team from database
 */
public void removeTeam(String c) {
	service.removeTeam(c);
}

/**
 * 
 * @param firstname
 * @param middlename
 * @param lastname
 * @param phone
 * @param email
 * @param d
 * @param r
 * @param t
 * adds Manager to the database
 */
public void addManager(String firstname,String middlename, String lastname,String phone,String email,String d,int r,String t) {
	service.addManager(firstname, middlename, lastname, phone, email, d, r, t);
}

/**
 * 
 * @param t
 * remove Manager from database
 */
public void removeManager(String t) {
	service.removeManager(t);
}

/**
 * 
 * @param firstname
 * @param middlename
 * @param lastname
 * @param p
 * @param e
 * @param a
 * @param g
 * @param go
 * @param t
 * update already existing player details in database
 */
@Test
public void update_Playerdetails(String firstname, String middlename, String lastname,String p, String e, int a, int g, boolean go, String t) {
	service.update_Playerdetails(firstname, middlename, lastname, p, e, a, g, go, t);
}

public String getgoals(String f, String l) {
	return service.goal(f, l);
	
}
public String getFirstname(String l) {
	System.out.println(service.player_firstname(l));
	return service.player_firstname(l);
}
public String memory() {
	return service.memory();
}
}