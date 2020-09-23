package application;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

public class Update_Test {
     @Test
	    public void test() {
		 controller c= new controller();
		 
		 c.update_Playerdetails("Michael", "Okeke", "Pogba", "23456", "m.p@mycit.ie", 26, 6,Boolean.parseBoolean("false"), "orange");
		 
		 String goal=c.getgoals("Michael", "Pogba");
		 assertEquals("6",goal);
     }
}
