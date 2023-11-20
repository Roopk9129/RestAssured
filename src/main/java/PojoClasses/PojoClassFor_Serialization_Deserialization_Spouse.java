package PojoClasses;

public class PojoClassFor_Serialization_Deserialization_Spouse {
	String Sname;
	String age;
	int[] phno;
	
	public PojoClassFor_Serialization_Deserialization_Spouse(String sname, String age, int[] phno) {
		super();
		Sname = sname;
		this.age = age;
		this.phno = phno;
		
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int[] getPhno() {
		return phno;
	}
	public void setPhno(int[] phno) {
		this.phno = phno;
	}
	

}
