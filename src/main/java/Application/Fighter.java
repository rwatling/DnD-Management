import javafx.util.Pair;

public class Fighter extends GameClass {
	public Fighter() {
		setTitle("Fighter");
		
		Pair<String, Integer> increasedSTR = new Pair<String,Integer>("STR", 2);
		Pair<String, Integer> increasedCON = new Pair<String, Integer>("CON", 2);
		increasedAttributes.add(increasedSTR);
		increasedAttributes.add(increasedCON);
		
		proficienciesWeaponArmor.add("Simple Weapons");
		proficienciesWeaponArmor.add("Martial Weapons");
		proficienciesWeaponArmor.add("Heavy Armor");
		proficienciesWeaponArmor.add("Medium Armor");
		proficienciesWeaponArmor.add("Light Armor");
	}
}
