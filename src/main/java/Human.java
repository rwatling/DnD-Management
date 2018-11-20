package main.java;

import javafx.util.Pair;

public class Human extends Race {
	public Human() {
		setTitle("Human");
		Pair<String, Integer> increasedSTR = new Pair<String, Integer>("STR", 1);
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 1);
		Pair<String, Integer> increasedCON = new Pair<String, Integer>("CON", 1);
		Pair<String, Integer> increasedINT = new Pair<String, Integer>("INT", 1);
		Pair<String, Integer> increasedWIS = new Pair<String, Integer>("WIS", 1);
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 1);
		
		increasedAttributes.add(increasedSTR);
		increasedAttributes.add(increasedDEX);
		increasedAttributes.add(increasedCON);
		increasedAttributes.add(increasedINT);
		increasedAttributes.add(increasedWIS);
		increasedAttributes.add(increasedCHA);
	}
}
