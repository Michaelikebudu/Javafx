package application;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;



@MappedSuperclass
public class Person {
 @Embedded
 private Name name;
	@Column(name="phone")
 private String phone;
	@Column(name="email")
 private String email;
	
	/** 
	 * 
	 * @param n name object
	 * @param p phone number
	 * @param e email
	 */
 public Person(Name n, String p, String e) {
	 name=n;
	 phone=p;
	 email=e;
 }
 
 public Person() {
	 
 }
 

 /**
  * 
  * @return Name object of Person
  */
public Name getName() {
	return name;
}

/**
 * 
 * @param name
 * Sets name of person
 */
public void setName(Name name) {
	this.name = name;
}

/**
 * 
 * @return phone number
 */
public String getPhone() {
	return phone;
}

/**
 * 
 * @param phone
 * Sets phone number
 */
public void setPhone(String phone) {
	this.phone = phone;
}

/**
 * 
 * @return Email
 */
public String getEmail() {
	return email;
}

/**
 * 
 * @param email
 * Sets Email
 */
public void setEmail(String email) {
	this.email = email;
}


/**
 * ToString
 */
@Override
public String toString() {
	return "Person [name=" + name + ", phone=" + phone + ", email=" + email + "]";
}
 
 
}
