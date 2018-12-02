//package main.java;

public class Weapon extends Item {
	private String damage;
	private String damageType;
	private String properties;
	
	public Weapon(String name, int quantity, String damage, String damageType, String properties) {
		super(name, quantity);
		this.damage = damage;
		this.damageType = damageType;
		this.properties = properties;
	}
	
	public String getDamage() {
		return damage;
	}
	
	public void setDamage(String damage) {
		this.damage = damage;
	}
	
	public String getDamageType() {
		return damageType;
	}
	
	public void setDamageType(String damageType) {
		this.damageType = damageType;
	}
	
	public String getProperties() {
		return properties;
	}
	
	public void setProperties(String properties) {
		this.properties = properties;
	}
}
