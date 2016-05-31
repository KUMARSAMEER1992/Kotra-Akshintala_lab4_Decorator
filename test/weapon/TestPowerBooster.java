package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestPowerBooster
{

	@Test
	public void test() throws AttachmentException
	{
		Weapon weapon = new Pistol();
		PowerBooster booster = new PowerBooster(weapon);
		assertEquals(15, booster.fire(10));
	}

}
