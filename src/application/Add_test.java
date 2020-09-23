package application;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
public class Add_test {
	@Test
    public void test() {
	 controller c= new controller();
	// c.addplayer("Adam", "Bentley", "Rooney", "085634", "a.b@club.ie", 25, 7, false, "blue");
	 String firstname=c.getFirstname("Rooney");
	 assertEquals("Adam",firstname);
	}
}
