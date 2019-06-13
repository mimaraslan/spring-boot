package com.mimaraslan.pojo;

// Bu sınıf bir POJO'dur. 
public class Person {
	private int personId; //Sadece sınıf değişkenleri var.
	private String personName;
	
	public Person() { // Constructor (hazırlayıcı, yapıcı) parametresiz metodu var.
	}

	public Person(int personId, String personName) { // Constructor parametreli metodu var.
		super();
		this.personId = personId;
		this.personName = personName;
	}
	
}