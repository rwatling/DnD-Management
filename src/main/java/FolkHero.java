package main.java;

import java.util.ArrayList;

//public class FolkHero extends Background {
	public FolkHero() {
		setTitle("Folk Hero");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Animal Handling");
		skillProfs.add("Survival");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(0);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Artisan's Tools");
		toolProfs.add("Vehicles (Land)");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Set of Artisan's Tools (One of Your Choice)");
		equipment.add("Shovel");
		equipment.add("Iron Pot");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		setEquip(equipment);

		setFeature("Rustic Hospitality");
	}
}
