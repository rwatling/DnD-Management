//package main.java;

public class SavingThrow extends Attribute {
	
	String title;				// variable title denotes which saving throw the object contains
	int mod;					// the modifier for the saving throw, based off of the corresponding ability score and proficiency
	boolean profcy = false;		// the boolean denoting whether the PC has proficiency in this saving throw
	AbilityScore reliesOn;
	
	public SavingThrow() {
		setTitle("Default");
		setType("SavingThrow");
	}
	
	public SavingThrow(String title, AbilityScore relies) {
		setType("SavingThrow");
		setTitle(title);
		this.reliesOn = relies;
		setMod(reliesOn.getMod());
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
	
	public void setMod(int i) {	// setMod method will be called whenever corresponding ability score is set or proficiency is gained/lost
		mod = i;
//		if (profcy) {
//			mod += 2;			// we add the proficiency bonus if the PC has proficiency in this saving throw
//		}
	}
	
	public boolean getProfcy() {
		return profcy;
	}
	
	public void setProfcy(boolean b) {
		System.out.println("Proficiency " + title + " has been changed to " + b);
		profcy = b;
		setMod(getMod() + 2);		// modifier must be re-evaluated when proficiency is gained/lost
	}
}