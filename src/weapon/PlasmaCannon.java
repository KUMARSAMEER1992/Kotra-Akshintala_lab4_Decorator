package weapon;

public class PlasmaCannon extends GenericWeapon
{

	public PlasmaCannon()
	{
		/*
		 * PLASMACANNON_BASE_DAMAGE = 50;
		 * PLASMACANNON_MAX_RANGE = 20;
		 * PLASMACANNON_RATE_OF_FIRE = 1;
		 * PLASMACANNON_MAX_AMMO = 4;
		 */
		super(50, 20, 1, 4);
	}

	@Override
	public int calculateDamage(int distence)
	{
		double temp;
		temp = baseDamage *(actualAmmo + 1);
		temp /=  maxAmmo;
		return (int) temp;
	}

}
