package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPlasmaCannon
{

	@Test
	public void test()
	{
		PlasmaCannon cannon = new PlasmaCannon();
		assertEquals(50, cannon.fire(10));
	}

}
