package main.java;

public class SavingThrow extends Attribute {
	
	String title;
	int mod;
	boolean profcy = false;
	
	public void SavingThrow() {
		setType("SavingThrow");
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setMod(int i) {
		mod = i;
	}
	
	public int getMod() {
		return mod;
	}
	
	public boolean getProfcy() {
		return profcy;
	}
	
	public void setProfcy(boolean b) {
		profcy = b;
	}
}