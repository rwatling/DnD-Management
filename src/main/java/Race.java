package main.java;

public class Race extends Attribute {
	
	String title;	// variable title denotes which race this object contains
	
	public Race() {
		setType("Race");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
}