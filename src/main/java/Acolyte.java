//package main.java;

import java.util.ArrayList;

public class Acolyte extends Background {
	public Acolyte() {
		setTitle("Acolyte");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Insight");
		skillProfs.add("Religion");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(2);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Holy Symbol");
		equipment.add("Prayer Book or Prayer Wheel");
		equipment.add("5 Sticks of Incense");
		equipment.add("Vestments");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 15 gp");
		
		setEquip(equipment);

		setFeature("Shelter of the Faithful");
	}
}
