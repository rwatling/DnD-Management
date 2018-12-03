package main.java;

import java.util.ArrayList;

public class GuildArtisan extends Background {
	public GuildArtisan() {
		setTitle("Guild Artisan");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Insight");
		skillProfs.add("Persuasion");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(0);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Artisan's Tools");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Set of Artisan's Tools (One of Your Choice)");
		equipment.add("Letter of Introduction From Your Guild");
		equipment.add("Set of Traveler's Clothes");
		equipment.add("Belt Pouch Containing 15 gp");
		
		setEquip(equipment);

		setFeature("Guild Membership");
	}
}
