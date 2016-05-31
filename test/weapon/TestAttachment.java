package weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.AttachmentException;

public class TestAttachment
{

	@Test(expected = AttachmentException.class)
	public void testInitilization() throws AttachmentException
	{
		GenericWeapon weapon = new MockGenericWeapon(10, 25, 2, 10);
		Attachment attach = new MockAttachment(weapon);
		assertTrue(attach instanceof Weapon);
		assertEquals(weapon, attach.weapon);

		Attachment attach2 = new MockAttachment(attach);

		Attachment attch3 = new MockAttachment(attach2);

	}

}
