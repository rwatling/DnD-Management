//package main.java;

import java.util.ArrayList;

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
		return skillProfs;
	}
	
	public void setSkillProfs(ArrayList<String> arr) {
		skillProfs = (ArrayList) arr.clone();
	}
	
	public int getNumLangs() {
		return numLangs;
	}
	
	public void setNumLangs(int i) {
		numLangs = i;
	}
	
	public ArrayList<String> getToolProfs() {
		return toolProfs;
	}
	
	public void setToolProfs(ArrayList<String> arr) {
		toolProfs = (ArrayList) arr.clone();
	}
	
	public ArrayList<String> getEquip() {
		return equip;
	}
	
	public void setEquip(ArrayList<String> arr) {
		equip = (ArrayList) arr.clone();
	}
	
	public String getFeature() {
		return feature;
	}
	
	public void setFeature(String s) {
		feature = s;
	}
}