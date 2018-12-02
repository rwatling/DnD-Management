//package main.java;

import java.util.ArrayList;

import javafx.util.Pair;

public class GameClass extends Attribute {
	String title;	// variable title denotes which class this object contains
	ArrayList<Pair<String, Integer>> increasedAttributes = new ArrayList<Pair<String, Integer>>(); //increased attributes to be implemented in subclass class
	ArrayList<String> languages = new ArrayList<String>();	//languages that the subclass is fluent in
	ArrayList<String> proficienciesWeaponArmor = new ArrayList<String>();	//proficiencies in weapon and armor
	
	public GameClass() {
		setType("Class");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public ArrayList<Pair<String, Integer>> getIncAttributes() {
		return increasedAttributes;
	}
	
	public ArrayList<String> getLanguages() {
		return languages;
	}
	
	public ArrayList<String> getWeaponArmorProficiencies() {
		return proficienciesWeaponArmor;
	}
}