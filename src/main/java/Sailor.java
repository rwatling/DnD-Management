package main.java;

import java.util.ArrayList;

public class Sailor extends Background {
	public Sailor() {
		setTitle("Sailor");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Athletics");
		skillProfs.add("Perception");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(0);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Navigator's Tools");
		toolProfs.add("Vehicles (Water)");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Belaying Pin (Club)");
		equipment.add("50 Feet of Silk Rope");
		equipment.add("Lucky Charm");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		setEquip(equipment);

		setFeature("Ship's Passage");
	}
}
