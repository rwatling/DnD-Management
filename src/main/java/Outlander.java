package main.java;

import java.util.ArrayList;

public class Outlander extends Background {
	public Outlander() {
		setTitle("Outlander");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Athletics");
		skillProfs.add("Survival");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(1);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Musical Instrument");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Staff");
		equipment.add("Hunting Trap");
		equipment.add("Trophy From an Animal You Killed");
		equipment.add("Set of Traveler's Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		setEquip(equipment);

		setFeature("Wanderer");
	}
}
