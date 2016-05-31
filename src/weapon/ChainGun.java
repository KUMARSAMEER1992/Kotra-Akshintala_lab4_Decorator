package weapon;

public class ChainGun extends GenericWeapon
{
	

	public ChainGun()
	{
		/*
		 * CHAINGUN_BASE_DAMAGE = 15;
		 * CHAINGUN_MAX_RANGE = 30;
		 * CHAINGUN_RATE_OF_FIRE = 4;
		 * CHAINGUN_MAX_AMMO = 40;
		 */
		super(15, 30, 4, 40);
	}

	@Override
	public int calculateDamage(int distence)
	{
		double temp;
		temp = baseDamage * distence;
		temp /= maxRange;
		return (int) temp;
	}

}
