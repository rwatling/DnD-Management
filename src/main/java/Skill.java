package main.java;

public class Skill extends Attribute {
	
	String title;
	int mod;
	boolean profcy;
	
	public Skill() {
		setType("Skill");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public int getMod() {
		return mod;
	}
	
	public void setMod(int i) {
		mod = i;
		if (profcy) {
			mod += 2;
		}
	}
	
	public boolean getProfcy() {
		return profcy;
	}
	
	public void setProfcy(boolean b) {
		profcy = b;
		setMod(getMod());
	}
}