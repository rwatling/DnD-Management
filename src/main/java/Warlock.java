package main.java;

import javafx.util.Pair;

public class Warlock extends GameClass {
	public Warlock() {
		setTitle("Warlock");
		
		Pair<String, Integer> increasedWIS = new Pair<String,Integer>("WIS", 2);
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 2);
		increasedAttributes.add(increasedWIS);
		increasedAttributes.add(increasedCHA);
		
		proficienciesWeaponArmor.add("Simple Weapons");
		proficienciesWeaponArmor.add("Light Armor");
	}
}
