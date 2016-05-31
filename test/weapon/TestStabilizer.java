package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestStabilizer
{

	@Test
	public void testOneAttachment() throws AttachmentException
	{
		Weapon weapon = new PlasmaCannon();
		Stabilizer stabilizer = new Stabilizer(weapon);
		assertEquals(62, stabilizer.fire(10));
	}
	
	@Test
	public void testMltipleAttachment() throws AttachmentException
	{
		Weapon weapon;
		
		weapon = new PlasmaCannon();
		Scope scope=new Scope(weapon);
		Stabilizer stabilizer = new Stabilizer(scope);

		assertEquals(77, stabilizer.fire(15));
		weapon.updateTime(1);
		assertEquals(0, stabilizer.fire(35));

		weapon = new PlasmaCannon();
		stabilizer = new Stabilizer(weapon);
		Stabilizer stabilizer2=new Stabilizer(stabilizer);
		
		assertEquals(77, stabilizer2.fire(15));
		weapon.updateTime(1);
		assertEquals(0, stabilizer2.fire(35));
		
		weapon = new PlasmaCannon();
		PowerBooster booster=new PowerBooster(weapon);
		stabilizer = new Stabilizer(booster);
		
		assertEquals(108, stabilizer.fire(15));
		weapon.updateTime(1);
		assertEquals(0, stabilizer.fire(35));
		
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
