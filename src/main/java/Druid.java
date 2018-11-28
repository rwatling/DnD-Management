package main.java;

import javafx.util.Pair;

public class Druid extends GameClass {
	public Druid() {
		setTitle("Druid");
		
		Pair<String, Integer> increasedINT = new Pair<String,Integer>("INT", 2);
		Pair<String, Integer> increasedWIS = new Pair<String, Integer>("WIS", 2);
		increasedAttributes.add(increasedINT);
		increasedAttributes.add(increasedWIS);
		
		proficienciesWeaponArmor.add("Medium Armor");
		proficienciesWeaponArmor.add("Light Armor");
	}
}
