package weapon;

public class ChainGun extends GenericWeapon
{
	private static final int CHAINGUN_BASE_DAMAGE = 15;
	private static final int CHAINGUN_MAX_RANGE = 30;
	private static final int CHAINGUN_RATE_OF_FIRE = 4;
	private static final int CHAINGUN_MAX_AMMO = 40;

	public ChainGun()
	{
		super(CHAINGUN_BASE_DAMAGE, CHAINGUN_MAX_RANGE, CHAINGUN_RATE_OF_FIRE, CHAINGUN_MAX_AMMO);
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
