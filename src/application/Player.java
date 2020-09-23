package application;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")

public class Player extends Person {
	@Column(name="age")
   private int age;
	@Column(name="goal")
  private  int goals;
	@Column(name="goalie")
 private  boolean goalie;
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="idplayer")
  private  int playerid;
   
   @Column(name="Teamid")
  private  int teamid;
   
   /**
    * Class extends Person{@link Person.java}
    * @param n Name object inherited
    * @param p phone number inherited
    * @param e  email inherited
    * @param a age of player
    * @param g  goals of player
    * @param go  boolean goalie or not
    * Constructor of player
    */
   
	public Player(Name n, String p, String e, int a, int g, boolean go) {
		super(n, p, e);
		age=a;
		goals=g;
		goalie=go;
		
	
	}
	
	public Player() {
		
	}
	
	/**
	 * 
	 * @return goalie
	 */
	public boolean isGoalie() {
		return goalie;
		
	}
	/**
	 * 
	 * @param goalie takes boolean goalie or not
	 * sets the attribute goalie
	 */
	public void setGoalie(boolean goalie) {
		this.goalie = goalie;
	}
	/**
	 * 
	 * @return the player number of goals
	 */
	public int getGoals() {
		return goals;
	}
	
	/**
	 * 
	 * @param goals takes player goals
	 * Sets player goals
	 */
	public void setGoals(int goals) {
		this.goals = goals;
	}
	
	/**
	 * 
	 * @return player id primary key
	 */
	public int getPlayerid() {
		return playerid;
	}

	/**
	 * 
	 * @param playerid takes player id primary  key
	 * Sets player id
	 */
	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}
   /**
    * 
    * @return Team id foreign key
    */
	public int getTeamid() {
		return teamid;
	}
    
	/**
	 * 
	 * @param teamid takes team id
	 * Sets team id (foreign key)
	 */
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	/**
	 * 
	 * @return player age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 
	 * @param age players age
	 * Sets players age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * ToString for player
	 */
	@Override
	public String toString() {
		return "Player [Name=" + getName() + ",age=" + age + ", goals=" + goals + ", goalie=" + goalie + "]";
	}
	
	
	
	
	
	
	

}
