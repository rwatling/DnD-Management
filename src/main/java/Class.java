package main.java;

public class Class extends Attribute {
	
	String title;
	
	public Class() {
		setType("Class");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
}