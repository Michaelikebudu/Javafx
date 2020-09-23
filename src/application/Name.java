package application;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class Name {
	@Column(name="firstname")
private String firstname;
	@Column(name="lastname")
private String lastname;
	@Column(name="middlename")
private String middlename;
	
   public Name(String f, String m, String l) {
	   firstname=f;
	   middlename=m;
	   lastname=l;
   }
   
   public Name() {
	   
   }
   
public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getMiddlename() {
	return middlename;
}

public void setMiddlename(String middlename) {
	this.middlename = middlename;
}

@Override
public String toString() {
	return "Name [firstname=" + firstname + ", lastname=" + lastname + ", middlename=" + middlename + "]";
}
   
   
}
