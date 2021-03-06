//package main.java;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.util.Pair;
//import main.java.*;

public class PC {
	private String name;
	private String alignment;
	private String gender;
	private String hair;
	private String size;
	int age;
	public Race pcRace = null;
	public GameClass pcClass = null;
	public Background pcBackground = null;
	int hitPoints = 0;
	private Inventory pcInventory = new Inventory();
	
	//Ability scores -----------------------------------
	AbilityScore strength = new AbilityScore("STR");
	AbilityScore dexterity = new AbilityScore("DEX");
	AbilityScore constitution = new AbilityScore("CON");
	AbilityScore intelligence = new AbilityScore("INT");
	AbilityScore wisdom = new AbilityScore("WIS");
	AbilityScore charisma = new AbilityScore("CHA");

	//Saving Throws ------------------------------------
	SavingThrow strengthSave = new SavingThrow("STR", strength);
	SavingThrow dexteritySave = new SavingThrow("DEX", dexterity);
	SavingThrow constitutionSave = new SavingThrow("CON", constitution);
	SavingThrow intelligenceSave = new SavingThrow("INT", intelligence);
	SavingThrow wisdomSave = new SavingThrow("WIS", wisdom);
	SavingThrow charismaSave = new SavingThrow("CHA", charisma);
	
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
	String[] allSkills = new String[] { "Acrobatics", "Animal Handling", "Arcana", "Athletics", "Deception", "History", "Insight", "Intimidation", "Investigation", "Medicine", "Nature", "Perception", "Persuasion", "Religon",
			"Sleight of Hand", "Stealth", "Survival"};
	String[] allSavingThrows = new String[] { "Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma" };
	ArrayList<String> languages = new ArrayList<String>();
	ArrayList<String> weaponArmorProfs = new ArrayList<String>();
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setHair(String hair) {
		this.hair = hair;
	}
	
	public String getHair() {
		return hair;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setSize(String s) {
		size = s;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setAge(String s) {
		age = Integer.parseInt(s);
	}
	
	public int getAge() {
		return age;
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
	
	//Background
	public String[] getAllBackgrounds() {
		return allBackgrounds;
	}
	
	//Alignment
	public String getAlignment() {
		return alignment;
	}
	
	public void setAlignment(String a) {
		alignment = a;
		System.out.println("Alignment is " + alignment);
	}
	
	public void setBackground(String background) {
		switch (background) {
		case "Acolyte":
			pcBackground = new Acolyte();
			pcBackground.setTitle("Acolyte");
			break;
		case "Charlatan":
			pcBackground = new Charlatan();
			pcBackground.setTitle("Charlatan");
			break;
		case "Criminal":
			pcBackground = new Criminal();
			pcBackground.setTitle("Criminal");
			break;
		case "Entertainer":
			pcBackground = new Entertainer();
			pcBackground.setTitle("Entertainer");
			break;
		case "Folk Hero":
			pcBackground = new FolkHero();
			pcBackground.setTitle("Folk Hero");
			break;
		case "Guild Artisan":
			pcBackground = new GuildArtisan();
			pcBackground.setTitle("Guild Artisan");
			break;
		case "Hermit":
			pcBackground = new Hermit();
			pcBackground.setTitle("Hermit");
			break;
		case "Noble":
			pcBackground = new Noble();
			pcBackground.setTitle("Noble");
			break;
		case "Outlander":
			pcBackground = new Outlander();
			pcBackground.setTitle("Outlander");
			break;
		case "Sage":
			pcBackground = new Sage();
			pcBackground.setTitle("Sage");
			break;
		case "Sailor":
			pcBackground = new Sailor();
			pcBackground.setTitle("Sailor");
			break;
		case "Soldier":
			pcBackground = new Soldier();
			pcBackground.setTitle("Soldier");
			break;
		case "Urchin":
			pcBackground = new Urchin();
			pcBackground.setTitle("Urchin");
			break;
		}
	}
	
	//Get Race information
	public String getRaceTitle() {
		return pcRace.getTitle();
	}
	
	public String[] getAllRaces() {
		return allRaces;
	}
	
	//Class
	public String getClassTitle() {
		return pcClass.getTitle();
	}
	
	public String[] getAllClasses() {
		return allClasses;
	}
	
	public String getBackgroundTitle() {
		return pcBackground.getTitle();
	}
	
	
	//Ability Scores
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
	
	//SavingThrow
	public void setSavingThrowProficiency(String s, boolean b) {
		switch (s) {
		case "Strength":
			strengthSave.setProfcy(b);
			break;
		case "Dexterity":
			dexteritySave.setProfcy(b);
			break;
		case "Constitution":
			constitutionSave.setProfcy(b);
			break;
		case "Intelligence":
			intelligenceSave.setProfcy(b);
			break;
		case "Wisdom":
			wisdomSave.setProfcy(b);
			break;
		case "Charisma":
			charismaSave.setProfcy(b);
			break;
		}
	}
	
	public String[] getAllSavingThrows() {
		return allSavingThrows;
	}
	
	//Skills
	public String[] getAllSkills() {
		return allSkills;
	}
	
	public void setSkillProficiency(String s, boolean b) {
		switch (s) {
		case "Acrobatics":
			acrobatics.setProfcy(b);
			break;
		case "Animal Handling":
			animalHandling.setProfcy(b);
			break;
		case "Arcana":
			arcana.setProfcy(b);
			break;
		case "Athletics":
			athletics.setProfcy(b);
			break;
		case "Deception":
			deception.setProfcy(b);
			break;
		case "History":
			history.setProfcy(b);
			break;
		case "Insight":
			insight.setProfcy(b);
			break;
		case "Intimidation":
			intimidation.setProfcy(b);
			break;
		case "Investigation":
			investigation.setProfcy(b);
			break;
		case "Medicine":
			medicine.setProfcy(b);
			break;
		case "Nature":
			nature.setProfcy(b);
			break;
		case "Perception":
			perception.setProfcy(b);
			break;
		case "Persuasion":
			persuasion.setProfcy(b);
			break;
		case "Religon":
			religon.setProfcy(b);
			break;
		case "Sleight of Hand":
			sleightOfHand.setProfcy(b);
			break;
		case "Stealth":
			stealth.setProfcy(b);
			break;
		case "Survival":
			survival.setProfcy(b);
			break;
		}
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
	
	//Languages
	public ArrayList<String> getLanguages() {
		return languages;
	}
	
	public void addLanguage(String language) {
		languages.add(language);
	}
	
	public void removeLanguages(ArrayList<String> langs) {
		languages.removeAll(langs);
	}
	
	//Proficiencies
	public ArrayList<String> getProficiencies() {
		return weaponArmorProfs;
	}
	
	public void addWeaponArmorProfs(String s) {
		weaponArmorProfs.add(s);
	}
	
	public void removeProfs(ArrayList<String> profs) {
		weaponArmorProfs.removeAll(profs);
	}
}