package main.java;

import javafx.util.Pair;

public class StoutHalfling extends Race {
	public StoutHalfling() {
		setTitle("Stout Halfling");
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 2);
		Pair<String, Integer> increasedCON = new Pair<String, Integer>("CON", 1);
		increasedAttributes.add(increasedDEX);
		increasedAttributes.add(increasedCON);
	}
}
