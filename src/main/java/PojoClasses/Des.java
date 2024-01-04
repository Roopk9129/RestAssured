package PojoClasses;

import java.util.List;

public class Des {
	private List<Object> color;
	private List<Object> value;
	public Des() {
		
	}
	public Des(List<Object> color, List<Object> value) {
		super();
		this.color = color;
		this.value = value;
	}
	public List<Object> getColor() {
		return color;
	}
	public void setColor(List<Object> color) {
		this.color = color;
	}
	public List<Object> getValue() {
		return value;
	}
	public void setValue(List<Object> value) {
		this.value = value;
	}
	
	

}
