import javafx.util.Pair;

public class Cleric extends GameClass {
	public Cleric() {
		setTitle("Cleric");
		
		Pair<String, Integer> increasedWIS = new Pair<String,Integer>("WIS", 2);
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 2);
		increasedAttributes.add(increasedWIS);
		increasedAttributes.add(increasedCHA);
		
		proficienciesWeaponArmor.add("Medium Armor");
		proficienciesWeaponArmor.add("Light Armor");
	}
}
