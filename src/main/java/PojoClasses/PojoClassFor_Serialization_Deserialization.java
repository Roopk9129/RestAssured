package PojoClasses;

public class PojoClassFor_Serialization_Deserialization {
	private String ename;
	private long phoneno;
	private int age;
	public PojoClassFor_Serialization_Deserialization(String ename, long phoneno, int age) {
		this.ename = ename;
		this.phoneno = phoneno;
		this.age = age;
	}
	public PojoClassFor_Serialization_Deserialization() {
		
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
