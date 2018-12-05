package main.java;

import java.util.ArrayList;

public class Urchin extends Background {
	public Urchin() {
		setTitle("Urchin");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Sleight of Hand");
		skillProfs.add("Stealth");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(0);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Disguise Kit");
		toolProfs.add("Thieves' Tools");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Small Knife");
		equipment.add("Map of the City You Grew Up In");
		equipment.add("Pet Mouse");
		equipment.add("Token to Remember Your Parents By");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		setEquip(equipment);

		setFeature("City Secrets");
	}
}
