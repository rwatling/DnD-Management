package main.java;

import java.util.ArrayList;
import javafx.util.Pair;
import main.java.*;

public class PC {
	String name;
	String align;
	String gender;
	Race pcRace = null;
	int hitPoints = 0;
	
	//Ability scores -----------------------------------
	AbilityScore strength = new AbilityScore("STR");
	AbilityScore dexterity = new AbilityScore("DEX");
	AbilityScore constitution = new AbilityScore("CON");
	AbilityScore intelligence = new AbilityScore("INT");
	AbilityScore wisdom = new AbilityScore("WIS");
	AbilityScore charisma = new AbilityScore("CHA");

	
	String[] allRaces = new String [] {"Hill Dwarf", "Mountain Dwarf", "High Elf", "Wood Elf", "Dark Elf", "Lightfoot Halfling", "Stout Halfling", "Human", "Dragonborn", "Gnome", "Half-Elf", "Half-Orc", "Tiefling"};
	ArrayList<AbilityScore> allScores = new ArrayList<AbilityScore>();
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setRace(String race) {
			switch (race) {
			case "Hill Dwarf":
				pcRace = new HillDwarf();
				break;
			case "Mountain Dwarf":
				pcRace = new MountainDwarf();
				break;
			case "High Elf":
				pcRace = new HighElf();
				break;
			case "Wood Elf":
				pcRace = new WoodElf();
				break;
			case "Dark Elf":
				pcRace = new DarkElf();
				break;
			case "Lightfoot Halfling":
				pcRace = new LightfootHalfling();
				break;
			case "Stout Halfling":
				pcRace = new StoutHalfling();
				break;
			case "Human":
				pcRace = new Human();
				break;
		}
		
		if (pcRace != null) {
			ArrayList<Pair<String, Integer>> incAttributes = pcRace.getIncAttributes();
			for (Pair<String, Integer> p : incAttributes) {
				if (p.getKey().equals("STR"))
					strength.setScore(p.getValue() + strength.getScore());
				else if (p.getKey() == "DEX")
					dexterity.setScore(p.getValue() + dexterity.getScore());
				else if (p.getKey().equals("CON"))
					constitution.setScore(p.getValue() + constitution.getScore());
				else if (p.getKey().equals("INT"))
					intelligence.setScore(p.getValue() + intelligence.getScore());
				else if (p.getKey().equals("WIS"))
					wisdom.setScore(p.getValue() + wisdom.getScore());
				else if (p.getKey().equals("CHA"))
					charisma.setScore(p.getValue() + charisma.getScore());
				else if(p.getKey().equals("HP"))
					hitPoints += p.getValue();				
			}
		}
	}
	
	public String getRaceTitle() {
		return pcRace.getTitle();
	}
	
	public String[] getAllRaces() {
		return allRaces;
	}
	
	public int getHP() {
		return hitPoints;
	}
	
	public int getSTRScore() {
		return strength.getScore();
	}
	
	public int getSTRMod() {
		return strength.getMod();
	}
	
	public int getDEXScore() {
		return dexterity.getScore();
	}
	
	public int getDEXMod() {
		return dexterity.getMod();
	}
	
	public int getCONScore() {
		return constitution.getScore();
	}
	
	public int getCONMod() {
		return constitution.getMod();
	}
	
	public int getINTScore() {
		return intelligence.getScore();
	}
	
	public int getINTMod() {
		return intelligence.getMod();
	}
	
	public int getWISScore() {
		return wisdom.getScore();
	}
	
	public int getWISMod() {
		return wisdom.getMod();
	}
	
	public int getCHAScore() {
		return charisma.getScore();
	}
	
	public int getCHAMod() {
		return charisma.getMod();
	}
}