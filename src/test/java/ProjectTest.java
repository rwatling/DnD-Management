//package test.java;
import static org.junit.Assert.*;
import org.junit.Test;

import main.java.AbilityScore;
import main.java.SavingThrow;
import main.java.Class;
import main.java.Skill;

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
	
	
}