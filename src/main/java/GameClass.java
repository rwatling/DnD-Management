package main.java;

import java.util.ArrayList;

<<<<<<< Updated upstream
import javafx.util.Pair;

public class GameClass extends Attribute {
	String title;	// variable title denotes which class this object contains
	ArrayList<Pair<String, Integer>> increasedAttributes = new ArrayList<Pair<String, Integer>>(); //increased attributes to be implemented in subclass class
	ArrayList<String> languages = new ArrayList<String>();	//languages that the subclass is fluent in
	ArrayList<String> proficienciesWeaponArmor = new ArrayList<String>();	//proficiencies in weapon and armor
=======
public class GameClass extends Attribute {
	
	String title;					// variable title denotes which class this object contains
	String hitDice;					// denotes which die this class uses for its hit dice
	int startHP;					// denotes the base hp the class gets, this number will be added to the character's constitution modifier to get their starting hp
	ArrayList<String> armorProfs;	// contains the armor proficiencies provided by the class
	ArrayList<String> weaponProfs;	// contains the weapon proficiencies provided by the class
	ArrayList<String> toolProfs;	// contains the tool proficiencies provided b the class
	ArrayList<String> saveThrows;	// contains the saving throw proficiencies provided by the class
	ArrayList<String> skillList;	// contains the list of skills the class may choose proficiencies from
	ArrayList<String> startEquip;	// contains the text from the Player's Handbook detailing what starting equipment the class has
>>>>>>> Stashed changes
	
	public GameClass() {
		setType("Class");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
<<<<<<< Updated upstream
	public ArrayList<Pair<String, Integer>> getIncAttributes() {
		return increasedAttributes;
	}
	
	public ArrayList<String> getLanguages() {
		return languages;
	}
	
	public ArrayList<String> getWeaponArmorProficiencies() {
		return proficienciesWeaponArmor;
=======
	public String getHitDice() {
		return hitDice;
	}
	
	public void setHitDice(String s) {
		hitDice = s;
	}
	
	public int getStartHP() {
		return startHP;
	}
	
	public void setStartHP(int i) {
		startHP = i;
	}
	
	public ArrayList<String> getArmorProfs() {
		return armorProfs;
	}
	
	public void setArmorProfs(ArrayList<String> arr) {
		armorProfs = (ArrayList) arr.clone();
	}
	
	public ArrayList<String> getWeaponProfs() {
		return weaponProfs;
	}
	
	public void setWeaponProfs(ArrayList<String> arr) {
		weaponProfs = (ArrayList) arr.clone();
	}
	
	public ArrayList<String> getToolProfs() {
		return toolProfs;
	}
	
	public void setToolProfs(ArrayList<String> arr) {
		toolProfs = (ArrayList) arr.clone();
	}
	
	public ArrayList<String> getSaveThrows() {
		return saveThrows;
	}
	
	public void setSaveThrows(ArrayList<String> arr) {
		saveThrows = (ArrayList) arr.clone();
	}
	
	public ArrayList<String> getSkillList() {
		return skillList;
	}
	
	public void setSkillList(ArrayList<String> arr) {
		skillList = (ArrayList) arr.clone();
	}
	
	public ArrayList<String> getStartEquip() {
		return startEquip;
	}
	
	public void setStartEquip(ArrayList<String> arr) {
		startEquip = (ArrayList) arr.clone();
>>>>>>> Stashed changes
	}
}