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
		weapon.updateTime(time);
	}

	@Override
	public int getMaxRange()
	{
		return weapon.getMaxRange();
	}

	@Override
	public int getMaxAmmo()
	{
		return weapon.getMaxAmmo();
	}

	@Override
	public int getBaseDamage()
	{
		return weapon.getBaseDamage();
	}

	@Override
	public int getRateOfFire()
	{
		return weapon.getRateOfFire();
	}

	@Override
	public int getActualAmmo()
	{
		return weapon.getActualAmmo();
	}

	@Override
	public void relod()
	{
		weapon.relod();
	}

	@Override
	public int calculateDamage(int distence)
	{
		return weapon.calculateDamage(distence);
	}

}
