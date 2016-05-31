package weapon;

public class MockGenericWeapon extends GenericWeapon
{

	public MockGenericWeapon(int baseDamage, int maxRange, int rateOfFire, int maxAmmo)
	{
		super(baseDamage, maxRange, rateOfFire, maxAmmo);
	}

	@Override
	public int calculateDamage(int distence)
	{
		return 5;
	}

}
