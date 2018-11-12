package main.java;

import javafx.util.Pair;

public class WoodElf extends Race {
	public WoodElf() {
		setTitle("Wood Elf");
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 2);
		Pair<String, Integer> increasedWIS = new Pair<String, Integer>("WIS", 1);
		increasedAttributes.add(increasedDEX);
		increasedAttributes.add(increasedWIS);
	}
}
