package application;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class Service {
	
	private League A;

	/**
	 * Service class for the database or Model
	 */
	public Service() {
		A = new League();
	}

	
	/**
	 * 
	 * @param firstname player firstname
	 * @param middlename player middlename
	 * @param lastname player lastname
	 * @param p player phone number
	 * @param e player email
	 * @param a player age
	 * @param g player goal
	 * @param go goalie or not
	 * @param t player team
	 * function adds player to the database and uses team id as foreign key to player
	 */
	public void addplayer(String firstname, String middlename, 
			String lastname,String p, String e, int a, int g, boolean go, String t) {
		Name n1=new Name(firstname,middlename, lastname);
		Player p1=new Player(n1,p,e,a,g,go);
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query = createEntityManager.createQuery( "SELECT te.Team_id FROM Team te WHERE te.colour = ?1");
		query.setParameter(1, t);
		
		Integer foreign = (Integer)query.getSingleResult();
		
		System.out.println(foreign);
		p1.setTeamid(foreign);
		createEntityManager.persist(p1);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		
	}
	
	/**
	 * 
	 * @param lastname
	 * @return first name of player using last name just for testing the add_function
	 */
	public String player_firstname(String lastname) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query =createEntityManager.createNativeQuery( "SELECT p.firstname FROM Player p WHERE  p.lastname = '"+lastname+"'");
		String firstname = (String)query.getSingleResult();
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		return firstname;
		
	}
	

	/**
	 * 
	 * @param firstname player firstname
	 * @param lastname player lastname
	 * @param t player team colour
	 * function removes player from the database
	 */
	public void removeplayer(String firstname,String lastname ,String t) {	
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query =createEntityManager.createNativeQuery( "SELECT m.idplayer FROM Player m WHERE m.firstname = '"+firstname+"'"+
	            "and m.lastname = '"+lastname+"'");
		Integer foreign = (Integer)query.getSingleResult();
		Player p = createEntityManager.find(Player.class, foreign);
		System.out.println(p);
		createEntityManager.remove(p);
		
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		
	}
	
	
	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @return player goal
	 */
	
	public String goal(String firstname,String lastname ) {
		String goal;
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query query =createEntityManager.createNativeQuery( "SELECT p.goal FROM Player p WHERE p.firstname = '"+firstname+"'"+
	            "and p.lastname = '"+lastname+"'");
	  String list =  (String) query.getSingleResult();
	   goal=list;
	   createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		//System.out.println(goal);
		return goal;
	}
	
	
	/**
	 * 
	 * @param firstname player firstname
	 * @param lastname player lastname
	 * @return displays the player goals and the Manager of the player
	 */
	public String search(String firstname,String lastname ) {
		String detail="";
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query query =createEntityManager.createNativeQuery( "SELECT p.goal FROM Player p WHERE p.firstname = '"+firstname+"'"+
	            "and p.lastname = '"+lastname+"'");
	     List<String> list = query.getResultList();
	     detail=detail+"player goals:"+"\n";
	     for(String e:list) {
	    	 detail=detail+e+"\n";
	     }
	     Query quer =createEntityManager.createNativeQuery( "SELECT p.Teamid FROM Player p WHERE p.firstname = '"+firstname+"'"+
		            "and p.lastname = '"+lastname+"'");
	    String foreign = (String)quer.getSingleResult();
	    Integer i = Integer.parseInt(foreign);
	    Query que =createEntityManager.createNativeQuery( "SELECT m.idmanager FROM Manager m WHERE m.idTeam = '"+i+"'");
	    int mid = (int) que.getSingleResult();
	    
	    Manager m = createEntityManager.find(Manager.class, mid);
	    System.out.println("Manager Details Are : \n"+m);
	    detail=detail+"Player Manager:"+"\n";
	    detail= detail+m.toString();
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
	     return detail;
	}
	
	/**
	 * 
	 * @param t team colour
	 * @return Display all the players in team t
	 */
	
	public String display_player(String t) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query = createEntityManager.createQuery( "SELECT t.Team_id FROM Team t WHERE t.colour = :color");
		query.setParameter("color", t);
		Integer foreign = (Integer)query.getSingleResult();
		String display="Players in the team are"+"\n";
		Query q=createEntityManager.createNativeQuery("Select * FROM Player p WHERE p.Teamid='"+foreign+"'",Player.class);
		List<Player> list =  q.getResultList();
		for(Player e:list) {
			display=display+e.toString()+"\n";
	    	
	     }
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		return display;
	}
	
	
	/**
	 * 
	 * @return all the teams in the league
	 */
	public String display_Teams() {
		String display="Teams in league are"+"\n";
			EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
			EntityManager createEntityManager = factory.createEntityManager();
			createEntityManager.getTransaction().begin();
			Query q=createEntityManager.createQuery("SELECT t FROM Team t",Team.class);
			List<Team> list =  q.getResultList();
			for(Team e:list) {
				display=display+e.toString()+"\n";	
		     }
			createEntityManager.getTransaction().commit();
			createEntityManager.close();
			factory.close();
			return display;
	}
	
	/**
	 * 
	 * @return sorted Manager alphabetically according to firstname
	 */
	public String sortManager() {
		String display="Sorted Manager alphabetically"+"\n";
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query q=createEntityManager.createQuery("SELECT m FROM Manager m",Manager.class);
		List<Manager> list =  q.getResultList();
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		
		  Collections.sort(list, new Comparator<Manager>()
		  
		  {

			//@Override
			public int compare(Manager a, Manager b) {
				// TODO Auto-generated method stub
				String a1= a.getName().getFirstname();
				String a2= b.getName().getFirstname();
				System.out.println(a1);
				System.out.println(a2);
				return a1.compareTo(a2);
				
				
			}
  
});
		
			for(int i=0; i<list.size();i++) 
				display=display+list.get(i)+"\n";
			return display;
	}
	
	
	/**
	 * 
	 * @return sorted Managers according to their rating
	 */
	
	public String sortManagerrate() {
		String display="Sorted Manager according to rating"+"\n";
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query q=createEntityManager.createQuery("SELECT m FROM Manager m",Manager.class);
		List<Manager> list =  q.getResultList();
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		  Collections.sort(list, new Comparator<Manager>()
		  
		  {

			//@Override
			public int compare(Manager a, Manager b) {
				// TODO Auto-generated method stub
				String a1= String.valueOf(a.getRate());
				String a2= String.valueOf(b.getRate());
				
				return a1.compareTo(a2);
				
				
			}
  
});
	
			for(int i=0; i<list.size();i++) 
				display=display+list.get(i)+"\n";
			return display;
	}
	
	
	/**
	 * 
	 * @return sorted players according to their firstname
	 */
	public String sortPlayer() {
		String display="Sorted Player alphabetically"+"\n";
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query q=createEntityManager.createQuery("SELECT p FROM Player p",Player.class);
		List<Player> list =  q.getResultList();
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		
		  Collections.sort(list, new Comparator<Player>()
		  
		  {

			//@Override
			public int compare(Player a, Player b) {
				// TODO Auto-generated method stub
				String a1= a.getName().getFirstname();
				String a2= b.getName().getFirstname();
				System.out.println(a1);
				System.out.println(a2);
				return a1.compareTo(a2);
				
				
			}
  
});
		
			for(int i=0; i<list.size();i++) 
				display=display+list.get(i)+"\n";
			return display;
	}

	
	
	/**
	 * 
	 * @param c team colour
	 * Adds a team to the database
	 */
	public void addTeam(String c) {
		
	EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
	EntityManager createEntityManager = factory.createEntityManager();
	createEntityManager.getTransaction().begin();
	Team t1=new Team(c);
	createEntityManager.persist(t1);
	createEntityManager.getTransaction().commit();
	createEntityManager.close();
	factory.close();
	
	}
	
	/**
	 * 
	 * @param c team colour
	 * Remove a team from the database
	 */
	
	public void removeTeam(String c) {

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query query = createEntityManager.createQuery( "SELECT t.Team_id FROM Team t WHERE t.colour = :color");
		query.setParameter("color", c);

		Integer foreign = (Integer)query.getSingleResult();
		Team t = createEntityManager.find(Team.class, foreign);
		
		createEntityManager.remove(t);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		
	}
	
     /**
      * 
      * @param firstname Manager firstname
      * @param middlename Manager middlename
      * @param lastname Manager lastname
      * @param phone Manager phone number
      * @param email Manager email
      * @param d Manager date of birth
      * @param r Manager rating
      * @param t Managet team
      * function adds Manager to the database and uses team id as foreign key
      */
	
	public void addManager(String firstname,String middlename, String lastname,String phone,String email,String d,int r,String t) {
		Name n1=new Name(firstname,middlename, lastname);
		Manager m= new Manager(n1, phone,email,d,r);
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query = createEntityManager.createQuery( "SELECT t.Team_id FROM Team t WHERE t.colour = :color");
		query.setParameter("color", t);
		Integer foreign = (Integer)query.getSingleResult();
		System.out.println(foreign);
		m.setTeam_id(foreign);
		createEntityManager.persist(m);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();	
	}
	
	/**
	 * 
	 * @param t Team
	 * function removes the manager of a team from the database
	 */
	
	public void removeManager(String t) {
		
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query = createEntityManager.createQuery( "SELECT t.Team_id FROM Team t WHERE t.colour = :color");
		query.setParameter("color", t);
		Integer foreign = (Integer)query.getSingleResult();
		Team tea = createEntityManager.find(Team.class, foreign);
		tea.setaManager(null);
		createEntityManager.merge(tea);
		Query quer = createEntityManager.createQuery("SELECT m.managerid FROM Manager m WHERE m.Team_id = :team");
		quer.setParameter("team", foreign);
		Integer foreign2 = (Integer)quer.getSingleResult();
		Manager manager = createEntityManager.find(Manager.class, foreign2);	
		createEntityManager.remove(manager);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
				
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
	 * function updates player details in the database no matter which attribute is changed it will take effect
	 */
	
	public void update_Playerdetails(String firstname, String middlename, 
			String lastname,String p, String e, int a, int g, boolean go, String t) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query =createEntityManager.createNativeQuery( "SELECT m.idplayer FROM Player m WHERE m.firstname = '"+firstname+"'"+
	            "and m.lastname = '"+lastname+"'");
		Integer foreign = (Integer)query.getSingleResult();
		Name n= new Name(firstname, middlename,lastname);
		Player pl = createEntityManager.find(Player.class, foreign);
		pl.setName(n);
		pl.setPhone(p);
		pl.setEmail(e);
		pl.setAge(a);
		pl.setGoals(g);
		pl.setGoalie(go);
		Query querys = createEntityManager.createQuery( "SELECT t.Team_id FROM Team t WHERE t.colour = :color");
		querys.setParameter("color", t);
		Integer teamid = (Integer)querys.getSingleResult();
		pl.setTeamid(teamid);
		createEntityManager.merge(pl);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
	}
	
	 public String memory() {
		  Runtime r=Runtime.getRuntime(); 
		  
		  r.gc();
	      
	      return "No of Processor: "+ r.availableProcessors()+"\n"+"Total memory: "+
	         r.totalMemory()+
				  "\n"+"Free memory: "+r.freeMemory()+"\n"+"Memory occupied: "+
			         (r.totalMemory()-r.freeMemory());

	  }
}
