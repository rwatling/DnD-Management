package main.java;

import java.util.ArrayList;
import javafx.util.Pair;

abstract public class Race extends Attribute {
	String title;	// variable title denotes which race this object contains
	ArrayList<Pair<String, Integer>> increasedAttributes = new ArrayList<Pair<String, Integer>>();
	
	public Race() {
		setType("Race");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public ArrayList<Pair<String, Integer>> getIncAttributes() {
		return increasedAttributes;
	}
}