import java.util.ArrayList;

import javafx.util.Pair;

public class HillDwarf extends Race {
	public HillDwarf () {
		setTitle("Hill Dwarf");
		
		Pair<String, Integer> increasedCON = new Pair<String,Integer>("CON", 2);
		Pair<String, Integer> increasedWIS = new Pair<String, Integer>("WIS", 1);
		Pair<String, Integer> increasedHP = new Pair<String, Integer>("HP", 1);
		increasedAttributes.add(increasedCON);
		increasedAttributes.add(increasedWIS);
		increasedAttributes.add(increasedHP);
		
		languages.add("Dwarvish");
		
		proficienciesWeaponArmor.add("Battleaxe");
		proficienciesWeaponArmor.add("Handaxe");
		proficienciesWeaponArmor.add("Throwing Hammer");
		proficienciesWeaponArmor.add("War Hammer");
	}
}