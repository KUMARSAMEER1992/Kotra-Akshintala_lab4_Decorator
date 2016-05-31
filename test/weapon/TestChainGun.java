package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestChainGun
{

	@Test
	public void test()
	{
		ChainGun gun = new ChainGun();
		assertEquals(5, gun.fire(10));
	}

}
