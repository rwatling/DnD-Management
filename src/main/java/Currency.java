//package main.java;

public class Currency extends Item {
	private int numCopper;
	private int numSilver;
	private int numGold;
	
	public Currency(int numCopper, int numSilver, int numGold) {
		super("Wealth", 1);
		this.numCopper = numCopper;
		this.numSilver = numSilver;
		this.numGold = numGold;
	}
	
	public int getCopper() {
		return numCopper;
	}
	
	public void setCopper(int numCopper) {
		this.numCopper = numCopper;
	}
	
	public int getSilver() {
		return numSilver;
	}
	
	public void setSilver(int numSilver) {
		this.numSilver = numSilver;
	}
	
	public int getGold() {
		return numGold;
	}
	
	public void setGold(int numGold) {
		this.numGold = numGold;
	}
	
	public int calculateWealth() {
		return numCopper + (10 * numSilver) + (100 * numGold);
	}
}
