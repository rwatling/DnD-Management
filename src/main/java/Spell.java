//package main.java;

public class Spell {
	
	String name;		// stores the name of the spell
	int lvl;			// stores the level of the spell
	int range;			// stores the range of the spell
	String castTime;	// stores the casting time of the spell
	String aoe;			// stores the area of effect of the spell
	int targets;		// stores the number of targets the spell can have
	String duration;	// stores the duration of the spell
	boolean verbal;		// denotes whether the spell requires a verbal component
	boolean somatic;	// denotes whether the spell requires a somatic component
	String material;	// denotes what materials the spell requires, if any
	int goldVal;		// denotes how much the materials a spell requires must be worth, if applicable 
	boolean consumes;	// denotes whether the spell consumes the materials it requires
	boolean conc;		// denotes whether the spell requires concentration
	boolean roll;		// denotes whether the spell requires a spell attack role
	boolean save;		// denotes whether the spell requires the target to make a saving throw
	boolean rit;		// denotes whether the spell is a ritual
	String spellText;	// contains the actual description fo the spell from the player's handbook
	
	public String getName() {
		return name;
	}
	
	public void setName(String s) {
		name = s;
	}
	
	public int getLevel() {
		return lvl;
	}
	
	public void setLevel(int i) {
		lvl = i;
	}
	
	public int getRange() {
		return range;
	}
	
	public void setRange(int i) {
		range = i;
	}
	
	public String getCastingTime() {
		return castTime;
	}
	
	public void setCastingTime(String s) {
		castTime = s;
	}
	
	public String getAOE() {
		return aoe;
	}
	
	public void setAOE(String s) {
		aoe = s;
	}
	
	public int getTargets() {
		return targets;
	}
	
	public void setTargets(int i) {
		targets = i;
	}
	
	public String getDuration() {
		return duration;
	}
	
	public void setDuration(String s) {
		duration = s;
	}
	
	public boolean isVerbal() {
		return verbal;
	}
	
	public void setVerbal(boolean b) {
		verbal = b;
	}
	
	public boolean isSomatic() {
		return somatic;
	}
	
	public void setSomatic(boolean b) {
		somatic = b;
	}
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String s) {
		material = s;
	}
	
	public int getGoldVal() {
		return goldVal;
	}
		
	public void setGoldVal(int i) {
		goldVal = i;
	}
	
	public boolean doesConsume() {
		return consumes;
	}
	
	public void setConsumes(boolean b) {
		consumes = b;
	}
		
	public boolean isConcentration() {
		return conc;
	}
	
	public void setConcentration(boolean b) {
		conc = b;
	}
	
	public boolean needsRoll() {
		return roll;
	}
	
	public void setRoll(boolean b) {
		roll = b;
	}
	
	public boolean needsSave() {
		return save;
	}
	
	public void setSave(boolean b) {
		save = b;
	}
	
	public boolean isRitual() {
		return rit;
	}
	
	public void setRitual(boolean b) {
		rit = b;
	}
	
	public String getSpellText() {
		return spellText;
	}
	
	public void setSpellText(String s) {
		spellText = s;
	}
}