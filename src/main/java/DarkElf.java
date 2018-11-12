package main.java;

import javafx.util.Pair;

public class DarkElf extends Race {
	public DarkElf() {
		setTitle("Dark Elf");
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 2);
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 1);
		increasedAttributes.add(increasedDEX);
		increasedAttributes.add(increasedCHA);
	}
}
