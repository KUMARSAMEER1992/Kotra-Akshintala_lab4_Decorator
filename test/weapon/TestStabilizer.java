package weapon;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestStabilizer
{

	@Test
	public void testOneAttachment() throws AttachmentException
	{
		Weapon weapon = new ChainGun();
		Stabilizer stabilizer = new Stabilizer(weapon);
		assertEquals(6, stabilizer.fire(10));
	}
	
	@Test
	public void testMltipleAttachment() throws AttachmentException
	{
		Weapon weapon = new ChainGun();
		PowerBooster booster=new PowerBooster(weapon);
		Stabilizer stabilizer = new Stabilizer(booster);
		
		assertEquals(16, stabilizer.fire(15));
		assertEquals(0, stabilizer.fire(35));
		
		weapon = new ChainGun();
		Scope scope=new Scope(weapon);
		stabilizer = new Stabilizer(scope);

		assertEquals(12, stabilizer.fire(15));
		assertEquals(0, stabilizer.fire(35));
	}
	
	@Test(expected = AttachmentException.class)
	public void testMaxAttachments() throws AttachmentException
	{
		Weapon weapon = new ChainGun();
		PowerBooster booster=new PowerBooster(weapon);
		Stabilizer stabilizer = new Stabilizer(booster);
		Scope scope=new Scope(stabilizer);
	}

}
