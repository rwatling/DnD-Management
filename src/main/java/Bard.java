//package main.java;

import javafx.util.Pair;

public class Bard extends GameClass {
	public Bard() {
		setTitle("Bard");
		
		Pair<String, Integer> increasedDEX = new Pair<String,Integer>("DEX", 2);
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 2);
		increasedAttributes.add(increasedDEX);
		increasedAttributes.add(increasedCHA);
		
		proficienciesWeaponArmor.add("Simple Weapons");
		proficienciesWeaponArmor.add("Hand Crossbows");
		proficienciesWeaponArmor.add("Longswords");
		proficienciesWeaponArmor.add("Rapiers");
		proficienciesWeaponArmor.add("Shortswords");
		proficienciesWeaponArmor.add("Light Armor");
	}
}
