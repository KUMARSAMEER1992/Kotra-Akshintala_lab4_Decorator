package weapon;

import exceptions.AttachmentException;

public class MockAttachment extends Attachment
{

	MockAttachment(Weapon weapon) throws AttachmentException
	{
		super(weapon);
	}

	@Override
	public int fire(int distence)
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
