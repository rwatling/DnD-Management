package main.java;

public class Skill extends Attribute {
	
	String title;
	
	public Skill() {
		setType("Skill");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
}