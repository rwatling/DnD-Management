package main.java;

import java.util.ArrayList;

public class Noble extends Background {
	public Noble() {
		setTitle("Noble");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("History");
		skillProfs.add("Persuasion");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(1);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Gaming Set");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Set of Fine Clothes");
		equipment.add("Signet Ring");
		equipment.add("Scroll of Pedigree");
		equipment.add("Purse Containing 25 gp");
		
		setEquip(equipment);

		setFeature("Position of Privilege");
	}
}
