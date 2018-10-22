package main.java;

public class Skill extends Attribute {
	
	String title;		// variable title denotes which skill the object contains
	int mod;			// the modifier for the skill, based off of the corresponding ability score and proficiency
	boolean profcy;		// the boolean denoting whether the PC has proficiency in this skill
	
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
	
	public void setMod(int i) {	// setMod method will be called whenever corresponding ability score is set or proficiency is gained/lost
		mod = i;
		if (profcy) {
			mod += 2;			// we add the proficiency bonus if the PC has proficiency in this saving throw
		}
	}
	
	public boolean getProfcy() {
		return profcy;
	}
	
	public void setProfcy(boolean b) {
		profcy = b;
		setMod(getMod());		// modifier must be re-evaluated when proficiency is gained/lost
	}
}