package test.java;
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
	}
	
	@Test
	public void skillsAndAttributesTest() {
		PC test = new PC();
		//ints go strength, dex, constitution, intelligence, wisdom, cha
		test.setAbilityScores(15, 14, 13, 12, 10, 8);
		assertEquals(2, test.getAthletics().getMod());	//relies on strength
		assertEquals(2, test.getAcrobatics().getMod());	//relies on dex
		assertEquals(1, test.getHistory().getMod());	//relies on intelligence
		assertEquals(0, test.getSurvival().getMod());	//relies on wisdom
		assertEquals(-1, test.getPerformance().getMod());	//relies on charisma
		
		test.setAbilityScores(7, 7, 7, 7, 7, 7);
		assertEquals(-2, test.getAthletics().getMod());	//relies on strength
		assertEquals(-2, test.getAcrobatics().getMod());	//relies on dex
		assertEquals(-2, test.getHistory().getMod());	//relies on intelligence
		assertEquals(-2, test.getSurvival().getMod());	//relies on wisdom
		assertEquals(-2, test.getPerformance().getMod());	//relies on charisma
		//none rely on consitution
	}
	
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
		eldritchBlast.setSpellText("A beam of crackling energy streaks toward a creature within range. Make a ranged spell attack against the target. On a hit, the target takes ldlO force damage.");
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
		assertEquals("A beam of crackling energy streaks toward a creature within range. Make a ranged spell attack against the target. On a hit, the target takes ldlO force damage.", eldritchBlast.getSpellText());
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
		illusoryScript.setSpellText("You write on parchment, paper, or some other suitable writing material and imbue it with a potent illusion that lasts for the duration. To you and any creatures you designate when you cast the spell, the writing appears normal, written in your hand, and conveys whatever meaning you intended when you wrote the text. To all others, the writing appears as if it were written in an unknown or magical script that is unintelligible. Alternatively, you can cause the writing to appear to be an entire1y different message, written in a different hand and language, though the language must be one you know. Should the spell be dispelled, the original script and the illusion both disappear. A creature wilh truesight can read the hidden message.");
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
		assertEquals("You write on parchment, paper, or some other suitable writing material and imbue it with a potent illusion that lasts for the duration. To you and any creatures you designate when you cast the spell, the writing appears normal, written in your hand, and conveys whatever meaning you intended when you wrote the text. To all others, the writing appears as if it were written in an unknown or magical script that is unintelligible. Alternatively, you can cause the writing to appear to be an entire1y different message, written in a different hand and language, though the language must be one you know. Should the spell be dispelled, the original script and the illusion both disappear. A creature wilh truesight can read the hidden message.", illusoryScript.getSpellText());
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
		fogCloud.setSpellText("You create a 20-foot-radius sphere of fog centered on a point within range. The sphere spreads around coroers, and its area is heavily obscured. It lasts for the duration or until a wind of moderate or greater speed (at least 10 miles per hour) disperses it.");
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
		assertEquals("You create a 20-foot-radius sphere of fog centered on a point within range. The sphere spreads around coroers, and its area is heavily obscured. It lasts for the duration or until a wind of moderate or greater speed (at least 10 miles per hour) disperses it.", fogCloud.getSpellText());
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
		
		Item myItem5 = new Item("testItem4", 20);
		assertEquals(null, myInventory.removeFromInventory(myItem5));
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
		
		assertEquals(null, myInventory.removeFromInventory(myItem5));
		assertEquals(testList, myInventory.getInventory());
	}
	
	@Test
	public void calculateArmorClassTest() {
		Armor armor = new Armor("None", 1, 0, 0, 0, false);
		assertEquals(10, armor.getArmorClass());
		
		armor.setDexterity(1);
		assertEquals(11, armor.getArmorClass());
		
		armor.setDexterity(2);
		assertEquals(12, armor.getArmorClass());
		
		armor.setDexterity(3);
		assertEquals(13, armor.getArmorClass());
		
		armor.setArmorClass(12);
		assertEquals(13, armor.getArmorClass());
		
		assertEquals(0, armor.getType());
		armor.setType(1);
		assertEquals(1, armor.getType());
		assertEquals(3, armor.getDexterity());
		assertEquals(false, armor.getDisadvantageOnStealthChecks());
		armor.setDisadvantageOnStealthChecks(true);
		assertEquals(true, armor.getDisadvantageOnStealthChecks());
		
		// Light Armor
		armor = new Armor("Leather", 3, 1, 11, 0, false);
		assertEquals(11, armor.getArmorClass());
		
		armor.setDexterity(1);
		assertEquals(12, armor.getArmorClass());
		
		armor.setDexterity(2);
		armor.setArmorClass(11);
		assertEquals(13, armor.getArmorClass());
		
		armor.setDexterity(3);
		armor.setArmorClass(11);
		assertEquals(14, armor.getArmorClass());
		
		// Medium Armor
		armor = new Armor("Hide", 12, 2, 12, 0, false);
		assertEquals(12, armor.getArmorClass());
		
		armor.setDexterity(1);
		assertEquals(13, armor.getArmorClass());
		
		armor.setDexterity(2);
		armor.setArmorClass(12);
		assertEquals(14, armor.getArmorClass());
		
		armor.setDexterity(3);
		armor.setArmorClass(12);
		assertEquals(14, armor.getArmorClass());
		
		// Heavy Armor
		armor = new Armor("Splint", 1, 3, 17, 0, true);
		assertEquals(17, armor.getArmorClass());
		
		armor.setDexterity(1);
		assertEquals(17, armor.getArmorClass());
		
		armor.setDexterity(2);
		assertEquals(17, armor.getArmorClass());
		
		armor.setDexterity(3);
		assertEquals(17, armor.getArmorClass());
		
		armor.setArmorClass(12);
		assertEquals(12, armor.getArmorClass());
	}
	
	@Test
	public void currencyTest() {
		Currency myCurrency = new Currency(0, 0, 0);
		assertEquals(0, myCurrency.calculateWealth());
		assertEquals(0, myCurrency.getCopper());
		assertEquals(0, myCurrency.getSilver());
		assertEquals(0, myCurrency.getGold());
		
		myCurrency.setCopper(5);
		assertEquals(5, myCurrency.calculateWealth());
		
		myCurrency.setSilver(10);
		assertEquals(105, myCurrency.calculateWealth());
		
		myCurrency.setGold(20);
		assertEquals(2105, myCurrency.calculateWealth());
	}
	
	@Test
	public void weaponTest() {
		Weapon myWeapon = new Weapon("Club", 1, "1d4", "Bludgeoning", "Light");
		assertEquals("1d4", myWeapon.getDamage());
		assertEquals("Bludgeoning", myWeapon.getDamageType());
		assertEquals("Light", myWeapon.getProperties());
		
		myWeapon.setDamage("2d4");
		myWeapon.setDamageType("Slashing");
		myWeapon.setProperties("Two-Handed");
		
		assertEquals("2d4", myWeapon.getDamage());
		assertEquals("Slashing", myWeapon.getDamageType());
		assertEquals("Two-Handed", myWeapon.getProperties());
	}

	//Hill Dwarf Tests-------------------------------------------------
	@Test
	public void testHillDwarf() {
		PC test = new PC();
		test.setRace("Hill Dwarf");
		
		//Test if race title has been set correctly
		assertEquals("Hill Dwarf", test.getRaceTitle());
		
		//Test Dwarf +2 to Constitution, currently 0
		assertEquals(2, test.getCONScore());
		
		//Hill Dwarf +1 to WIS, currently 0
		assertEquals(1, test.getWISScore());
		
		//Hill Dwarf +1 to HP, currently 0
		assertEquals(1, test.getHP());
		
		//Get languages
		assertEquals("Dwarvish", test.getLanguages().get(0));
		
		//Get proficiencies
		assertEquals("Battleaxe", test.getProficiencies().get(0));
		
		//test size to see all items were added
		assertEquals(4, test.getProficiencies().size());
	}
	
	//Mountain Dwarf Tests---------------------------------------------
	@Test
	public void testMountainDwarf() {
		PC test = new PC();
		test.setRace("Mountain Dwarf");
		
		//Test if race title has been set correctly
		assertEquals("Mountain Dwarf", test.getRaceTitle());
		
		//Test Dwarf +2 to Constitution, currently 0
		assertEquals(2, test.getCONScore());
		
		//Mountain Dwarf +1 to Strength, currently 0
		assertEquals(1, test.getSTRScore());
		
		//Mountain Dwarf HP currently 0
		assertEquals(0, test.getHP());
		
		//Get languages
		assertEquals("Dwarvish", test.getLanguages().get(0));
		
		//Get proficiencies
		assertEquals("Battleaxe", test.getProficiencies().get(0));
		
		//test size to see all items were added
		assertEquals(6, test.getProficiencies().size());
	}
	
	//High Elf Tests--------------------------------------------------
	@Test
	public void testHighElf() {
		PC test = new PC();
		test.setRace("High Elf");
		
		assertEquals("High Elf", test.getRaceTitle());
		
		assertEquals(2, test.getDEXScore());
		
		assertEquals(1, test.getINTScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Elvish", test.getLanguages().get(0));
		
		assertEquals("Shortbow", test.getProficiencies().get(3));
		
		assertEquals(4, test.getProficiencies().size());
	}
	
	//Wood Elf Tests--------------------------------------------------
	@Test
	public void testWoodElf() {
		PC test = new PC();
		test.setRace("Wood Elf");
		
		assertEquals("Wood Elf", test.getRaceTitle());
		
		assertEquals(2, test.getDEXScore());
		
		assertEquals(1, test.getWISScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Elvish", test.getLanguages().get(0));
		
		assertEquals("Shortbow", test.getProficiencies().get(3));
		
		assertEquals(4, test.getProficiencies().size());
	}
	
	//Dark Elf Tests--------------------------------------------------
	@Test
	public void testDarkElf() {
		PC test = new PC();
		test.setRace("Dark Elf");
		
		assertEquals("Dark Elf", test.getRaceTitle());
		
		assertEquals(2, test.getDEXScore());
		
		assertEquals(1, test.getCHAScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Elvish", test.getLanguages().get(0));
		
		assertEquals("Hand Crossbows", test.getProficiencies().get(2));
		
		assertEquals(3, test.getProficiencies().size());
	}
	
	//Lightfoot Halfling Tests--------------------------------------------------
	@Test
	public void testLightfootHalfling() {
		PC test = new PC();
		test.setRace("Lightfoot Halfling");
		
		assertEquals("Lightfoot Halfling", test.getRaceTitle());
		
		assertEquals(2, test.getDEXScore());
		
		assertEquals(1, test.getCHAScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Halfling", test.getLanguages().get(0));
		
		assertEquals(0, test.getProficiencies().size());
	}
	
	//Stout Halfling Tests--------------------------------------------------
	@Test
	public void testStoutHalfling() {
		PC test = new PC();
		test.setRace("Stout Halfling");
		
		assertEquals("Stout Halfling", test.getRaceTitle());
		
		assertEquals(2, test.getDEXScore());
		
		assertEquals(1, test.getCONScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Halfling", test.getLanguages().get(0));
		
		assertEquals(0, test.getProficiencies().size());
	}
	
	//Human Tests--------------------------------------------------
	@Test
	public void testHuman() {
		PC test = new PC();
		test.setRace("Human");
		
		assertEquals("Human", test.getRaceTitle());
		
		assertEquals(1, test.getSTRScore());
		
		assertEquals(1, test.getDEXScore());
		
		assertEquals(1, test.getCONScore());

		assertEquals(1, test.getINTScore());
		
		assertEquals(1, test.getWISScore());
		
		assertEquals(1, test.getCHAScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(0, test.getProficiencies().size());
	}
	
	//Dragonborn Tests--------------------------------------------------
	@Test
	public void testDragonborn() {
		PC test = new PC();
		test.setRace("Dragonborn");
		
		assertEquals("Dragonborn", test.getRaceTitle());
		
		assertEquals(2, test.getSTRScore());
		
		assertEquals(1, test.getCHAScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Draconic", test.getLanguages().get(0));
		
		assertEquals(0, test.getProficiencies().size());
	}
	
	//Forest Gnome Tests--------------------------------------------------
	@Test
	public void testForestGnome() {
		PC test = new PC();
		test.setRace("Forest Gnome");
		
		assertEquals("Forest Gnome", test.getRaceTitle());
		
		assertEquals(2, test.getINTScore());
		
		assertEquals(1, test.getDEXScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Gnomish", test.getLanguages().get(0));
		
		assertEquals(0, test.getProficiencies().size());
	}
	
	//Rock Gnome Tests--------------------------------------------------
	@Test
	public void testRockGnome() {
		PC test = new PC();
		test.setRace("Rock Gnome");
		
		assertEquals("Rock Gnome", test.getRaceTitle());
		
		assertEquals(2, test.getINTScore());
		
		assertEquals(1, test.getCONScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Gnomish", test.getLanguages().get(0));
		
		assertEquals(0, test.getProficiencies().size());
	}
	
	//Half-Elf Tests--------------------------------------------------
	@Test
	public void testHalfElf() {
		PC test = new PC();
		test.setRace("Half-Elf");
		
		assertEquals("Half-Elf", test.getRaceTitle());
		
		assertEquals(2, test.getCHAScore());
		
		assertEquals(1, test.getDEXScore());
		
		assertEquals(1, test.getCONScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Elvish", test.getLanguages().get(0));
		
		assertEquals(0, test.getProficiencies().size());
	}
	
	//Half-Orc Tests--------------------------------------------------
	@Test
	public void testHalfOrc() {
		PC test = new PC();
		test.setRace("Half-Orc");
		
		assertEquals("Half-Orc", test.getRaceTitle());
		
		assertEquals(2, test.getSTRScore());
		
		assertEquals(1, test.getCONScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Orc", test.getLanguages().get(0));
		
		assertEquals(0, test.getProficiencies().size());
	}
	
	//Tiefling Tests--------------------------------------------------
	@Test
	public void testTiefling() {
		PC test = new PC();
		test.setRace("Tiefling");
		
		assertEquals("Tiefling", test.getRaceTitle());
		
		assertEquals(2, test.getCHAScore());
		
		assertEquals(1, test.getINTScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals("Infernal", test.getLanguages().get(0));
		
		assertEquals(0, test.getProficiencies().size());
	}
	
	//Barbarian Tests--------------------------------------------------
	@Test
	public void testBarbarian() {
		PC test = new PC();
		test.setClass("Barbarian");
		
		assertEquals("Barbarian", test.getClassTitle());
		
		assertEquals(2, test.getCONScore());
		
		assertEquals(2, test.getSTRScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(4, test.getProficiencies().size());
	}
	
	//Bard Tests--------------------------------------------------
	@Test
	public void testBard() {
		PC test = new PC();
		test.setClass("Bard");
		
		assertEquals("Bard", test.getClassTitle());
		
		assertEquals(2, test.getDEXScore());
		
		assertEquals(2, test.getCHAScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(6, test.getProficiencies().size());
	}
	
	//Cleric Tests--------------------------------------------------
	@Test
	public void testCleric() {
		PC test = new PC();
		test.setClass("Cleric");
		
		assertEquals("Cleric", test.getClassTitle());
		
		assertEquals(2, test.getWISScore());

		assertEquals(2, test.getCHAScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(2, test.getProficiencies().size());
	}
	
	//Druid Tests--------------------------------------------------
	@Test
	public void testDruid() {
		PC test = new PC();
		test.setClass("Druid");
		
		assertEquals("Druid", test.getClassTitle());
		
		assertEquals(2, test.getINTScore());
		
		assertEquals(2, test.getWISScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(12, test.getProficiencies().size());
	}
	
	//Fighter Tests--------------------------------------------------
	@Test
	public void testFighter() {
		PC test = new PC();
		test.setClass("Fighter");
		
		assertEquals("Fighter", test.getClassTitle());
		
		assertEquals(2, test.getSTRScore());
		
		assertEquals(2, test.getCONScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(5, test.getProficiencies().size());
	}
	
	//Monk Tests--------------------------------------------------
	@Test
	public void testMonk() {
		PC test = new PC();
		test.setClass("Monk");
		
		assertEquals("Monk", test.getClassTitle());
		
		assertEquals(2, test.getSTRScore());
		
		assertEquals(2, test.getDEXScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(2, test.getProficiencies().size());
	}
	
	//Paladin Tests--------------------------------------------------
	@Test
	public void testPaladin() {
		PC test = new PC();
		test.setClass("Paladin");
		
		assertEquals("Paladin", test.getClassTitle());
		
		assertEquals(2, test.getWISScore());
		
		assertEquals(2, test.getCHAScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(5, test.getProficiencies().size());
	}
	
	//Ranger Tests--------------------------------------------------
	@Test
	public void testRanger() {
		PC test = new PC();
		test.setClass("Ranger");
		
		assertEquals("Ranger", test.getClassTitle());
		
		assertEquals(2, test.getSTRScore());
		
		assertEquals(2, test.getDEXScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(4, test.getProficiencies().size());
	}
	
	//Rogue Tests--------------------------------------------------
	@Test
	public void testRogue() {
		PC test = new PC();
		test.setClass("Rogue");
		
		assertEquals("Rogue", test.getClassTitle());
		
		assertEquals(2, test.getDEXScore());
		
		assertEquals(2, test.getINTScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(6, test.getProficiencies().size());
	}
	
	//Sorcerer Tests--------------------------------------------------
	@Test
	public void testSorcerer() {
		PC test = new PC();
		test.setClass("Sorcerer");
		
		assertEquals("Sorcerer", test.getClassTitle());
		
		assertEquals(2, test.getCONScore());
		
		assertEquals(2, test.getCHAScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(5, test.getProficiencies().size());
	}
	
	//Warlock Tests--------------------------------------------------
	@Test
	public void testWarlock() {
		PC test = new PC();
		test.setClass("Warlock");
		
		assertEquals("Warlock", test.getClassTitle());
		
		assertEquals(2, test.getWISScore());
		
		assertEquals(2, test.getCHAScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(2, test.getProficiencies().size());
	}
	
	//Wizard Tests--------------------------------------------------
	@Test
	public void testWizard() {
		PC test = new PC();
		test.setClass("Wizard");
		
		assertEquals("Wizard", test.getClassTitle());
		
		assertEquals(2, test.getINTScore());
		
		assertEquals(2, test.getWISScore());
		
		assertEquals(0, test.getHP());
		
		assertEquals(5, test.getProficiencies().size());
	}
	
	//Acolyte Tests--------------------------------------------------
	@Test
	public void testAcolyte() {
		PC test = new PC();
		test.setBackground("Acolyte");
		
		assertEquals("Acolyte", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Acolyte();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Insight");
		skillProfs.add("Religion");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(2, testBackground.getNumLangs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Holy Symbol");
		equipment.add("Prayer Book or Prayer Wheel");
		equipment.add("5 Sticks of Incense");
		equipment.add("Vestments");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 15 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Shelter of the Faithful", testBackground.getFeature());
	}
	
	//Charlatan Tests--------------------------------------------------
	@Test
	public void testCharlatan() {
		PC test = new PC();
		test.setBackground("Charlatan");
		
		assertEquals("Charlatan", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Charlatan();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Deception");
		skillProfs.add("Sleight of Hand");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(0, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Disguise Kit");
		toolProfs.add("Forgery Kit");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Set of Fine Clothes");
		equipment.add("Disguise Kit");
		equipment.add("Tools of the con of your choice");
		equipment.add("Belt Pouch Containing 15 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("False Identity", testBackground.getFeature());
	}
	
	//Criminal Tests--------------------------------------------------
	@Test
	public void testCriminal() {
		PC test = new PC();
		test.setBackground("Criminal");
		
		assertEquals("Criminal", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Criminal();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Deception");
		skillProfs.add("Stealth");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(0, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Gaming Set");
		toolProfs.add("Thieve's Tools");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Crowbar");
		equipment.add("Set of Dark Common Clothes Including a Hood");
		equipment.add("Belt Pouch Containing 15 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Criminal Contact", testBackground.getFeature());
	}
	
	//Entertainer Tests--------------------------------------------------
	@Test
	public void testEntertainer() {
		PC test = new PC();
		test.setBackground("Entertainer");
		
		assertEquals("Entertainer", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Entertainer();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Acrobatics");
		skillProfs.add("Performance");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(0, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Disguise Kit");
		toolProfs.add("One Type of Musical Instrument");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("One Musical Instrument");
		equipment.add("The Favor of an Admirer");
		equipment.add("Belt Pouch Containing 15 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("By Popular Demand", testBackground.getFeature());
	}
	
	//Folk Hero Tests--------------------------------------------------
	@Test
	public void testFolkHero() {
		PC test = new PC();
		test.setBackground("Folk Hero");
		
		assertEquals("Folk Hero", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new FolkHero();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Animal Handling");
		skillProfs.add("Survival");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(0, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Artisan's Tools");
		toolProfs.add("Vehicles (Land)");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Set of Artisan's Tools (One of Your Choice)");
		equipment.add("Shovel");
		equipment.add("Iron Pot");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Rustic Hospitality", testBackground.getFeature());
	}
	
	//Guild Artisan Tests--------------------------------------------------
	@Test
	public void testGuildArtisan() {
		PC test = new PC();
		test.setBackground("Guild Artisan");
		
		assertEquals("Guild Artisan", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new GuildArtisan();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Insight");
		skillProfs.add("Persuasion");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(0, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Artisan's Tools");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Set of Artisan's Tools (One of Your Choice)");
		equipment.add("Letter of Introduction From Your Guild");
		equipment.add("Set of Traveler's Clothes");
		equipment.add("Belt Pouch Containing 15 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Guild Membership", testBackground.getFeature());
	}
	
	//Hermit Tests--------------------------------------------------
	@Test
	public void testHermit() {
		PC test = new PC();
		test.setBackground("Hermit");
		
		assertEquals("Hermit", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Hermit();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Medicine");
		skillProfs.add("Religion");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(1, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Herbalism Kit");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Scroll Case Stuffed Full of Notes From Your Studies or Prayers");
		equipment.add("Winter Blanket");
		equipment.add("Set of Common Clothes");
		equipment.add("Herbalism Kit");
		equipment.add("5 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Discovery", testBackground.getFeature());
	}
	
	//Noble Tests--------------------------------------------------
	@Test
	public void testNoble() {
		PC test = new PC();
		test.setBackground("Noble");
		
		assertEquals("Noble", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Noble();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("History");
		skillProfs.add("Persuasion");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(1, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Gaming Set");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Set of Fine Clothes");
		equipment.add("Signet Ring");
		equipment.add("Scroll of Pedigree");
		equipment.add("Purse Containing 25 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Position of Privilege", testBackground.getFeature());
	}
	
	//Outlander Tests--------------------------------------------------
	@Test
	public void testOutlander() {
		PC test = new PC();
		test.setBackground("Outlander");
		
		assertEquals("Outlander", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Outlander();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Athletics");
		skillProfs.add("Survival");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(1, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Musical Instrument");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Staff");
		equipment.add("Hunting Trap");
		equipment.add("Trophy From an Animal You Killed");
		equipment.add("Set of Traveler's Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Wanderer", testBackground.getFeature());
	}
	
	//Sage Tests--------------------------------------------------
	@Test
	public void testSage() {
		PC test = new PC();
		test.setBackground("Sage");
		
		assertEquals("Sage", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Sage();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Arcana");
		skillProfs.add("History");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(2, testBackground.getNumLangs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Bottle of Black Ink");
		equipment.add("Quill");
		equipment.add("Small Knife");
		equipment.add("Letter From a Dead Colleague Posing a Question You Have Not Yet Been Able To Answer");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Researcher", testBackground.getFeature());
	}
	
	//Sailor Tests--------------------------------------------------
	@Test
	public void testSailor() {
		PC test = new PC();
		test.setBackground("Sailor");
		
		assertEquals("Sailor", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Sailor();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Athletics");
		skillProfs.add("Perception");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(0, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Navigator's Tools");
		toolProfs.add("Vehicles (Water)");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Belaying Pin (Club)");
		equipment.add("50 Feet of Silk Rope");
		equipment.add("Lucky Charm");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Ship's Passage", testBackground.getFeature());
	}
	
	//Soldier Tests--------------------------------------------------
	@Test
	public void testSoldier() {
		PC test = new PC();
		test.setBackground("Soldier");
		
		assertEquals("Soldier", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Soldier();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Athletics");
		skillProfs.add("Intimidation");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(0, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("One Type of Gaming Set");
		toolProfs.add("Vehicles (Land)");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Insignia of Rank");
		equipment.add("Trophy Taken From a Fallen Enemy");
		equipment.add("Set of Bone Dice or Deck of Cards");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("Military Rank", testBackground.getFeature());
	}
	
	//Urchin Tests--------------------------------------------------
	@Test
	public void testUrchin() {
		PC test = new PC();
		test.setBackground("Urchin");
		
		assertEquals("Urchin", test.getBackgroundTitle());
		
		assertEquals(0, test.getHP());
		
		Background testBackground = new Urchin();
		
		ArrayList<String> skillProfs = new ArrayList<String>();
		skillProfs.add("Sleight of Hand");
		skillProfs.add("Stealth");
		
		assertEquals(skillProfs, testBackground.getSkillProfs());
		
		assertEquals(0, testBackground.getNumLangs());
		
		ArrayList<String> toolProfs = new ArrayList<String>();
		toolProfs.add("Disguise Kit");
		toolProfs.add("Thieves' Tools");
		
		assertEquals(toolProfs, testBackground.getToolProfs());
		
		ArrayList<String> equipment = new ArrayList<String>();
		equipment.add("Small Knife");
		equipment.add("Map of the City You Grew Up In");
		equipment.add("Pet Mouse");
		equipment.add("Token to Remember Your Parents By");
		equipment.add("Set of Common Clothes");
		equipment.add("Belt Pouch Containing 10 gp");
		
		assertEquals(equipment, testBackground.getEquip());

		assertEquals("City Secrets", testBackground.getFeature());
	}
}