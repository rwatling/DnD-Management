package main.java;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.util.Pair;
import main.java.*;

public class PC {
	String name;
	String align;
	String gender;
	Race pcRace = null;
	GameClass pcClass = null;
	Background pcBackground = null;
	int hitPoints = 0;
	
	//Ability scores -----------------------------------
	AbilityScore strength = new AbilityScore("STR");
	AbilityScore dexterity = new AbilityScore("DEX");
	AbilityScore constitution = new AbilityScore("CON");
	AbilityScore intelligence = new AbilityScore("INT");
	AbilityScore wisdom = new AbilityScore("WIS");
	AbilityScore charisma = new AbilityScore("CHA");

	//Skills--------------------------------------------
	//Proficiency bonus is applied in skill class
	Skill acrobatics = new  Skill("Acrobatics", dexterity);
	Skill animalHandling = new Skill("Animal Handling", wisdom);
	Skill arcana = new Skill("Arcana", intelligence);
	Skill athletics = new Skill("Athletics", strength);
	Skill deception = new Skill("Deception", charisma);
	Skill history = new Skill("History", intelligence);
	Skill insight = new Skill("Insight", wisdom);
	Skill intimidation = new Skill("Intimidation", charisma);
	Skill investigation = new Skill("Investigation", intelligence);
	Skill medicine = new Skill("Medicine", wisdom);
	Skill nature = new Skill("Nature", intelligence);
	Skill perception = new Skill("Perception", wisdom);
	Skill performance = new Skill("Performance", charisma);
	Skill persuasion = new Skill("Persuasion", charisma);
	Skill religon = new Skill("Religon", intelligence);
	Skill sleightOfHand = new Skill("Sleight of Hand", dexterity);
	Skill stealth = new Skill("Stealth", dexterity);
	Skill survival = new Skill("Survivial", wisdom);
	//---------------------------------------------------------------
	
	String[] allRaces = new String [] {"Hill Dwarf", "Mountain Dwarf", "High Elf", "Wood Elf", "Dark Elf", "Lightfoot Halfling", "Stout Halfling", "Human", "Dragonborn", "Gnome", "Half-Elf", "Half-Orc", "Tiefling"};
	String[] allClasses = new String[] {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
	String[] allBackgrounds = new String[] {"Acolyte", "Charlatan", "Criminal", "Entertainer", "Folk Hero", "Guild Artisan", "Hermit", "Noble", "Sage", "Sailor", "Soldier", "Urchin"};
	ArrayList<String> languages = new ArrayList<String>();
	ArrayList<String> weaponArmorProfs = new ArrayList<String>();
	
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
	
	public void setAbilityScores(int str, int dex, int con, int intel, int wis, int cha) {
		strength.setScore(str);
		dexterity.setScore(dex);
		constitution.setScore(con);
		intelligence.setScore(intel);
		wisdom.setScore(wis);
		charisma.setScore(cha);
		
		acrobatics.updateAbilityScore(dexterity);
		animalHandling.updateAbilityScore(wisdom);
		arcana.updateAbilityScore(intelligence);
		athletics.updateAbilityScore(strength);
		deception.updateAbilityScore(charisma);
		history.updateAbilityScore(intelligence);
		insight.updateAbilityScore(wisdom);
		intimidation.updateAbilityScore(charisma);
		investigation.updateAbilityScore(intelligence);
		medicine.updateAbilityScore(wisdom);
		nature.updateAbilityScore(intelligence);
		perception.updateAbilityScore(wisdom);
		performance.updateAbilityScore(charisma);
		persuasion.updateAbilityScore(charisma);
		religon.updateAbilityScore(intelligence);
		sleightOfHand.updateAbilityScore(dexterity);
		stealth.updateAbilityScore(dexterity);
		survival.updateAbilityScore(wisdom);
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
			case "Dragonborn":
				pcRace = new Dragonborn();
				break;
			case "Forest Gnome":
				pcRace = new ForestGnome();
				break;
			case "Rock Gnome":
				pcRace = new RockGnome();
				break;
			case "Half-Elf":
				pcRace = new HalfElf();
				break;
			case "Half-Orc":
				pcRace = new HalfOrc();
				break;
			case "Tiefling":
				pcRace = new Tiefling();
				break;
		}
		
		if (pcRace != null) {
			//Attributes increased because of subrace
			ArrayList<Pair<String, Integer>> incAttributes = pcRace.getIncAttributes();
			for (Pair<String, Integer> p : incAttributes) {
				if (p.getKey().equals("STR"))
					strength.setScore(p.getValue() + strength.getScore());
				else if (p.getKey().equals("DEX"))
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
			
			//Get languages from subrace
			languages.addAll(pcRace.getLanguages());
			
			//Get proficiencies from subrace
			weaponArmorProfs.addAll(pcRace.getWeaponArmorProficiencies());
		}
	}
	
	public void setClass(String gameClass) {
		switch (gameClass) {
		case "Barbarian":
			pcClass = new Barbarian();
			break;
		case "Bard":
			pcClass = new Bard();
			break;
		case "Cleric":
			pcClass = new Cleric();
			break;
		case "Druid":
			pcClass = new Druid();
			break;
		case "Fighter":
			pcClass = new Fighter();
			break;
		case "Monk":
			pcClass = new Monk();
			break;
		case "Paladin":
			pcClass = new Paladin();
			break;
		case "Ranger":
			pcClass = new Ranger();
			break;
		case "Rogue":
			pcClass = new Rogue();
			break;
		case "Sorcerer":
			pcClass = new Sorcerer();
			break;
		case "Warlock":
			pcClass = new Warlock();
			break;
		case "Wizard":
			pcClass = new Wizard();
			break;
		}
		
		if (pcClass != null) {
			//Attributes increased because of subclass
			ArrayList<Pair<String, Integer>> incAttributes = pcClass.getIncAttributes();
			for (Pair<String, Integer> p : incAttributes) {
				if (p.getKey().equals("STR"))
					strength.setScore(p.getValue() + strength.getScore());
				else if (p.getKey().equals("DEX"))
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
			
			//Get proficiencies from subclass
			weaponArmorProfs.addAll(pcClass.getWeaponArmorProficiencies());
		}
	}
	
	public void setBackground(String background) {
		switch (background) {
		case "Acolyte":
			pcBackground = new Acolyte();
			break;
		case "Charlatan":
			pcBackground = new Charlatan();
			break;
		case "Criminal":
			pcBackground = new Criminal();
			break;
		case "Entertainer":
			pcBackground = new Entertainer();
			break;
		case "Folk Hero":
			pcBackground = new FolkHero();
			break;
		case "Guild Artisan":
			pcBackground = new GuildArtisan();
			break;
		case "Hermit":
			pcBackground = new Hermit();
			break;
		case "Noble":
			pcBackground = new Noble();
			break;
		case "Outlander":
			pcBackground = new Outlander();
			break;
		case "Sage":
			pcBackground = new Sage();
			break;
		case "Sailor":
			pcBackground = new Sailor();
			break;
		case "Soldier":
			pcBackground = new Soldier();
			break;
		case "Urchin":
			pcBackground = new Urchin();
			break;
		}
	}
	
	public String getRaceTitle() {
		return pcRace.getTitle();
	}
	
	public String[] getAllRaces() {
		return allRaces;
	}
	
	public String getClassTitle() {
		return pcClass.getTitle();
	}
	
	public String[] getAllClasses() {
		return allClasses;
	}
	
	public String getBackgroundTitle() {
		return pcBackground.getTitle();
	}
	
	public String[] getAllBackgrounds() {
		return allBackgrounds;
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
	
	public Skill getAcrobatics() {
		return acrobatics;
	}
	
	public Skill getAnimalHandling() {
		return animalHandling;
	}
	
	public Skill getArcana() {
		return arcana;
	}
	
	public Skill getAthletics() {
		return athletics;
	}
	
	public Skill getDeception() {
		return deception;
	}
	
	public Skill getHistory() {
		return history;
	}
	
	public Skill getInsight() {
		return insight;
	}
	
	public Skill getIntimidation() {
		return intimidation;
	}
	
	public Skill getInvestigation() {
		return investigation;
	}
	
	public Skill getMedicine() {
		return medicine;
	}
	
	public Skill getNature() {
		return nature;
	}
	
	public Skill getPerception() {
		return perception;
	}
	
	public Skill getPerformance() {
		return performance;
	}
	
	public Skill getPersuasion() {
		return persuasion;
	}
	
	public Skill getReligon() {
		return religon;
	}
	
	public Skill getStealth() {
		return stealth;
	}
	
	public Skill getSleightOfHand() {
		return sleightOfHand;
	}
	
	public Skill getSurvival() {
		return survival;
	}
	
	public ArrayList<String> getLanguages() {
		return languages;
	}
	
	public ArrayList<String> getProficiencies() {
		return weaponArmorProfs;
	}
}