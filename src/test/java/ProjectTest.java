package test.java;
import static org.junit.Assert.*;

import java.util.ArrayList;

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
		ArrayList<Item> testList = new ArrayList<Item>();
		
		Item myItem1 = new Item("testItem", 5);
		testList.add(myItem1);
		
		assertEquals(myItem1, myInventory.addToInventory(myItem1));
		assertEquals(1, myInventory.getInventory().size());
		assertEquals(5, myItem1.getQuantity());
		assertEquals(testList, myInventory.getInventory());
		
		Item myItem2 = new Item("testItem", 5);
		testList.remove(0);
		
		assertEquals(myItem2, myInventory.addToInventory(myItem2));
		assertEquals(1, myInventory.getInventory().size());
		assertEquals(10, myItem2.getQuantity());
		
		testList.add(myInventory.getInventory().get(0));
		
		assertEquals(testList, myInventory.getInventory());
		
		Item myItem3 = new Item("ItemTest", 8);
		testList.add(0, myItem3);
		
		assertEquals(myItem3, myInventory.addToInventory(myItem3));
		assertEquals(2, myInventory.getInventory().size());
		assertEquals(8, myItem3.getQuantity());
		assertEquals(testList, myInventory.getInventory());
		
		Item myItem4 = new Item("ItemTest2", 16);
		testList.add(1, myItem4);
		
		assertEquals(myItem4, myInventory.addToInventory(myItem4));
		assertEquals(3, myInventory.getInventory().size());
		assertEquals(16, myItem4.getQuantity());
		assertEquals(testList, myInventory.getInventory());
	}
	
	@Test
	public void inventoryRemoveFromInventoryTest() {
		Inventory myInventory = new Inventory();
		ArrayList<Item> testList = new ArrayList<Item>();
		
		Item myItem1 = new Item("testItem", 5);
		assertEquals(myItem1, myInventory.addToInventory(myItem1));
		
		Item myItem2 = new Item("testItem1", 5);
		assertEquals(myItem2, myInventory.addToInventory(myItem2));
		
		Item myItem3 = new Item("testItem2", 8);
		assertEquals(myItem3, myInventory.addToInventory(myItem3));
		
		Item myItem4 = new Item("testItem3", 16);
		assertEquals(myItem4, myInventory.addToInventory(myItem4));
		
	}
}