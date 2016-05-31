package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPlasmaCannon
{

	@Test
	public void testInitilization()
	{
		PlasmaCannon cannon = new PlasmaCannon();
		assertEquals(50, cannon.getBaseDamage());
		assertEquals(20, cannon.getMaxRange());
		assertEquals(1, cannon.getRateOfFire());
		assertEquals(4, cannon.getMaxAmmo());
	}
	
	@Test
	public void testDamage()
	{
		PlasmaCannon cannon = new PlasmaCannon();
		assertEquals(50, cannon.fire(10));
		cannon.updateTime(1);
		assertEquals(37, cannon.fire(20));
		cannon.updateTime(2);
		assertEquals(0, cannon.fire(30));
	}

}
