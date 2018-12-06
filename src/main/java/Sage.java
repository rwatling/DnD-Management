//package main.java;

import java.util.ArrayList;

public class Sage extends Background {
	public Sage() {
		setTitle("Sage");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Arcana");
		skillProfs.add("History");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(2);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Bottle of Black Ink");
		equipment.add("Quill");
		equipment.add("Small Knife");
		equipment.add("Letter From a Dead Colleague Posing a Question You Have Not Yet Been Able To Answer");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		setEquip(equipment);

		setFeature("Researcher");
	}
}
