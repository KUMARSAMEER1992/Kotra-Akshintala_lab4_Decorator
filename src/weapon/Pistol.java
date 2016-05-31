package weapon;

public class Pistol extends GenericWeapon
{

	public Pistol()
	{
		/*
		 * PISTOL_BASE_DAMAGE = 10;
		 * PISTOL_MAX_RANGE = 25;
		 * PISTOL_RATE_OF_FIRE = 2;
		 * PISTOL_MAX_AMMO = 10;
		 */
		super(10, 25, 2, 10);
	}

	@Override
	public int calculateDamage(int distence)
	{
		double temp = maxRange + 5 - distence;
		temp *= baseDamage;
		temp /= maxRange;
		return (int) temp;
	}

}
