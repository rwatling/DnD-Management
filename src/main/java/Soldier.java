package main.java;

import java.util.ArrayList;

public class Soldier extends Background {
	public Soldier() {
		setTitle("Soldier");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Athletics");
		skillProfs.add("Intimidation");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(0);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Gaming Set");
		toolProfs.add("Vehicles (Land)");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Insignia of Rank");
		equipment.add("Trophy Taken From a Fallen Enemy");
		equipment.add("Set of Bone Dice or Deck of Cards");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		setEquip(equipment);

		setFeature("Military Rank");
	}
}
