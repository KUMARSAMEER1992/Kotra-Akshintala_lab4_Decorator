package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestPowerBooster
{

	@Test
	public void testOneAttachment() throws AttachmentException
	{
		Weapon weapon = new PlasmaCannon();
		PowerBooster booster = new PowerBooster(weapon);
		assertEquals(87, booster.fire(10));
	}

	@Test
	public void testMltipleAttachment() throws AttachmentException
	{
		Weapon weapon = new PlasmaCannon();
		Stabilizer stabilizer =new Stabilizer(weapon);
		PowerBooster booster = new PowerBooster(stabilizer);
		assertEquals(108, booster.fire(10));
		assertEquals(0, booster.fire(25));
		
		weapon = new PlasmaCannon();
		Scope scope=new Scope(weapon);
		booster = new PowerBooster(scope);
		assertEquals(131, booster.fire(10));
		assertEquals(0, booster.fire(25));
	}
	
	@Test(expected = AttachmentException.class)
	public void testMaxAttachments() throws AttachmentException
	{
		Weapon weapon = new PlasmaCannon();
		PowerBooster booster=new PowerBooster(weapon);
		Stabilizer stabilizer = new Stabilizer(booster);
		Scope scope=new Scope(stabilizer);
	}
}
