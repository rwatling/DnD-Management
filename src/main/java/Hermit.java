//package main.java;

import java.util.ArrayList;

public class Hermit extends Background {
	public Hermit() {
		setTitle("Hermit");
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Medicine");
		skillProfs.add("Religion");
		
		setSkillProfs(skillProfs);
		
		setNumLangs(1);
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Herbalism Kit");
		
		setToolProfs(toolProfs);
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Scroll Case Stuffed Full of Notes From Your Studies or Prayers");
		equipment.add("Winter Blanket");
		equipment.add("Set of Common Clothes");
		equipment.add("Herbalism Kit");
		equipment.add("5 gp");
		
		setEquip(equipment);

		setFeature("Discovery");
	}
}
