package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPistol
{

	@Test
	public void test()
	{
		Pistol pistol = new Pistol();
		assertEquals(8, pistol.fire(10));
	}

}
