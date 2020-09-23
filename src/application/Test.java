package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) throws ParseException {
//Query q = em.createQuery(“SELECT a FROM Team a WHERE a.id = :id”);
//.get single result
						
//	EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
//	EntityManager createEntityManager = factory.createEntityManager();
//	createEntityManager.getTransaction().begin();	
//	createEntityManager.persist(manu);
//  createEntityManager.persist(m1);
//	createEntityManager.createNativeQuery("INSERT INTO team (idTeam, Colour, Manager) VALUES (?,?,?)")
//	.setParameter(1, manu.getTeam_id())
//	 .setParameter(2, manu.getColour())
//	 .setParameter(3, manu.getManagerId())
//	 .executeUpdate();
//	createEntityManager.getTransaction().commit();
//	createEntityManager.close();
///	factory.close()
		
		
		
		League A= new League();
		
		Team manu= new Team("red");
		
		Name n1= new Name("Mike", "Alb", "Albert");
		Manager m1= new Manager(n1,"35346786","m.i@mycit,ie","31/12/1998",7);
		m1.setTeam_id(2);
		
		Name n2= new Name("kosi", "dembele", "Albert");
		Player p1= new Player(n2,"084322215","k.a@mycit.ie",24,5,false);
	 
		manu.setaManager(m1);
	    manu.add(p1);
	    
		 A.add(manu);
		 
		 
		System.out.println("League A");
		
		String c="red";
		Team t=A.getTeam(c);
		System.out.println(t.getColour());
		
		A.display();
		A.displayplayers();
		A.displaymanagers();
		A.teammanagers();
		
		
	
		
	}

}
