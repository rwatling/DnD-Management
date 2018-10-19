package main.java;

public class SavingThrow extends Attribute {
	
	String title;
	int mod;
	boolean profcy = false;
	
	public void SavingThrow() {
		setType("SavingThrow");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String t) {
		title = t;
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