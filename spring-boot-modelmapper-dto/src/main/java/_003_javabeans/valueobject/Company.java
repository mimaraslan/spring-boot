package _003_javabeans.valueobject;

public class Company {	
	
	private int companyId; //Sınıf değişkenleri var.
	private String name;
	
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}