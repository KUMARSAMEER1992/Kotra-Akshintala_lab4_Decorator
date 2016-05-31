package weapon;

public abstract class GenericWeapon implements Weapon
{

	protected int baseDamage;
	protected int maxRange;
	protected int rateOfFire;
	protected int maxAmmo;
	protected int actualAmmo;
	private int fireCounter;

	public GenericWeapon(int baseDamage, int maxRange, int rateOfFire, int maxAmmo)
	{
		this.baseDamage = baseDamage;
		this.maxRange = maxRange;
		this.rateOfFire = rateOfFire;
		this.maxAmmo = maxAmmo;
		actualAmmo = maxAmmo;
		fireCounter = 0;
	}

	@Override
	public int getMaxRange()
	{
		return maxRange;
	}

	@Override
	public int getMaxAmmo()
	{
		return maxAmmo;
	}

	@Override
	public int getBaseDamage()
	{
		return baseDamage;
	}

	@Override
	public int getRateOfFire()
	{
		return rateOfFire;
	}

	@Override
	public int getActualAmmo()
	{
		return actualAmmo;
	}

	@Override
	public void relod()
	{
		actualAmmo = maxAmmo;
	}

	@Override
	public int fire(int distence)
	{
		if (actualAmmo > 0)
		{
			// Conform
			actualAmmo--;
			if (distence <= maxRange && fireCounter < rateOfFire)
			{
				fireCounter++;
				return calculateDamage(distence);
			}
			else
			{
				return 0;
			}
		}
		return 0;
	}

	public int getFireCounter()
	{
		return fireCounter;
	}

	@Override
	public void updateTime(int time)
	{
		fireCounter = 0;
	}

}
