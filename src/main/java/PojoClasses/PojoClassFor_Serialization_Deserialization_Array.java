package PojoClasses;

public class PojoClassFor_Serialization_Deserialization_Array {
	String ename;
	String eid;
	int[] ph;

	public PojoClassFor_Serialization_Deserialization_Array(String ename, String eid, int[] ph) {
		this.ename = ename;
		this.eid = eid;
		this.ph = ph;
	}

	public PojoClassFor_Serialization_Deserialization_Array() {

	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public int[] getPh() {
		return ph;
	}

	public void setPh(int[] ph) {
		this.ph = ph;
	}

}
