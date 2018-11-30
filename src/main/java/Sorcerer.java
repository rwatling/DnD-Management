package main.java;

import javafx.util.Pair;

public class Sorcerer extends GameClass {
	public Sorcerer() {
		setTitle("Sorcerer");
		
		Pair<String, Integer> increasedCON = new Pair<String,Integer>("CON", 2);
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 2);
		increasedAttributes.add(increasedCON);
		increasedAttributes.add(increasedCHA);
		
		proficienciesWeaponArmor.add("Darts");
		proficienciesWeaponArmor.add("Daggers");
		proficienciesWeaponArmor.add("Slings");
		proficienciesWeaponArmor.add("Quarterstaffs");
		proficienciesWeaponArmor.add("Light Crossbows");	
	}
}
