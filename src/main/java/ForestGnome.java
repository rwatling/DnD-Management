//package main.java;

import javafx.util.Pair;

public class ForestGnome extends Race {
	public ForestGnome() {
		setTitle("Forest Gnome");
		Pair<String, Integer> increasedINT = new Pair<String, Integer>("INT", 2);
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 1);
		increasedAttributes.add(increasedINT);
		increasedAttributes.add(increasedDEX);
		
		languages.add("Gnomish");
	}
}
