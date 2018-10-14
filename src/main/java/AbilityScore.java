package main.java;

public class AbilityScore extends Attribute {
	
	public AbilityScore() {
		setType("AbilityScore");
	}
	
	String title;
	public void setTitle(String t) {
		title = t;
	}
	
	public String getTitle() {
		return title;
	}
	
	int score;
	public void setScore(int i) {
		score = i;
	}
	
	public int getScore(int i) {
		return score;
	}
}