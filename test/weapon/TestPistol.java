package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPistol
{

	@Test
	public void testInitilization()
	{
		Pistol pistol = new Pistol();
		assertEquals(10, pistol.getBaseDamage());
		assertEquals(25, pistol.getMaxRange());
		assertEquals(2, pistol.getRateOfFire());
		assertEquals(10, pistol.getMaxAmmo());
	}

	@Test
	public void testDamage()
	{
		Pistol pistol = new Pistol();
		assertEquals(8, pistol.fire(10));
		assertEquals(4, pistol.fire(20));
		assertEquals(0, pistol.fire(30));
	}
}
