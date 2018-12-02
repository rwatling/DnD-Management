//package main.java;

import javafx.util.Pair;

public class Rogue extends GameClass {
	public Rogue() {
		setTitle("Rogue");
		
		Pair<String, Integer> increasedDEX = new Pair<String,Integer>("DEX", 2);
		Pair<String, Integer> increasedINT = new Pair<String, Integer>("INT", 2);
		increasedAttributes.add(increasedDEX);
		increasedAttributes.add(increasedINT);
		
		proficienciesWeaponArmor.add("Simple Weapons");
		proficienciesWeaponArmor.add("Hand Crossbows");
		proficienciesWeaponArmor.add("Longswords");
		proficienciesWeaponArmor.add("Rapiers");
		proficienciesWeaponArmor.add("Shortswords");
		proficienciesWeaponArmor.add("Light Armor");
	}
}
