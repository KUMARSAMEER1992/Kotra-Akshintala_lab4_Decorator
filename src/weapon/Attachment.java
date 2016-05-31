package weapon;

import exceptions.AttachmentException;

public abstract class Attachment implements Weapon
{

	protected Weapon weapon;

	Attachment(Weapon weapon) throws AttachmentException
	{
		int counter = 0;
		Weapon temp = weapon;
		while (true)
		{
			if (temp instanceof Attachment)
			{
				temp = ((Attachment) temp).weapon;
				counter++;
			}
			else
			{
				break;
			}
		}

		if (counter < 2)
		{
			this.weapon = weapon;
		}
		else
		{
			throw new AttachmentException("You can add only 2 attachments");
		}
	}

	@Override
	public void updateTime(int time)
	{
	}

	@Override
	public int getMaxRange()
	{
		return 0;
	}

	@Override
	public int getMaxAmmo()
	{
		return 0;
	}

	@Override
	public int getBaseDamage()
	{
		return 0;
	}

	@Override
	public int getRateOfFire()
	{
		return 0;
	}

	@Override
	public int getActualAmmo()
	{
		return 0;
	}

	@Override
	public void relod()
	{
	}

	@Override
	public int calculateDamage(int distence)
	{
		return 0;
	}

}
