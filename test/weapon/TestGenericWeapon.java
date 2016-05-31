package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGenericWeapon
{

	@Test
	public void testInitilization()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 10);
		assertEquals(10, weapon.getBaseDamage());
		assertEquals(25, weapon.getMaxRange());
		assertEquals(2, weapon.getRateOfFire());
		assertEquals(10, weapon.getMaxAmmo());
		assertEquals(10, weapon.getActualAmmo());
		assertEquals(0, weapon.getFireCounter());
	}

	@Test
	public void testUseAmmo()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 10);
		assertEquals(10, weapon.getActualAmmo());
		weapon.fire(10);
		assertEquals(9, weapon.getActualAmmo());
	}

	@Test
	public void testRateOfFire()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 10);
		assertEquals(5, weapon.fire(10));
		assertEquals(5, weapon.fire(10));

		// Can not fire as for this round it completed max rate of fire.
		assertEquals(0, weapon.fire(10));

		weapon.updateTime(1);
		assertEquals(5, weapon.fire(10));
	}

	@Test
	public void testReload()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 2);
		weapon.fire(10);
		weapon.fire(10);

		assertEquals(0, weapon.getActualAmmo());
		weapon.relod();
		assertEquals(2, weapon.getActualAmmo());
	}

	@Test
	public void testOutOfAmmo()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 2);
		weapon.fire(10);
		weapon.fire(10);
		assertEquals(0, weapon.getActualAmmo());
		// returns 0 damage as out of ammo
		assertEquals(0, weapon.fire(10));
	}

	@Test
	public void testOutOfRange()
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 2);
		assertEquals(2, weapon.getActualAmmo());
		// Returns 0 as distance is more than distance.
		assertEquals(0, weapon.fire(35));
		// Actual ammo is decreased
		assertEquals(1, weapon.getActualAmmo());
	}

}
