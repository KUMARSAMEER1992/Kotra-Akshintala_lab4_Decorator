package weapon;

import exceptions.AttachmentException;

public class Stabilizer extends Attachment
{

	Stabilizer(Weapon weapon) throws AttachmentException
	{
		super(weapon);
	}

	@Override
	public int fire(int distence)
	{
		int damage = weapon.fire(distence);
		if (damage == 0)
		{
			return 0;
		}
		else
		{
			double temp;
			temp = 1.25 * damage;
			if (weapon.getActualAmmo() == 0)
			{
				weapon.relod();
			}
			return (int) temp;
		}
	}

}
