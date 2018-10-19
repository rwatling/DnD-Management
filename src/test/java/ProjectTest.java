//package test.java;
import static org.junit.Assert.*;
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
		intel.setMod(2);
		assertEquals(2, intel.getMod());
		intel.setProfcy(true);
		assertEquals(true, intel.getProfcy());
		assertEquals(4, intel.getMod());
	}
	
	@Test
	public void titleClassTest() {
		GameClass pali = new GameClass();
		pali.setTitle("Paladin");
		assertEquals("Paladin", pali.getTitle());
	}
	
	@Test
	public void skillGettersSettersTest() {
		Skill stealth = new Skill();
		stealth.setTitle("Stealth");
		assertEquals("Stealth", stealth.getTitle());
		stealth.setMod(2);
		assertEquals(2, stealth.getMod());
		stealth.setProfcy(true);
		assertEquals(true, stealth.getProfcy());
		assertEquals(4, stealth.getMod());
	}
	
	// INVENTORY TESTS ---------------------------------------------------------
	
	
}