package main.java;

public class GameClass extends Attribute {
	
	String title;
	
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