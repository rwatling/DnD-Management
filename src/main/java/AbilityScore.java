package main.java;

public class AbilityScore extends Attribute {
	
	String title;
	int score;
	int mod;
	
	public void AbilityScore() {
		setType("AbilityScore");
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int i) {
		score = i;
		int dif;
		if (score % 2 == 0) {
			dif = score - 10;
		}
		else {
			dif = score - 9;
		}
		mod = score - (dif / 2) - 10;
	}
	
	public int getMod() {
		return mod;
	}
}