package weapon;

public class Pistol extends GenericWeapon
{

	private static final int PISTOL_BASE_DAMAGE = 10;
	private static final int PISTOL_MAX_RANGE = 25;
	private static final int PISTOL_RATE_OF_FIRE = 2;
	private static final int PISTOL_MAX_AMMO = 10;

	public Pistol()
	{
		super(PISTOL_BASE_DAMAGE, PISTOL_MAX_RANGE, PISTOL_RATE_OF_FIRE, PISTOL_MAX_AMMO);
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
