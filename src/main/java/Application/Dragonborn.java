import javafx.util.Pair;

public class Dragonborn extends Race {
	public Dragonborn() {
		setTitle("Dragonborn");
		Pair<String, Integer> increasedSTR = new Pair<String, Integer>("STR", 2);
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 1);
		
		increasedAttributes.add(increasedSTR);
		increasedAttributes.add(increasedCHA);
		
		languages.add("Draconic");
	}
}
