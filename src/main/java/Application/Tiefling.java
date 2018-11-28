import javafx.util.Pair;

public class Tiefling extends Race {
	public Tiefling() {
		setTitle("Tiefling");
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 2);
		Pair<String, Integer> increasedINT = new Pair<String, Integer>("INT", 1);
		increasedAttributes.add(increasedCHA);
		increasedAttributes.add(increasedINT);
		
		languages.add("Infernal");
	}
}
