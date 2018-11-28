package main.java;

import javafx.util.Pair;

public class Barbarian extends GameClass {
	public Barbarian() {
		setTitle("Barbarian");
		
		Pair<String, Integer> increasedCON = new Pair<String,Integer>("CON", 2);
		Pair<String, Integer> increasedSTR = new Pair<String, Integer>("STR", 2);
		increasedAttributes.add(increasedCON);
		increasedAttributes.add(increasedSTR);
		
		proficienciesWeaponArmor.add("Simple Weapons");
		proficienciesWeaponArmor.add("Martial Weapons");
		proficienciesWeaponArmor.add("Light Armor");
		proficienciesWeaponArmor.add("Medium Armor");
	}
}
