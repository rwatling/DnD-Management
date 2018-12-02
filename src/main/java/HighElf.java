//package main.java;

import java.util.ArrayList;
import javafx.util.Pair;

public class HighElf extends Race {
	public HighElf() {
		setTitle("High Elf");
		
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 2);
		Pair<String, Integer> increasedINT = new Pair<String, Integer>("INT", 1);
		increasedAttributes.add(increasedDEX);
		increasedAttributes.add(increasedINT);
		
		languages.add("Elvish");
		
		proficienciesWeaponArmor.add("Longsword");
		proficienciesWeaponArmor.add("Shortsword");
		proficienciesWeaponArmor.add("Longbow");
		proficienciesWeaponArmor.add("Shortbow");
	}
}