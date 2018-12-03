package main.java;

import java.util.ArrayList;

public class Criminal extends Background {
	public Criminal() {
		setTitle("Criminal");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Deception");
		skillProfs.add("Stealth");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(0);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Gaming Set");
		toolProfs.add("Thieve's Tools");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Crowbar");
		equipment.add("Set of Dark Common Clothes Including a Hood");
		equipment.add("Belt Pouch Containing 15 gp");
		
		setEquip(equipment);

		setFeature("Criminal Contact");
	}
}
