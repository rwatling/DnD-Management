//package main.java;

import javafx.util.Pair;

public class HalfOrc extends Race {
	public HalfOrc() {
		setTitle("Half-Orc");
		Pair<String, Integer> increasedSTR = new Pair<String, Integer>("STR", 2);
		Pair<String, Integer> increasedCON = new Pair<String, Integer>("CON", 1);
		increasedAttributes.add(increasedSTR);
		increasedAttributes.add(increasedCON);
		
		languages.add("Orc");
	}
}
