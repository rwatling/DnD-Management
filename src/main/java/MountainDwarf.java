package main.java;

import java.util.ArrayList;
import javafx.util.Pair;

public class MountainDwarf extends Race {
	public MountainDwarf() {
		setTitle("Mountain Dwarf");
		Pair<String, Integer> increasedCON = new Pair<String,Integer>("CON", 2);
		Pair<String, Integer> increasedSTR = new Pair<String, Integer>("STR", 1);
		increasedAttributes.add(increasedCON);
		increasedAttributes.add(increasedSTR);
	}
}