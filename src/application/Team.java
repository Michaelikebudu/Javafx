package application;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="team")
@Embeddable
public class Team implements Serializable {


    @Transient private Manager manager;
	@Transient private ArrayList<Player> player = new ArrayList<Player>();
	
	@Column(name="Colour")
	private String colour;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idTeam")
	private Integer Team_id;
	
	/**
	 * 
	 * @param c colour of team
	 * constructor of team
	 */

	public Team(String c) {

		colour = c;
	}
	public Team() {
		
	}
	
	/**
	 * 
	 * @return the id(primary key) of team
	 */
	public Integer getTeam_id() {
		return Team_id;
	}

	/**
	 * 
	 * @param team_id primary key
	 * sets primary key of team to team_id
	 */
	public void setTeam_id(Integer team_id) {
		Team_id = team_id;
	}
	
	/**
	 * 
	 * @return the Manager of a Team
	 */
	public Manager getaManager() {
		return manager;
	}
	
	
	/**
	 * 
	 * @param manager Manager object
	 * Sets the Manager of a team 
	 */
   
	public void setaManager(Manager manager) {
		this.manager = manager;
	}
	
	/**
	 * 
	 * @return the colour of a team
	 */
	public String getColour() {
		return colour;
	}
	
 /**
  * 
  * @param colour team colour
  * Sets the colour of the team
  * 
  */
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	/**
	 * 
	 * @param p player object
	 * Adds player to a team. Team has an array of players
	 */
	public void add(Player p) {
		player.add(p);
	}

	/**
	 * 
	 * @param p player object
	 * Removes a player from a team
	 */
	public void remove(Player p) {
		for (int i = 0; i < player.size(); i++) {
			if (player.get(i).equals(p)) {
				player.remove(i);
			}
		}
	}
 /**
  * 
  * @param f firstname of player
  * @param l lastname of player
  * Removes player from a team using their firstname and lastname
  */
	public void remove(String f, String l) {
		for (int i = 0; i < player.size(); i++) {
			if (player.get(i).getName().getFirstname().equals(f) && player.get(i).getName().getLastname().equals(l)) {
				player.remove(i);
			}
		}
	}

	/**
	 *  Display all players in a team
	 */
	public void display() {
		for (int i = 0; i < player.size(); i++) {
			System.out.println(player.get(i).toString());
  	}
	}

	/**
	 * ToString of team
	 */
	@Override
	public String toString() {
		return "Team [colour=" + colour + "]";
	}

}
