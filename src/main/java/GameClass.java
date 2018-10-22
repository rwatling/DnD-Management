package main.java;

public class GameClass extends Attribute {
	
	String title;	// variable title denotes which class this object contains
	
	public GameClass() {
		setType("Class");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
}