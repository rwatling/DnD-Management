package main.java;

public class Attribute {
	
	String type;	// variable type used to denote if the attribute is an ability score, saving throw, class, etc.
	
	public String getType () {
		return type;
	}
	
	public void setType(String s) {
		type = s;
	}
}