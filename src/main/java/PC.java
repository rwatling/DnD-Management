package main.java;

import main.java.*;

public class PC {
	GameClass pcClass = new GameClass();
	AbilityScore pcAbilityScore = new AbilityScore();
	Inventory pcInventory = new Inventory();
	SavingThrow pcSaveThrow = new SavingThrow();
	Skill pcSkill = new Skill();
	String name;
	String align;
	String gender;
	
	public String getName() {
		return name;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public String getAlignment() {
		return align;
	}
	
	public void setAlignment(String s) {
		align = s;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String s) {
		gender = s;
	}
}