//package main.java;

public class Skill extends Attribute {
	
	String title;		// variable title denotes which skill the object contains
	int mod;			// the modifier for the skill, based off of the corresponding ability score and proficiency
	boolean profcy;		// the boolean denoting whether the PC has proficiency in this skill
	AbilityScore reliesOn;	//ability score a skill relies on	
	
	public Skill() {
		setType("Skill");
	}
	
	public Skill(String s, AbilityScore reliesOn) {
		setType("Skill");
		setTitle(s);
		this.reliesOn = reliesOn;
		setMod(this.reliesOn.getMod());
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
	
	private void setMod(int i) {	// setMod method will be called whenever corresponding ability score is set or proficiency is gained/lost
		mod = i;
//		if (profcy) {
//			mod += 2;			// we add the proficiency bonus if the PC has proficiency in this skill
//		}
	}
	
	public boolean getProfcy() {
		return profcy;
	}
	
	public void setProfcy(boolean b) {
		profcy = b;
		setMod(getMod() + 2);		// modifier must be re-evaluated when proficiency is gained/lost
	}
	
	public void updateAbilityScore(AbilityScore updated) {
		this.reliesOn = updated;
		setMod(reliesOn.getMod());
	}
	
	public AbilityScore getAbilityScore() {
		return reliesOn;
	}
}