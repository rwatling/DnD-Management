package main.java;

import java.util.ArrayList;

public class Charlatan extends Background {
	public Charlatan() {
		setTitle("Charlatan");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Deception");
		skillProfs.add("Sleight of Hand");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(0);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Disguise Kit");
		toolProfs.add("Forgery Kit");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Set of Fine Clothes");
		equipment.add("Disguise Kit");
		equipment.add("Tools of the con of your choice");
		equipment.add("Belt Pouch Containing 15 gp");
		
		setEquip(equipment);

		setFeature("False Identity");
	}
}
