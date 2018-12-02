//package main.java;

import javafx.util.Pair;

public class HalfElf extends Race {
	public HalfElf() {
		setTitle("Half-Elf");
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 2);
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 1); //HARDCODED, NORMALLY CAN CHOOSE
		Pair<String, Integer> increasedCON = new Pair<String, Integer>("CON", 1); //HARDCODED, NORMALLY CAN CHOOSE
		increasedAttributes.add(increasedCHA);
		increasedAttributes.add(increasedDEX);
		increasedAttributes.add(increasedCON);
		
		languages.add("Elvish");
	}
}
