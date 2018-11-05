//package test.java;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.*;

public class ProjectTest {
	
	// ATTRIBUTE TESTS-------------------------------------------------------
	
	@Test
	public void titleAbilityTest () {
		AbilityScore str = new AbilityScore();
		str.setTitle("Strength");
		assertEquals("Strength", str.getTitle());
	}
	
	@Test
	public void abilityScoreAndModTest () {
		AbilityScore dex = new AbilityScore();
		assertEquals("AbilityScore", dex.getType());
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
		assertEquals("SavingThrow", intel.getType());
		intel.setTitle("Intelligence");
		assertEquals("Intelligence", intel.getTitle());
		intel.setMod(2);
		assertEquals(2, intel.getMod());
		intel.setProfcy(true);
		assertEquals(true, intel.getProfcy());
		assertEquals(4, intel.getMod());
	}
	
	@Test
	public void titleClassTest() {
		GameClass pali = new GameClass();
		assertEquals("Class", pali.getType());
		pali.setTitle("Paladin");
		assertEquals("Paladin", pali.getTitle());
	}
	
	@Test
	public void skillGettersSettersTest() {
		Skill stealth = new Skill();
		assertEquals("Skill", stealth.getType());
		stealth.setTitle("Stealth");
		assertEquals("Stealth", stealth.getTitle());
		stealth.setMod(2);
		assertEquals(2, stealth.getMod());
		stealth.setProfcy(true);
		assertEquals(true, stealth.getProfcy());
		assertEquals(4, stealth.getMod());
	}
	
	/* Included in race tests
	@Test
	public void titleRaceTest() {
		Race tief = new Race();
		assertEquals("Race", tief.getType());
		tief.setTitle("Tiefling");
		assertEquals("Tiefling", tief.getTitle());
	}
	*/
	
	@Test
	public void titleBackGroundTest() {
		Background crim = new Background();
		assertEquals("Background", crim.getType());
		crim.setTitle("Criminal");
		assertEquals("Criminal", crim.getTitle());
	}
	
	// SPELL TESTS ---------------------------------------------------------
	
	@Test
	public void cantripTest() {
		Spell eldritchBlast = new Spell();
		eldritchBlast.setName("Eldritch Blast");
		eldritchBlast.setLevel(0);
		eldritchBlast.setCastingTime("1 action");
		eldritchBlast.setRange(120);
		eldritchBlast.setAOE("");
		eldritchBlast.setVerbal(true);
		eldritchBlast.setSomatic(true);
		eldritchBlast.setMaterial("");
		eldritchBlast.setConsumes(false);
		eldritchBlast.setGoldVal(0);
		eldritchBlast.setDuration("Instantaneous");
		eldritchBlast.setTargets(1);
		eldritchBlast.setRoll(true);
		eldritchBlast.setSave(false);
		eldritchBlast.setConcentration(false);
		eldritchBlast.setRitual(false);
		assertEquals("Eldritch Blast", eldritchBlast.getName());
		assertEquals(0, eldritchBlast.getLevel());
		assertEquals("1 action", eldritchBlast.getCastingTime());
		assertEquals(120, eldritchBlast.getRange());
		assertEquals("", eldritchBlast.getAOE());
		assertEquals(true, eldritchBlast.isVerbal());
		assertEquals(true, eldritchBlast.isSomatic());
		assertEquals("", eldritchBlast.getMaterial());
		assertEquals(false, eldritchBlast.doesConsume());
		assertEquals(0, eldritchBlast.getGoldVal());
		assertEquals("Instantaneous", eldritchBlast.getDuration());
		assertEquals(1, eldritchBlast.getTargets());
		assertEquals(true, eldritchBlast.needsRoll());
		assertEquals(false, eldritchBlast.needsSave());
		assertEquals(false, eldritchBlast.isConcentration());
		assertEquals(false, eldritchBlast.isRitual());
	}
	
	@Test
	public void levelOneTest() {
		Spell illusoryScript = new Spell();
		illusoryScript.setName("Illusory Script");
		illusoryScript.setLevel(1);
		illusoryScript.setCastingTime("1 minute");
		illusoryScript.setRange(0);
		illusoryScript.setAOE("");
		illusoryScript.setVerbal(false);
		illusoryScript.setSomatic(true);
		illusoryScript.setMaterial("a lead-based ink worth at least 10 gp, which the spell consumes");
		illusoryScript.setConsumes(true);
		illusoryScript.setGoldVal(10);
		illusoryScript.setDuration("10 days");
		illusoryScript.setTargets(0);
		illusoryScript.setRoll(false);
		illusoryScript.setSave(false);
		illusoryScript.setConcentration(false);
		illusoryScript.setRitual(true);
		assertEquals("Illusory Script", illusoryScript.getName());
		assertEquals(1, illusoryScript.getLevel());
		assertEquals("1 minute", illusoryScript.getCastingTime());
		assertEquals(0, illusoryScript.getRange());
		assertEquals("", illusoryScript.getAOE());
		assertEquals(false, illusoryScript.isVerbal());
		assertEquals(true, illusoryScript.isSomatic());
		assertEquals("a lead-based ink worth at least 10 gp, which the spell consumes", illusoryScript.getMaterial());
		assertEquals(true, illusoryScript.doesConsume());
		assertEquals(10, illusoryScript.getGoldVal());
		assertEquals("10 days", illusoryScript.getDuration());
		assertEquals(0, illusoryScript.getTargets());
		assertEquals(false, illusoryScript.needsRoll());
		assertEquals(false, illusoryScript.needsSave());
		assertEquals(false, illusoryScript.isConcentration());
		assertEquals(true, illusoryScript.isRitual());
	}
	
	@Test
	public void concentrationAOETest() {
		Spell fogCloud = new Spell();
		fogCloud.setName("Fog Cloud");
		fogCloud.setLevel(1);
		fogCloud.setCastingTime("1 action");
		fogCloud.setRange(120);
		fogCloud.setAOE("20-foot-radius sphere");
		fogCloud.setVerbal(true);
		fogCloud.setSomatic(true);
		fogCloud.setMaterial("");
		fogCloud.setConsumes(false);
		fogCloud.setGoldVal(0);
		fogCloud.setDuration("up to 1 hour");
		fogCloud.setTargets(0);
		fogCloud.setRoll(false);
		fogCloud.setSave(false);
		fogCloud.setConcentration(true);
		fogCloud.setRitual(false);
		assertEquals("Fog Cloud", fogCloud.getName());
		assertEquals(1, fogCloud.getLevel());
		assertEquals("1 action", fogCloud.getCastingTime());
		assertEquals(120, fogCloud.getRange());
		assertEquals("20-foot-radius sphere", fogCloud.getAOE());
		assertEquals(true, fogCloud.isVerbal());
		assertEquals(true, fogCloud.isSomatic());
		assertEquals("", fogCloud.getMaterial());
		assertEquals(false, fogCloud.doesConsume());
		assertEquals(0, fogCloud.getGoldVal());
		assertEquals("up to 1 hour", fogCloud.getDuration());
		assertEquals(0, fogCloud.getTargets());
		assertEquals(false, fogCloud.needsRoll());
		assertEquals(false, fogCloud.needsSave());
		assertEquals(true, fogCloud.isConcentration());
		assertEquals(false, fogCloud.isRitual());
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
		
		Item myItem1 = new Item("testItem", 5);
		assertEquals(myItem1, myInventory.addToInventory(myItem1));
		
		Item myItem2 = new Item("testItem1", 5);
		assertEquals(myItem2, myInventory.addToInventory(myItem2));
		
		Item myItem3 = new Item("testItem2", 8);
		assertEquals(myItem3, myInventory.addToInventory(myItem3));
		
		Item myItem4 = new Item("testItem3", 16);
		assertEquals(myItem4, myInventory.addToInventory(myItem4));
		
		ArrayList<Item> testList = new ArrayList<Item>();
		testList.add(0, myItem4);
		testList.add(0, myItem3);
		testList.add(0, myItem2);
		testList.add(0, myItem1);
		
		assertEquals(testList, myInventory.getInventory());
		
		myInventory.removeFromInventory(myItem3);
		testList.remove(myItem3);
		
		assertEquals(testList, myInventory.getInventory());
		
		myInventory.removeFromInventory(myItem1);
		testList.remove(myItem1);
		
		assertEquals(testList, myInventory.getInventory());
		
		myInventory.removeFromInventory(myItem4);
		testList.remove(myItem4);
		
		assertEquals(testList, myInventory.getInventory());
		
		myInventory.removeFromInventory(myItem2);
		testList.remove(myItem2);
		
		assertEquals(testList, myInventory.getInventory());
	}

	//Hill Dwarf Tests-------------------------------------------------
	@Test
	public void testSetRace() {
		PC test = new PC();
		test.setRace("Hill Dwarf");
		
		//Test if race title has been set correctly
		assertEquals(test.getRaceTitle(), "Hill Dwarf");
		
		//Test Hill Dwarf +2 to Constitution, currently 0
		assertEquals(test.getCONScore(), 2);
		
		//Hill Dwarf +1 to WIS, currently 0
		assertEquals(test.getWISScore(), 1);
		
		//Hill Dwarf +1 to HP, currently 0
		assertEquals(test.getHP(), 1);
	}
}