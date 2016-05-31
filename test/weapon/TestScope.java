package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestScope
{

	@Test
	public void test() throws AttachmentException
	{
		Weapon weapon = new Pistol();
		Scope scope = new Scope(weapon);
		assertEquals(12, scope.fire(10));
	}

}
