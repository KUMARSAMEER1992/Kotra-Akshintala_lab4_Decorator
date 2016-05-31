package weapon;

import exceptions.AttachmentException;

public class PowerBooster extends Attachment
{

	PowerBooster(Weapon weapon) throws AttachmentException
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
			temp = weapon.getMaxAmmo() + weapon.getActualAmmo();
			temp *= damage;
			temp /= weapon.getMaxAmmo();
			return (int) temp;
		}
	}

}
