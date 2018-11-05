package main.java;

import java.util.ArrayList;

import javafx.util.Pair;

public class HillDwarf extends Race {
	ArrayList<Pair<String, Integer>> increasedAttributes = new ArrayList<Pair<String, Integer>>();
	
	public HillDwarf () {
		setTitle("Hill Dwarf");
		Pair<String, Integer> increasedCON = new Pair<String,Integer>("CON", 2);
		Pair<String, Integer> increasedWIS = new Pair<String, Integer>("WIS", 1);
		Pair<String, Integer> increasedHP = new Pair<String, Integer>("HP", 1);
		increasedAttributes.add(increasedCON);
		increasedAttributes.add(increasedWIS);
		increasedAttributes.add(increasedHP);
	}
	
	public ArrayList<Pair<String, Integer>> getIncAttributes() {
		return increasedAttributes;
	}
}