//package main.java;

import javafx.util.Pair;

public class Ranger extends GameClass {
	public Ranger() {
		setTitle("Ranger");
		
		Pair<String, Integer> increasedSTR = new Pair<String,Integer>("STR", 2);
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 2);
		increasedAttributes.add(increasedSTR);
		increasedAttributes.add(increasedDEX);
		
		proficienciesWeaponArmor.add("Simple Weapons");
		proficienciesWeaponArmor.add("Martial Weapons");
		proficienciesWeaponArmor.add("Medium Armor");
		proficienciesWeaponArmor.add("Light Armor");
	}
}
