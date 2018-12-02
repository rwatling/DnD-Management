//package main.java;

import javafx.util.Pair;

public class Wizard extends GameClass {
	public Wizard() {
		setTitle("Wizard");
		
		Pair<String, Integer> increasedINT = new Pair<String,Integer>("INT", 2);
		Pair<String, Integer> increasedWIS = new Pair<String, Integer>("WIS", 2);
		increasedAttributes.add(increasedINT);
		increasedAttributes.add(increasedWIS);
		
		proficienciesWeaponArmor.add("Darts");
		proficienciesWeaponArmor.add("Daggers");
		proficienciesWeaponArmor.add("Slings");
		proficienciesWeaponArmor.add("Quarterstaffs");
		proficienciesWeaponArmor.add("Light Crossbows");	
	}
}
