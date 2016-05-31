package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestChainGun
{

	@Test
	public void testInitilization()
	{
		ChainGun gun = new ChainGun();
		assertEquals(15,gun.getBaseDamage());
		assertEquals(30, gun.getMaxRange());
		assertEquals(4, gun.getRateOfFire());
		assertEquals(40, gun.getMaxAmmo());
	}
	
	@Test
	public void testDamage()
	{
		ChainGun gun = new ChainGun();
		assertEquals(5, gun.fire(10));
		assertEquals(10, gun.fire(20));
		assertEquals(0, gun.fire(40));
	}

}
