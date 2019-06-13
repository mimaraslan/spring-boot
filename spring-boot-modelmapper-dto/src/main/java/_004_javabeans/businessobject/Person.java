package _004_javabeans.businessobject;
import java.io.Serializable;

//Bu sınıf bir BusinessObject'tir.  
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
	
	public double getCalculateTotal() { // Sıradan metotları var.
		return 9600.00;
	}
}
