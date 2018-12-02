import javafx.util.Pair;

public class Paladin extends GameClass {
	public Paladin() {
		setTitle("Paladin");
		
		Pair<String, Integer> increasedWIS = new Pair<String,Integer>("WIS", 2);
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 2);
		increasedAttributes.add(increasedWIS);
		increasedAttributes.add(increasedCHA);
		
		proficienciesWeaponArmor.add("Simple Weapons");
		proficienciesWeaponArmor.add("Martial Weapons");
		proficienciesWeaponArmor.add("Heavy Armor");
		proficienciesWeaponArmor.add("Medium Armor");
		proficienciesWeaponArmor.add("Light Armor");
	}
}
