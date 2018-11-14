package main.java;

import javafx.util.Pair;

public class RockGnome extends Race {
	public RockGnome() {
		setTitle("Rock Gnome");
		Pair<String, Integer> increasedINT = new Pair<String, Integer>("INT", 2);
		Pair<String, Integer> increasedCON = new Pair<String, Integer>("CON", 1);
		increasedAttributes.add(increasedINT);
		increasedAttributes.add(increasedCON);
		
		languages.add("Gnomish");
	}
}
