package lifeform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import environment.Range;
import gameplay.TimeObserver;
import weapon.GenericWeapon;
import weapon.MockGenericWeapon;
import weapon.Pistol;
import weapon.Weapon;

/**
 * The test cases for the LifeForm class.
 * @author : Sameer Kumar Kotra
 */
public class TestLifeForm
{

	/**
	 * Tests the lifeForm can pickup only one Weapon.
	 */
	@Test
	public void TestCanPickupWeapon()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		Weapon weapon = new Pistol();
		entity.pickUp(weapon);

		assertEquals(weapon, entity.getWeapon());

		Weapon weapon1 = new Pistol();
		entity.pickUp(weapon1);
		// Can not pick weapon1 as weapon is already there.
		assertEquals(weapon, entity.getWeapon());

		entity.dropWeapon();
		// Null as it dropped the weapon.
		assertNull(entity.getWeapon());
	}

	/**
	 * Use weapon as it has Ammo.
	 */
	@Test
	public void TestUseWeapon()
	{
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30, 10);

		Pistol pistol = new Pistol();
		lifeForm1.pickUp(pistol);

		lifeForm1.attack(lifeForm2);
		assertEquals(18, lifeForm2.getCurrentLifePoints());

	}

	/**
	 * Test when weapon has 0 Ammo.
	 */
	@Test
	public void TestDamage()
	{
		// Weapon with 0 Ammo.
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 0);
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30, 10);

		lifeForm1.pickUp(weapon);

		lifeForm1.attack(lifeForm2);
		// Use strength to attack as it has 0 Ammo.
		assertEquals(20, lifeForm2.getCurrentLifePoints());

		Range.distance = 20;
		lifeForm1.attack(lifeForm2);
		// No damage as the Target is out of range.
		assertEquals(20, lifeForm2.getCurrentLifePoints());
		Range.distance = 0;
	}

	/**
	 * Test weather the Weapon can reload.
	 */
	@Test
	public void TestReload()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 2);
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30, 10);

		lifeForm1.pickUp(weapon);

		lifeForm1.attack(lifeForm2);
		lifeForm1.attack(lifeForm2);

		assertEquals(0, lifeForm1.getWeapon().getActualAmmo());
		lifeForm1.reload();
		assertEquals(2, lifeForm1.getWeapon().getActualAmmo());
	}

	/**
	 * Old tests Observer pattern.
	 * Test the Strength of the LifeForm.
	 */
	@Test
	public void testLifeStrength()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 10);
		// Test getAttachStrength
		assertEquals(10, entity.getAttachStrength());
		entity = new MockLifeForm("Bob", 40, -10);
		assertEquals(0, entity.getAttachStrength());
	}

	/**
	 * Test the attack method of the LifeForm.
	 */
	@Test
	public void testAttack()
	{
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		LifeForm lifeForm2 = new MockLifeForm("Alice", 30, 10);

		lifeForm1.attack(lifeForm2);
		// lifeForm2 decreases from 30 to 20.
		assertEquals(20, lifeForm2.getCurrentLifePoints());

		lifeForm1.currentLifePoints = 0;

		lifeForm1.attack(lifeForm2);
		// lifeForm2 remains 20 as lifeForm1 id dead.
		assertEquals(20, lifeForm2.getCurrentLifePoints());
	}

	/**
	 * Test weather lifeForm can track time..
	 */
	@Test
	public void testTrackTime()
	{
		LifeForm lifeForm1 = new MockLifeForm("Bob", 40, 10);
		assertTrue(lifeForm1 instanceof TimeObserver);
	}

	/**
	 * Old tests for Strategy pattern.
	 * Test the initialization of the LifeForm.
	 */
	@Test
	public void testInitialization()
	{
		LifeForm entity = new MockLifeForm("Bob", 40);
		assertEquals("Bob", entity.getName());
		assertEquals(40, entity.getCurrentLifePoints());

		entity = new MockLifeForm("Bob", -40);
		assertEquals("Bob", entity.getName());
		// LifeForm can not have negative life points so it should have 0.
		assertEquals(0, entity.getCurrentLifePoints());
	}

	/**
	 * Test the takeHit cases of the LifeForm.
	 */
	@Test
	public void testTakeHit()
	{
		LifeForm entity = new MockLifeForm("Bob", 50);

		// Take first hit.
		entity.takeHit(20);
		assertEquals(30, entity.getCurrentLifePoints());

		// Take hit when 0<current life points.
		entity.takeHit(30);
		assertEquals(0, entity.getCurrentLifePoints());

		// Take hit when life points is 0.
		entity.takeHit(10);
		assertEquals(0, entity.getCurrentLifePoints());

		// Can not take hit with negative damage points.
		entity.takeHit(-20);
		assertEquals(0, entity.getCurrentLifePoints());
	}

}