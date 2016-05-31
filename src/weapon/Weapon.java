package weapon;

import gameplay.TimeObserver;

public interface Weapon extends TimeObserver
{

	public int getMaxRange();

	public int getMaxAmmo();

	public int getBaseDamage();

	public int getRateOfFire();

	public int getActualAmmo();

	public void relod();

	public int fire(int distence);

	public int calculateDamage(int distence);
}
