package _002_javabeans;

import java.io.Serializable;

//Bu sınıf bir JavaBean'dir. 
public class Person implements Serializable { 
	
	private static final long serialVersionUID = 1L; //Serializable var.
	
	private int personId; //Sınıf değişkenleri var.
	private String personName;
	
	public Person() { // Constructor parametresiz metodu var.
	}

	public Person(int personId, String personName) { // Constructor parametreli metodu var.
		super();
		this.personId = personId;
		this.personName = personName;
	}
	
	public int getPersonId() { //set-get metotları var.
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
}