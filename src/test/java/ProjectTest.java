//package test.java;
import static org.junit.Assert.*;
import org.junit.Test;

import main.java.*;

public class ProjectTest {
	
	// ABILITY SCORE TESTS-------------------------------------------------------
	
	@Test
	public void titleAbilityTest () {
		AbilityScore str = new AbilityScore();
		str.setTitle("Strength");
		assertEquals("Strength", str.getTitle());
	}
	
	@Test
	public void abilityScoreAndModTest () {
		AbilityScore dex = new AbilityScore();
		dex.setTitle("Dexterity");
		dex.setScore(14);
		assertEquals(14, dex.getScore());
		assertEquals(2, dex.getMod());
		dex.setScore(15);
		assertEquals(15, dex.getScore());
		assertEquals(2, dex.getMod());
	}
	
	@Test
	public void savingThrowGettersSettersTest() {
		SavingThrow intel = new SavingThrow();
		intel.setTitle("Intelligence");
		assertEquals("Intelligence", intel.getTitle());
	}
	
	// INVENTORY TESTS ---------------------------------------------------------
	
	@Test
	public void itemGettersSettersTest() {
		Item myItem = new Item("testItem", 5);
		assertEquals("testItem", myItem.getName());
		assertEquals(5, myItem.getQuantity());
		myItem.setName("testItem2");
		myItem.setQuantity(10);
		assertEquals("testItem2", myItem.getName());
		assertEquals(10, myItem.getQuantity());
	}
	
	@Test
	public void inventoryAddToInventoryTest() {
		Inventory myInventory = new Inventory();
		
		Item myItem1 = new Item("testItem", 5);
		assertEquals(myItem1, myInventory.addToInventory(myItem1));
		assertEquals(5, myItem1.getQuantity());
		
		Item myItem2 = new Item("testItem", 5);
		assertEquals(myItem2, myInventory.addToInventory(myItem2));
		assertEquals(10, myItem2.getQuantity());
	}
}