package main.java;

public class Background extends Attribute {
	
	String title;					// variable title denotes which background this object contains
	ArrayList<String> skillProfs;	// contains the skill proficiencies gratned by the background
	int numLangs;					// denotes the number of languages granted by background
	ArrayList<String> toolProfs;	// contains the tool proficiencies granted by the background
	ArrayList<String> equip;		// contains the equipment granted by the background
	String feature;					// denotes the feature of the background
	
	public Background () {
		setType("Background");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public ArrayList<String> getSkillProfs() {
		
	}
}