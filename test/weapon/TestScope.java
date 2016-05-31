package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestScope
{

	@Test
	public void testOneAttachment() throws AttachmentException
	{
		Weapon weapon = new Pistol();
		Scope scope = new Scope(weapon);
		assertEquals(12, scope.fire(10));
	}

	@Test
	public void testMltipleAttachment() throws AttachmentException
	{
		Weapon weapon;

		weapon = new Pistol();
		Scope scope = new Scope(weapon);
		Scope scope2 = new Scope(scope);

		assertEquals(19, scope2.fire(10));
		assertEquals(0, scope2.fire(30));

		weapon = new Pistol();
		Stabilizer stabilizer = new Stabilizer(weapon);
		scope = new Scope(stabilizer);

		assertEquals(16, scope.fire(10));
		assertEquals(0, scope.fire(30));

		weapon = new Pistol();
		PowerBooster booster = new PowerBooster(weapon);
		scope = new Scope(booster);

		assertEquals(24, scope.fire(10));
		assertEquals(0, scope.fire(30));

	}

	@Test(expected = AttachmentException.class)
	public void testMaxAttachments() throws AttachmentException
	{
		Weapon weapon = new PlasmaCannon();
		PowerBooster booster = new PowerBooster(weapon);
		Stabilizer stabilizer = new Stabilizer(booster);
		Scope scope = new Scope(stabilizer);
	}
}
