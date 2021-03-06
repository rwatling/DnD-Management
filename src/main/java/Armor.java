//package main.java;

public class Armor extends Item {
	private int type; // 0 for no armor, 1 for light armor, 2 for medium armor, 3 for heavy armor.
	private int armorClass;
	private int dexterity;
	private boolean disadvantageOnStealthChecks;
	
	public Armor(String name, int quantity, int type, int currentArmorClass, int dexterity, boolean disadvantageOnStealthChecks) {
		super(name, quantity);
		this.type = type;
		armorClass = calculateArmorClass(currentArmorClass);
		this.dexterity = dexterity;
		this.disadvantageOnStealthChecks = disadvantageOnStealthChecks;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public int getArmorClass() {
		return armorClass;
	}
	
	public int getDexterity() {
		return dexterity;
	}
	
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
		armorClass = calculateArmorClass(armorClass);
	}
	
	public void setArmorClass(int currentArmorClass) {
		armorClass = calculateArmorClass(currentArmorClass);
	}
	
	public boolean getDisadvantageOnStealthChecks() {
		return disadvantageOnStealthChecks;
	}
	
	public void setDisadvantageOnStealthChecks(boolean disadvantageOnStealthChecks) {
		this.disadvantageOnStealthChecks = disadvantageOnStealthChecks;
	}
	
	public int calculateArmorClass(int currentArmorClass) {
		if (type == 1) { // Light Armor
			return currentArmorClass + dexterity;
		} else if (type == 2) { // Medium Armor
			if (dexterity > 2) {
				return currentArmorClass + 2;
			} else {
				return currentArmorClass + dexterity;
			}
		} else if (type == 3) { // Heavy Armor
			return currentArmorClass;
		}
		
		// No Armor
		return 10 + dexterity;
	}
}
