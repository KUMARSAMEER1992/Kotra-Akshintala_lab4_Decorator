package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestStabilizer
{

	@Test
	public void test() throws AttachmentException
	{
		Weapon weapon = new Pistol();
		Stabilizer stabilizer = new Stabilizer(weapon);
		assertEquals(10, stabilizer.fire(10));
	}

}
