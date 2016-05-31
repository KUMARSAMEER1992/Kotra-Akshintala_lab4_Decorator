package weapon;

public class PlasmaCannon extends GenericWeapon
{
	private static final int PLASMACANNON_BASE_DAMAGE = 50;
	private static final int PLASMACANNON_MAX_RANGE = 20;
	private static final int PLASMACANNON_RATE_OF_FIRE = 1;
	private static final int PLASMACANNON_MAX_AMMO = 4;

	public PlasmaCannon()
	{
		super(PLASMACANNON_BASE_DAMAGE, PLASMACANNON_MAX_RANGE, PLASMACANNON_RATE_OF_FIRE, PLASMACANNON_MAX_AMMO);
	}

	@Override
	public int calculateDamage(int distence)
	{
		double temp;
		temp = baseDamage * maxAmmo;
		temp /= actualAmmo + 1;
		return (int) temp;
	}

}
