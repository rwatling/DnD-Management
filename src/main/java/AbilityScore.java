package main.java;

public class AbilityScore extends Attribute {
	
	String title;	// variable title will denote which ability score the object contains
	int score;		// the actual ability score
	int mod;		// the resulting modifier based off of the score
	
	public AbilityScore() {
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
		score = i;						// whenever ability score is set, modifer needs to be re-evaluated
		int dif;						// dif will record difference between new ability score and 10
		if (score % 2 == 0) {			// if the ability score is even we take the full difference between the
			dif = score - 10;			// score and 10
		}
		else {							// if the ability score is odd we only subtract 9, this is because the
			dif = score - 9;			// modifier only increases on each new even number, 12, 14, 16, etc.,
		}								// so at odd numbers it doesn't increase and must be rounded down
		mod = score - (dif / 2) - 10;	// the ability score - half of dif - 10 will result in the correct modifier
	}
	
	public int getMod() {
		return mod;
	}
}