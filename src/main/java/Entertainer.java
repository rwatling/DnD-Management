package main.java;

import java.util.ArrayList;

public class Entertainer extends Background {
	public Entertainer() {
		setTitle("Entertainer");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Acrobatics");
		skillProfs.add("Performance");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(0);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Disguise Kit");
		toolProfs.add("One Type of Musical Instrument");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("One Musical Instrument");
		equipment.add("The Favor of an Admirer");
		equipment.add("Belt Pouch Containing 15 gp");
		
		setEquip(equipment);

		setFeature("By Popular Demand");
	}
}
