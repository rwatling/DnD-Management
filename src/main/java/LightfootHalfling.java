package main.java;

import javafx.util.Pair;

public class LightfootHalfling extends Race{
	public LightfootHalfling() {
		setTitle("Lightfoot Halfling");
		Pair<String, Integer> increasedDEX = new Pair<String, Integer>("DEX", 2);
		Pair<String, Integer> increasedCHA = new Pair<String, Integer>("CHA", 1);
		increasedAttributes.add(increasedDEX);
		increasedAttributes.add(increasedCHA);
	}
}
