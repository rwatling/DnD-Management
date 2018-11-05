package main.java;

import java.util.ArrayList;
import javafx.util.Pair;

public class MountainDwarf extends Race {
	ArrayList<Pair<String, Integer>> increasedAttributes = new ArrayList<Pair<String, Integer>>();
	
	public MountainDwarf () {
		setTitle("Mountain Dwarf");
		Pair<String, Integer> increasedCON = new Pair<String,Integer>("CON", 2);
		Pair<String, Integer> increasedSTR = new Pair<String, Integer>("STR", 1);
		increasedAttributes.add(increasedCON);
		increasedAttributes.add(increasedSTR);
	}
	
	public ArrayList<Pair<String, Integer>> getIncAttributes() {
		return increasedAttributes;
	}
}