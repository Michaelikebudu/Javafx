package application;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="manager")

/**
 * 
 * @author Michael
 * Class extends Person
 * Entity tells jpa that the class is an entity
 * Table tells JPa the name of entity in the database
 *Column the column name of each attributes of the entity in the database
 */

public class Manager extends Person {
	@Column(name="DOB")
   private  String date;
	@Column(name="rate")
   private   int rate;
  @Transient private Team team;
  
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="idmanager")
   private Integer managerid;  
	
   @Column(name="idTeam")
   private Integer Team_id;
   
   /**
    * 
    * @param n Name object of the Manager
    * @param p phone number of the Manager
    * @param e  email of the Manager
    * @param d date of birth of manager
    * @param r rating of the manager
    * Constructor of Manager
    */
   
	public Manager(Name n, String p, String e, String d, int r) {
		super(n, p, e);
		date=d;
		rate=r;
		
		
	}
	
	public Manager() {
		super();
	}
	

	/**
	 * 
	 * @return the id (primary key) of the manager
	 */
	public Integer getManagerid() {
		return managerid;
	}


  /**
   * 
   * @param managerid takes the id of the manager
   * function sets the id of the manager
   */
	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	}


    /** 
     * 
     * @param team takes team object
     * Tells the manager which team he/she is managing
     */
	public void setTeam(Team team) {
		this.team = team;
	}
    
	/**
	 * 
	 * @return gets the team of Manager
	 */
	
	public Team getTeam() {
		return team;
	}
   
	/**
	 * 
	 * @return the manager team_id
	 */
	public Integer getTeam_id() {
		return Team_id;
	}

	/**
	 * 
	 * @param team_id primary key of manager team
	 * Sets the manager team_id(foreign key)
	 */

	public void setTeam_id(Integer team_id) {
		Team_id = team_id;
	}
	
	

  /**
   * 
   * @return Managers rating
   */
	public int getRate() {
		return rate;
	}

	/**
	 * 
	 * @param rate takes manager rating
	 * Sets Manger rating
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	/**
	 * ToString method for Manager
	 */

	@Override
	public String toString() {
		return "Manager [Name=" + getName() + ",date=" + date + ", rate=" + rate + " ]";
	}
	
	

}
