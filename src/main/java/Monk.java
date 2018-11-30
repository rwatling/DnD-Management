package main.java;

import javafx.util.Pair;

public class Monk extends GameClass {
	public Monk() {
		setTitle("Monk");
		
		Pair<String, Integer> increasedSTR = new Pair<String,Integer>("STR", 2);
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 2);
		increasedAttributes.add(increasedSTR);
		increasedAttributes.add(increasedDEX);
		
		proficienciesWeaponArmor.add("Simple Weapons");
		proficienciesWeaponArmor.add("Shortswords");
	}
}
