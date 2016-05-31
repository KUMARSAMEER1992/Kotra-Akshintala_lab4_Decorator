package weapon;

import exceptions.AttachmentException;

public class Scope extends Attachment
{

	Scope(Weapon weapon) throws AttachmentException
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
			temp = 2 * weapon.getMaxRange() - distence;
			temp *= damage;
			temp /= weapon.getMaxRange();
			return (int) temp;
		}
	}

}
