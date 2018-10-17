package main.java;

public class SavingThrow extends Attribute {
	
	public void SavingThrow() {
		setType("SavingThrow");
	}
	
	String title;
	public void setTitle(String t) {
		title = t;
	}
	
	public String getTitle() {
		return title;
	}
	
	int mod;
	public void setMod(int i) {
		mod = i;
	}
	
	public int getMod() {
		return mod;
	}
	
	boolean profcy = false;
	public void setProfcy(boolean b) {
		profcy = b;
	}
}